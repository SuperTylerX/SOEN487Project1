package servlet;

import impl.RepositoryManagerImpl;
import interfacedef.RepositoryManager;
import model.Artist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;

@WebServlet(name = "servlet.ArtistController")
public class ArtistController extends HttpServlet {

    // Create new artist
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        RepositoryManager manager = RepositoryManagerImpl.getInstance();

        String nickname = request.getParameter("nickname");
        String firstName = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String bio = request.getParameter("bio");

        if (nickname == null || firstName == null || lastname == null || bio == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            pw.println("Missing parameters");
            return;
        }

        Artist artist = new Artist(nickname, firstName, lastname, bio);
        manager.addArtist(artist);
        pw.println("Artist Added successfully");
    }


    // Get artists
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
        RepositoryManager manager = RepositoryManagerImpl.getInstance();
        String nickname = request.getParameter("nickname");
        if (nickname == null) {
            //list all the artists
            String output = manager.getArtists().stream().map(Objects::toString).collect(Collectors.joining(".\n"));
            pw.println(output);
        } else {
            // find the artist
            Artist artist = manager.getArtist(nickname);
            if (artist == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                pw.println("Artist not found");
            } else {
                pw.println(artist.toString());
            }
        }
    }

    // Update
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        RepositoryManager manager = RepositoryManagerImpl.getInstance();
        String body = getBodyString(request);
        String[] pairs = body.split("&");
        HashMap<String, String> postInfoMap = new HashMap<>();
        for (String pair : pairs) {
            String[] fields = pair.split("=");
            postInfoMap.put(fields[0], URLDecoder.decode(fields[1], "UTF-8"));
        }

        String nickname = postInfoMap.get("nickname");
        String firstName = postInfoMap.get("firstname");
        String lastname = postInfoMap.get("lastname");
        String bio = postInfoMap.get("bio");

        Artist artist = new Artist(nickname, firstName, lastname, bio);
        boolean flag = manager.updateArtist(artist);
        if (flag) {
            pw.println("Artist updated successfully!");
        } else {
            pw.println("Artist not found");
        }
    }

    // Delete artist
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        RepositoryManager manager = RepositoryManagerImpl.getInstance();
        String body = getBodyString(request);
        String[] pairs = body.split("&");
        HashMap<String, String> postInfoMap = new HashMap<>();
        for (String pair : pairs) {
            String[] fields = pair.split("=");
            postInfoMap.put(fields[0], URLDecoder.decode(fields[1], "UTF-8"));
        }

        String nickname = postInfoMap.get("nickname");

        boolean flag = manager.removeArtist(nickname);
        if (flag) {
            pw.println("Artist deleted successfully!");
        } else {
            pw.println("Artist not found");
        }
    }


    protected String getBodyString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader;
        try {
            reader = request.getReader();
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
                String body = sb.toString();
                return body.trim();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            return "";
        }
        return "";
    }
}

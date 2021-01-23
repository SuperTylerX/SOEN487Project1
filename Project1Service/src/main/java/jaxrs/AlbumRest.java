package jaxrs;

import impl.RepositoryManagerImpl;
import interfacedef.RepositoryManager;
import model.Album;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Objects;
import java.util.stream.Collectors;


@Path("album")
public class AlbumRest {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAlbums() {
        RepositoryManager manager = RepositoryManagerImpl.getInstance();
        return manager.getAlbums().stream().map(Objects::toString).collect(Collectors.joining(".\n"));
    }


    @GET
    @Path("{isrc}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAlbum(@PathParam("isrc") String isrc) {
        RepositoryManager manager = RepositoryManagerImpl.getInstance();
        return manager.getAlbum(isrc).toString();
    }


    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public String addAlbum(@FormParam("isrc") String ISRC, @FormParam("title") String title,
                           @FormParam("description") String description, @FormParam("year") int year,
                           @FormParam("artist") String artist) {
        Album newAlbum = new Album(ISRC, title, description, year, artist);
        RepositoryManager manager = RepositoryManagerImpl.getInstance();
        manager.addAlbum(newAlbum);
        return "Album Added successfully";
    }


    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateAlbum(@FormParam("isrc") String ISRC, @FormParam("title") String title,
                              @FormParam("description") String description, @FormParam("year") int year,
                              @FormParam("artist") String artist) {
        Album newAlbum = new Album(ISRC, title, description, year, artist);
        RepositoryManager manager = RepositoryManagerImpl.getInstance();
        boolean flag = manager.updateAlbum(newAlbum);
        if (flag) {
            return "Album updated successfully";
        } else {
            return "Album not found";
        }
    }


    @DELETE
    @Path("delete/{isrc}")
    public String removeAlbum(@PathParam("isrc") String isrc) {
        RepositoryManager manager = RepositoryManagerImpl.getInstance();
        boolean flag = manager.removeAlbum(isrc);
        if (flag) {
            return "Album deleted successfully";
        } else {
            return "Album not found";
        }
    }
}

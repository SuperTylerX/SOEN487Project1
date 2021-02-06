import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArtistClient {
    public static final String TOMCAT_SERVLET_URL = "http://localhost:8081/Project1Service_war/artists";
    //get
    public void get_all_artist() throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(TOMCAT_SERVLET_URL);
        request.addHeader("User-Agent", "Mozilla/5.0");
        HttpResponse response = client.execute(request);
        System.out.println("Sending 'GET' request to URL");
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line).append("\r\n");
        }
        System.out.println(result.toString());
    }

    //get
    public void get_artist_by_nickname(String nickname) throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(TOMCAT_SERVLET_URL + "?nickname=" + nickname);
        request.addHeader("User-Agent", "Mozilla/5.0");
        HttpResponse response = client.execute(request);
        System.out.println("Sending 'GET' request to URL");
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line).append("\r\n");
        }
        System.out.println(result.toString());
    }

    //post
    public void create_new_artist(String nickname, String firstname, String lastname, String bio) throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(TOMCAT_SERVLET_URL);
        post.setHeader("User-Agent", "Mozilla/5.0");
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("nickname", nickname));
        urlParameters.add(new BasicNameValuePair("firstname", firstname));
        urlParameters.add(new BasicNameValuePair("lastname", lastname));
        urlParameters.add(new BasicNameValuePair("bio", bio));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        HttpResponse response = client.execute(post);
        System.out.println("Sending 'POST' request to URL");
        System.out.println("Post parameters: " + post.getEntity());
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line).append("\r\n");
        }
        System.out.println(result.toString());

    }

    //put
    public void update_artist(String nickname, String firstname, String lastname, String bio) throws Exception {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPut httpPut = new HttpPut(TOMCAT_SERVLET_URL);

            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            urlParameters.add(new BasicNameValuePair("nickname", nickname));
            urlParameters.add(new BasicNameValuePair("firstname", firstname));
            urlParameters.add(new BasicNameValuePair("lastname", lastname));
            urlParameters.add(new BasicNameValuePair("bio", bio));

            httpPut.setEntity(new UrlEncodedFormEntity(urlParameters));

            System.out.println("Executing PUT request " + httpPut.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPut, responseHandler);
            System.out.println(responseBody);
        }
    }

    //delete
    public void del_artist_by_nickname(String nickname) throws Exception {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete(TOMCAT_SERVLET_URL + "?nickname=" + nickname);
            System.out.println("Executing request " + httpDelete.getRequestLine());
            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpDelete, responseHandler);

            System.out.println(responseBody);
        }
    }
}

package jaxrs;

import impl.RepositoryManagerImpl;
import interfacedef.RepositoryManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Objects;
import java.util.stream.Collectors;


@Path("album")
public class AlbumRest {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        RepositoryManager manager = RepositoryManagerImpl.getInstance();
        return manager.getAlbums().stream().map(Objects::toString).collect(Collectors.joining(".\n"));
    }


}

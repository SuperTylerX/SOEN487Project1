import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface RepositoryManager {

    public void addArtist(Artist artist);

    public boolean removeArtist(String nickname);

    public Artist getArtist(String nickname);

    public List<Artist> getArtists();

    public void updateArtist(Artist artist);


    public void addAlbum(Album album);

    public boolean removeAlbum(String isrc);

    public Artist getAlbum(String isrc);

    public List<Artist> getAlbums();

    public void updateAlbum(Album album);

}

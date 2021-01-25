package interfacedef;

import model.Album;
import model.Artist;

import java.util.List;

public interface RepositoryManager {

    void addArtist(Artist artist);

    boolean removeArtist(String nickname);

    Artist getArtist(String nickname);

    List<Artist> getArtists();

    boolean updateArtist(Artist artist);


    void addAlbum(Album album);

    boolean removeAlbum(String isrc);

    Album getAlbum(String isrc);

    List<Album> getAlbums();

    boolean updateAlbum(Album album);

}

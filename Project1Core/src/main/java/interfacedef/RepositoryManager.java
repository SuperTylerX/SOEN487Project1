package interfacedef;

import model.Album;
import model.Artist;

import java.util.List;

public interface RepositoryManager {

    public void addArtist(Artist artist);

    public boolean removeArtist(String nickname);

    public Artist getArtist(String nickname);

    public List<Artist> getArtists();

    public boolean updateArtist(Artist artist);


    public void addAlbum(Album album);

    public boolean removeAlbum(String isrc);

    public Artist getAlbum(String isrc);

    public List<Artist> getAlbums();

    public boolean updateAlbum(Album album);

}

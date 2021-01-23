package impl;

import interfacedef.*;
import model.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RepositoryManagerImpl implements RepositoryManager {

    private List<Album> albums = new CopyOnWriteArrayList<>();
    private List<Artist> artists = new CopyOnWriteArrayList<>();
    private static final RepositoryManagerImpl single_instance = new RepositoryManagerImpl();

    public static RepositoryManagerImpl getInstance() {
        return single_instance;
    }

    @Override
    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    @Override
    public boolean removeArtist(String nickname) {
        for (int i = 0; i < artists.size(); i++) {
            if (artists.get(i).getNickname().equals(nickname)) {
                artists.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Artist getArtist(String nickname) {
        for (Artist artist : artists) {
            if (artist.getNickname().equals(nickname)) {
                return artist.clone();
            }
        }
        return null;
    }

    @Override
    public List<Artist> getArtists() {
        // TODO:
        return null;
    }

    @Override
    public boolean updateArtist(Artist artist) {
        // TODO:
        return true;
    }

    @Override
    public void addAlbum(Album album) {
        // TODO:
    }

    @Override
    public boolean removeAlbum(String isrc) {
        // TODO:
        return false;
    }

    @Override
    public Artist getAlbum(String isrc) {
        // TODO:
        return null;
    }

    @Override
    public List<Artist> getAlbums() {
        // TODO:
        return null;
    }

    @Override
    public boolean updateAlbum(Album album) {
        // TODO:
        return true;
    }

}

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RepositoryManagerImpl implements RepositoryManager {

    private List<Album> albums = new CopyOnWriteArrayList<>();
    private List<Artist> artists = new CopyOnWriteArrayList<>();
    private static final RepositoryManagerImpl single_instance = new RepositoryManagerImpl();

    public static RepositoryManagerImpl getInstance() {
        return single_instance;
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public boolean removeArtist(String nickname) {
        for (int i = 0; i < artists.size(); i++) {
            if (artists.get(i).getNickname().equals(nickname)) {
                artists.remove(i);
                return true;
            }
        }
        return false;
    }

    public Artist getArtist(String nickname) {
        for (int i = 0; i < artists.size(); i++) {
            if (artists.get(i).getNickname().equals(nickname)) {
                return artists.get(i);
            }
        }
        return null;
    }

    public List<Artist> getArtists() {

    }

}

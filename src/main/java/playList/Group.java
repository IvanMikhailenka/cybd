package playList;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 09.11.2016.
 */
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Set<Artist> artists = new HashSet<Artist>();


    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Set<Album> albums = new HashSet<Album>();

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Set<Song> songs = new HashSet<Song>();

    public Group() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}

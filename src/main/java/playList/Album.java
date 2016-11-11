package playList;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 09.11.2016.
 */
@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int albumId;

    @Column(name = "album_name")
    private String albumName;

    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    private Set<Song> songs = new HashSet<Song>();

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = true)
    private Group group;

    public Album() {
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

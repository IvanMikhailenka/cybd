package playList;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 1 on 03.11.2016.
 */
@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "song_title")
    private String songTitle;

    @Column(name = "song_duration")
    private double songDuration;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = true)
    private Album album;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = true)
    private Group group;

    @ManyToMany()
    @JoinTable(name = "song_genre",
            joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
    private Set<Genre> genres;

    public Song() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public double getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(double songDuration) {
        this.songDuration = songDuration;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return songTitle + '\'' +
                ", Duration:" + songDuration + "  " + genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (id != song.id) return false;
        if (Double.compare(song.songDuration, songDuration) != 0) return false;
        if (album != null ? !album.equals(song.album) : song.album != null) return false;
        if (genres != null ? !genres.equals(song.genres) : song.genres != null) return false;
        if (group != null ? !group.equals(song.group) : song.group != null) return false;
        if (songTitle != null ? !songTitle.equals(song.songTitle) : song.songTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (songTitle != null ? songTitle.hashCode() : 0);
        temp = Double.doubleToLongBits(songDuration);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (album != null ? album.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        return result;
    }
}

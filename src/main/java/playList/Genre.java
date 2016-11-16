package playList;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 1 on 03.11.2016.
 */
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "genre_name", unique = true)
    private String genreName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres")
    private Set<Song> songSet;


    public Genre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Set<Song> getSongSet() {
        return songSet;
    }

    public void setSongSet(Set<Song> songSet) {
        this.songSet = songSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (id != genre.id) return false;
        if (genreName != null ? !genreName.equals(genre.genreName) : genre.genreName != null) return false;
        if (songSet != null ? !songSet.equals(genre.songSet) : genre.songSet != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (genreName != null ? genreName.hashCode() : 0);
        result = 31 * result + (songSet != null ? songSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}

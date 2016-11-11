package playList;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 09.11.2016.
 */
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "artist_name")
    private String artistName;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = true)
    private Group group;


    public Artist() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


}

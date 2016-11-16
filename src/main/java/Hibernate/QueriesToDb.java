package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import playList.Genre;
import playList.Song;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Ivan on 27.07.2016.
 */
public class QueriesToDb {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session = sessionFactory.openSession();

    public static void main(String... args){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Song> songList = new ArrayList<Song>();
        List<Genre> genreList = new ArrayList<>();
        try {
            session.beginTransaction();

/*            Song song = new Song();
            Genre rock = new Genre();
            Genre metal = new Genre();
            metal.setGenreName("metal");
            rock.setGenreName("Rock");
            Set<Genre> genreSet = new HashSet<>();
            genreSet.add(rock);
            genreSet.add(metal);
            song.setSongTitle("Du_Hast");
            song.setSongDuration(3.22);
            song.setGenres(genreSet);
            session.save(rock);
            session.save(metal);
            session.save(song);*/
            //Genre genre = new Genre();
            //genre.setGenreName("metal");
            Query query = session.createQuery("select g from Genre as g inner join g.songSet song where song.id = 3");
            genreList = query.list();
           // genre = (Genre) session.get(Genre.class, genre.getGenreName());
           // System.out.println(genre);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        for(Genre genre: genreList){
            System.out.println(genre.toString());
        }
        for(Song song: songList){
            System.out.println(song.toString());
        }
    }
    public static List<Song> getAllSongs(){
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Song as s");
            return query.list();
        }finally {
            session.getTransaction().commit();
        }
    }
    public static void setNewSong(Song song){
        session.beginTransaction();
        session.save(song);
        session.getTransaction().commit();
    }
    public static void setGenre(Genre genre){
        session.beginTransaction();
        String setGenreName = genre.getGenreName();
        Query query = session.createQuery("from Genre as g where g.genreName = ?");
        query.setParameter(0,setGenreName);
        List<Genre> genreList = new ArrayList<>(query.list());
        if(genreList.isEmpty()) {
            session.save(genre);
        }
        session.getTransaction().commit();
    }

}

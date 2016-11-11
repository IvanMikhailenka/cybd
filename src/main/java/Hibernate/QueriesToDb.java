package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import playList.Genre;
import playList.Song;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ivan on 27.07.2016.
 */
public class QueriesToDb {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session = sessionFactory.openSession();

    public static void main(String... args){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
//        List<Song> songList = new ArrayList<Song>();
//        try {
//            session.beginTransaction();
//            //Query query = session.createQuery("from Song as s  where s.id = 1");
//            //songList = query.list();
//            Song song = new Song();
//            song.setSongTitle("someSong");
//            song.setSongDuration(3.22);
//            session.save(song);
//            session.getTransaction().commit();
//        }
//        finally {
//            session.close();
//        }
//
//        for(Song song: songList){
//            System.out.println(song.toString());
//        }
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

package servlets;

import Hibernate.QueriesToDb;
import playList.Genre;
import playList.Song;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 1 on 10.11.2016.
 */
@WebServlet(urlPatterns = "/page")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Song> songs = new ArrayList<>(QueriesToDb.getAllSongs());
        response.setContentType("text/html");
        request.setAttribute("songList", songs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/mainPage.jsp");
        dispatcher.forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     /*   response.setContentType("text/html");
        String name = request.getParameter("name");
        Double duration = Double.valueOf(request.getParameter("duration"));
        String genreName = request.getParameter("genre");
        Genre genre = new Genre();
        genre.setGenreName(genreName);
        Set<Genre> genreSet= new HashSet<>();

        Song song = new Song();
        song.setSongDuration(duration);
        song.setSongTitle(name);
       // song.setGenres(genreSet);
        Set<Song> songSet = new HashSet<>();
        songSet.add(song);

//        genre.setSongSet(songSet);
        genreSet.add(genre);

        //QueriesToDb.setGenre(genre);
        QueriesToDb.setNewSong(song);
        List<Song> songs = new ArrayList<>(QueriesToDb.getAllSongs());
        request.setAttribute("songList", songs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/mainPage.jsp");
        dispatcher.forward(request, response);
*/

    }
}

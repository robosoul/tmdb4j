package test;

import java.util.List;

import com.tmdb4j.beans.model.LanguageBean;
import com.tmdb4j.beans.model.MovieBean;
import com.tmdb4j.beans.model.lists.MovieCastsBean;
import com.tmdb4j.beans.model.lists.MoviesListBean;
import com.tmdb4j.core.TMDb;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TMDb tmdb = new TMDb("<API KEY>");
   
        MovieBean movie = pickMovie(tmdb);
        MovieCastsBean cast = tmdb.getMovieCasts(movie.getId());
            
        while (!isEnglishSpokenLanguage(movie)) {
            movie = pickMovie(tmdb);
            cast = tmdb.getMovieCasts(movie.getId());                
        }
        
        System.out.println(cast);
        
    }
    
    public static void printMoviesList(TMDb tmdb) {
        MoviesListBean moviesList = tmdb.searchMovies("star", 1, null, null, null);
        
        int page = moviesList.getPage();
        int totalPages = moviesList.getTotalPages();
        
        printMoviesList(moviesList.getResults());
        
        for (int i = page + 1; i < totalPages; ++i) {
            moviesList = tmdb.searchMovies("star", i, null, null, null);
            printMoviesList(moviesList.getResults());
        }
    }
    
    public static void printMoviesList(List<MovieBean> movies) {        
        for (MovieBean movie : movies) {
            System.out.println(movie.getTitle() + " (" + movie.getVoteAverage() + ")");
        }
        
        System.out.println("");
    }
    
    public static MovieBean pickMovie(TMDb tmdb) {
        MovieBean movie = tmdb.getRandomTopRatedMovie();
        movie = tmdb.getMovieInfo(movie.getId());
        
        return movie;
    }
    
    public static boolean isEnglishSpokenLanguage(MovieBean movie) {
        for (LanguageBean language : movie.getSpokenLanguages()) {
            if (language.getIsoCode().equals("en")) {
                return true;
            }
        }
        
        return false;
    }
}

package com.soulware.tmbd4j.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.soulware.tmdb4j.beans.model.GenreBean;
import com.soulware.tmdb4j.beans.model.LanguageBean;
import com.soulware.tmdb4j.beans.model.MovieBean;
import com.soulware.tmdb4j.beans.model.MovieCastBean;
import com.soulware.tmdb4j.beans.model.MovieCrewBean;
import com.soulware.tmdb4j.beans.model.ProductionCompanyBean;
import com.soulware.tmdb4j.beans.model.lists.MovieCastsBean;
import com.soulware.tmdb4j.beans.model.lists.MoviesListBean;
import com.soulware.tmdb4j.core.TMDb;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TMDb tmdb = new TMDb("e4286ac8d5eb58b06576ac15d1c0e644");

        int i = 0;
        while (++i < 5) {
            try {
                MovieBean movie = pickMovie(tmdb);
                MovieCastsBean cast = tmdb.getMovieCasts(movie.getId());
                
                Date releseDate = null;
                SimpleDateFormat format = new SimpleDateFormat("MMMM d, yyyy");
                
                try {
                    releseDate = new SimpleDateFormat("yyyy-MM-dd").parse(movie.getReleaseDate());
                } catch (ParseException e) {
                    releseDate = null;
                }
                
                System.out.println("Title: " + movie.getTitle());
                System.out.println("Released on: " + format.format(releseDate));
                System.out.println("Tagline: " + movie.getTagline());
                System.out.println("Leading role: " + getLeadingRole(cast.getCast()));
                System.out.println("Director(s): " + getDirector(cast.getCrew()));
                System.out.println("Genre(s): " + getGenres(movie));
                System.out.println("Companies(s): " + getCompanies(movie));
                
                System.out.println("\n");            
                
            } catch (IOException ex) {
    
            }
        }
    }
    
    public static String getCompanies(MovieBean movie) {
        StringBuilder companies = new StringBuilder();
        
        boolean isFirst = true;
        for (ProductionCompanyBean company : movie.getProductionCompanies()) {
            if (isFirst) {
                isFirst = false;
            } else {
                companies.append(", ");
            }
            
            companies.append(company.getName());
            
        }
        
        return companies.toString();
    }
    
    public static String getGenres(MovieBean movie) {
        StringBuilder genres = new StringBuilder();
        
        boolean isFirst = true;
        for (GenreBean genre : movie.getGenres()) {
            if (isFirst) {
                isFirst = false;
            } else {
                genres.append(", ");
            }
            
            genres.append(genre.getName());
            
        }
        
        return genres.toString();
    }
    
    public static String getDirector(List<MovieCrewBean> crew) {
        StringBuilder directors = new StringBuilder();
        
        boolean isFirst = true;
        for (MovieCrewBean c : crew) {
            if (!c.getJob().equals("Director")) {
                continue;
            }
            
            if (!isFirst) {
                directors.append(", ");
            } else {
                isFirst = false;
            }
            
            directors.append(c.getName());
        }
        
        return directors.toString();
    }
    
    public static String getLeadingRole(List<MovieCastBean> cast) {
        return cast.get(0).getName();
    }
    
    public static void printMoviesList(TMDb tmdb) throws IOException {
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

    public static MovieBean searchMovie(TMDb tmdb, String what) throws IOException {
        MovieBean movie = tmdb.searchMovies(what, 1, null, false, null).getResults().get(0);
        movie = tmdb.getMovieInfo(movie.getId());
        
        return movie;
    }
    
    public static MovieBean pickMovie(TMDb tmdb) throws IOException {
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

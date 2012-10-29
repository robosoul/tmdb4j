package com.soulware.tmbd4j.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.soulware.tmdb4j.beans.model.MovieBean;
import com.soulware.tmdb4j.beans.model.lists.MovieAlternativeTitlesBean;
import com.soulware.tmdb4j.beans.model.lists.MoviesListBean;
import com.soulware.tmdb4j.core.TMDb;

public class TMDBTest {
    public static final Logger log = Logger.getLogger(TMDBTest.class);

    public static final String TMDB_API_KEY = "e4286ac8d5eb58b06576ac15d1c0e644";
    
    public static final String MATRIX_TITLE = "The Matrix";
    public static final String MATRIX_TAGLINE = "Welcome to the Real World.";
    public static final int MATRIX_ID = 603;
    
    private static final TMDb tmdb = new TMDb(TMDB_API_KEY);
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass 
    public static void tearDownClass() {
        
    }
    
    @BeforeMethod
    public void setUp() {
        
    }
    
    @AfterMethod
    public void tearDown() {
        
    }
    
    @Test
    public void testSearchMovie() throws IOException {
        log.info("Testing tmdb search movies...");
        MoviesListBean movies = tmdb.searchMovies("Matrix", 1, "en", false, null);        
        Assert.assertTrue(movies.getResults().size() > 0, "No movies found, expected at least 1.");
        
        movies = tmdb.searchMovies("Star+Wars", 1, "en", false, null);
        Assert.assertTrue(movies.getResults().size() >= 15, "Not enough movies found, should be over 15, found: " + movies.getResults().size());
    }
    
    @Test
    public void testGetMovieInfo() throws IOException {
        log.info("Testing tmdb get movie info...");
        
        MovieBean movie = tmdb.getMovieInfo(MATRIX_ID);        
        Assert.assertEquals(movie.getOriginalTitle(), MATRIX_TITLE, "Incorrect movie info.");        
        Assert.assertEquals(movie.getTagline(),       MATRIX_TAGLINE, "Incorrect tagline.");
    }  
    
    @Test
    public void testGetMovieAlternativeTitles() throws IOException {
        log.info("Testing tmdb get alternative movie info...");
        
        MovieAlternativeTitlesBean alternativeTitles = 
                tmdb.getMovieAlternativeTitles(MATRIX_ID);
        
        Assert.assertTrue(alternativeTitles.getTitles().size() > 3);
    }
}

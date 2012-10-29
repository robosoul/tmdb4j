package com.soulware.tmbd4j.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.soulware.tmdb4j.beans.model.ConfigurationBean;
import com.soulware.tmdb4j.beans.model.MovieBean;
import com.soulware.tmdb4j.beans.model.lists.MoviesListBean;
import com.soulware.tmdb4j.core.TMDb;

public class TMDBTest {
    public static final String TMDB_API_KEY = "e4286ac8d5eb58b06576ac15d1c0e644";
    
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
        MoviesListBean movies = tmdb.searchMovies("Matrix", 1, "en", false, null);
        
        Assert.assertTrue(movies.getResults().size() > 0, "No movies found, expected at least 1.");
    }
}

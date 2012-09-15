/**
 * Copyright 2012 Luka Obradovic.
 */
/**
 * This file is part of TMDb API support for JAVA - tmdb4j.
 *
 * TMDb API support for JAVA - tmdb4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TMDb API support for JAVA - tmdb4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TMDb API support for JAVA - tmdb4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tmdb4j.core;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.tmdb4j.beans.model.CompanyBean;
import com.tmdb4j.beans.model.MovieBean;
import com.tmdb4j.beans.model.PersonBean;

import com.tmdb4j.beans.model.lists.CollectionImagesBean;
import com.tmdb4j.beans.model.lists.CollectionInfoBean;
import com.tmdb4j.beans.model.lists.CompanyMoviesBean;
import com.tmdb4j.beans.model.lists.GenreListBean;
import com.tmdb4j.beans.model.lists.GenreMoviesBean;
import com.tmdb4j.beans.model.lists.MovieAlternativeTitlesBean;
import com.tmdb4j.beans.model.lists.MovieCastsBean;
import com.tmdb4j.beans.model.lists.MovieImagesBean;
import com.tmdb4j.beans.model.lists.MovieKeywordsBean;
import com.tmdb4j.beans.model.lists.MovieReleaseInfoBean;
import com.tmdb4j.beans.model.lists.MovieTrailersBean;
import com.tmdb4j.beans.model.lists.MovieTranslationsBean;
import com.tmdb4j.beans.model.lists.MoviesListBean;
import com.tmdb4j.beans.model.lists.PersonCreditsBean;
import com.tmdb4j.beans.model.lists.PersonImagesBean;
import com.tmdb4j.beans.model.lists.PersonsListBean;

import com.tmdb4j.service.data.TMDbApiService;
import com.tmdb4j.service.data.TMDbApiURL;
import com.tmdb4j.service.data.TMDbApiURLParameter;

/**
 * Class that represents TMDb. Enables all of the API requests.
 * 
 * @author Luka Obradovic, 2012
 * 
 */
public class TMDb {
    public static final Logger log = Logger.getLogger(TMDb.class);
    
    private Random generator;
    private TMDbApiURLParameter paramApiKey;
    
    private int popularMoviesTotalPages;
    private int topRatedMoviesTotalPages;
 
    public TMDb(String apiKey) {
        generator = new Random(System.currentTimeMillis());
        
        this.paramApiKey = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.API_KEY_PARAMETER, apiKey);
        
        topRatedMoviesTotalPages = 0;
    }   
    
    /*
     * Search
     *  - Movies
     *  - People
     *  - Companies
     */
    /**
     * This is a good starting point to start finding movies on TMDb. The idea 
     * is to be a quick and light method so you can iterate through movies quickly.
     * 
     * {@link http://help.themoviedb.org/kb/api/search-movies}
     * 
     * @param url search URL
     * @return object of class MoviesListBean, containing movies specified by search
     */
    public MoviesListBean searchMovies(URL url) {
        return get(url, MoviesListBean.class);
    }
    
    /**
     * This is a good starting point to start finding movies on TMDb. The idea 
     * is to be a quick and light method so you can iterate through movies quickly.
     * 
     * {@link http://help.themoviedb.org/kb/api/search-movies}
     * 
     * @param url String representation of search URL
     * @return object of class MoviesListBean, containing movies specified by search
     */
    public MoviesListBean searchMovies(String url) {
        return searchMovies(TMDbApiURL.createURL(url));
    }
        
    /**
     * This is a good starting point to start finding movies on TMDb. The idea 
     * is to be a quick and light method so you can iterate through movies quickly.
     * 
     * {@link http://help.themoviedb.org/kb/api/search-movies}
     * 
     * NOTE: Ommiting a param is done by setting it to null.
     * 
     * Required Parameters:
     * @param query query param is your search text. 
     *     It works best when the text has been properly escaped.
     * @param page iterate through results.
     * @param language acts as a filter for the title and poster field. 
     *     The expected value is a ISO 639-1 code.
     * @param includeAdult used to toggle whether or not to include adult items
     * @param year helps narrow your search results
     * 
     * @return object of class MoviesListBean, containing movies specified by search
     */
    public MoviesListBean searchMovies(String query, Integer page, String language, Boolean includeAdult, Integer year) {
        TMDbApiURLParameter paramQuery = 
            new TMDbApiURLParameter(TMDbApiURLParameter.QUERY_PARAMETER, query);
        
        TMDbApiURLParameter paramPage = 
            new TMDbApiURLParameter(TMDbApiURLParameter.PAGE_PARAMETER, page);
        
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        TMDbApiURLParameter paramAdult = 
            new TMDbApiURLParameter(TMDbApiURLParameter.INCLUDE_ADULT_PARAMETER, includeAdult);
        
        TMDbApiURLParameter paramYear = 
            new TMDbApiURLParameter(TMDbApiURLParameter.YEAR_PARAMETER, year);
                        
        return searchMovies(
                TMDbApiURL.createURL(
                    TMDbApiURL.SEARCH, 
                    TMDbApiURL.MOVIE,
                    paramApiKey,
                    paramQuery, 
                    paramPage,
                    paramLanguage, 
                    paramAdult, 
                    paramYear));        
    }

    
    /**
     * This is a good starting point to start finding people on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/search-people}
     * 
     * @param url url request
     * @return object of class PersonsListBean, containing persons specified by search
     */
    public PersonsListBean searchPersons(URL url) {
        return get(url, PersonsListBean.class);
    }
    
    /**
     * This is a good starting point to start finding people on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/search-people}
     * 
     * @param url url request
     * @return object of class PersonsListBean, containing persons specified by search
     */
    public PersonsListBean searchPersons(String url) {
        return searchPersons(TMDbApiURL.createURL(url));
    }  
    
    /**
     * This is a good starting point to start finding people on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/search-people}
     * 
     * @param query search text. It works best when the text has been properly escaped.
     * @param page use to iterate through results
     * @param includeAdult toggle whether or not to include adult items in search
     * @return object of class PersonsListBean, containing persons specified by search
     */
    public PersonsListBean searchPersons(String query, Integer page, Boolean includeAdult) {
        TMDbApiURLParameter paramQuery = 
            new TMDbApiURLParameter(TMDbApiURLParameter.QUERY_PARAMETER, query);
        
        TMDbApiURLParameter paramPage = 
            new TMDbApiURLParameter(TMDbApiURLParameter.PAGE_PARAMETER, page);
        
        TMDbApiURLParameter paramAdult = 
            new TMDbApiURLParameter(TMDbApiURLParameter.INCLUDE_ADULT_PARAMETER, includeAdult);
        
        return searchPersons(
                TMDbApiURL.createURL(
                    TMDbApiURL.SEARCH, 
                    TMDbApiURL.PERSON, 
                    paramApiKey, 
                    paramQuery, 
                    paramPage, 
                    paramAdult));
    }
    
    /**
     * This is a good starting point to start finding people on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/search-people}
     * 
     * @param query search text. It works best when the text has been properly escaped.
     * @param page use to iterate through results
     * @return object of class PersonsListBean, containing persons specified by search
     */
    public PersonsListBean searchPersons(String query, Integer page) {
        return searchPersons(query, page, false);
    }
    
    /**
     * This is a good starting point to start finding people on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/search-people}
     * 
     * @param query search text. It works best when the text has been properly escaped.
     * @param includeAdult toggle whether or not to include adult items in search
     * @return object of class PersonsListBean, containing persons specified by search
     */
    public PersonsListBean searchPersons(String query, Boolean includeAdult) {
        return searchPersons(query, null, includeAdult);
    }
       
    
    /*
     * Collections
     *  - Collection Info
     *  - Collection Images
     */
    /**
     * This method is used to retrieve all of the basic information about a movie collection.
     * 
     * {@link http://help.themoviedb.org/kb/api/collection-info}
     * 
     * @param url request url
     * @return all of the basic information about a movie collection
     */
    public CollectionInfoBean getCollectionInfo(URL url) {
        return get(url, CollectionInfoBean.class);
    }
    
    /**
     * This method is used to retrieve all of the basic information about a movie collection.
     * 
     * {@link http://help.themoviedb.org/kb/api/collection-info}
     *  
     * @param url String representation of request url
     * @return all of the basic information about a movie collection
     */
    public CollectionInfoBean geCollectionInfo(String url) {
        return getCollectionInfo(TMDbApiURL.createURL(url));
    }
   
    /**
     * This method is used to retrieve all of the basic information about a movie collection.
     * 
     * {@link http://help.themoviedb.org/kb/api/collection-info}
     * 
     * @param id tmdb movie id 
     * @param language language parameter tries to localize the movie data we return
     * @return all of the basic information about a movie collection
     */
    public CollectionInfoBean getCollectionInfo(Integer id, String language) {
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getCollectionInfo(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.COLLECTION, 
                    TMDbApiURL.EMPTY, 
                    id, 
                    paramApiKey,
                    paramLanguage));
        
    }
    
    /**
     * This method is used to retrieve all of the basic information about a movie collection.
     * 
     * {@link http://help.themoviedb.org/kb/api/collection-info}
     * 
     * @param id tmdb movie id
     * @return all of the basic information about a movie collection
     */
    public CollectionInfoBean getCollectionInfo(Integer id) {
        return getCollectionInfo(id, null);
    }
    
    
    /**
     * This method should be used when you’re wanting to retrieve all of the 
     * images for a particular collection.
     * 
     * {@link http://help.themoviedb.org/kb/api/collection-images}
     * 
     * @param url request url 
     * @return all of the images for a particular collection.
     */
    public CollectionImagesBean getCollectionImages(URL url) {
        return get(url, CollectionImagesBean.class);
    }
    
    /**
     * This method should be used when you’re wanting to retrieve all of the 
     * images for a particular collection.
     * 
     * {@link http://help.themoviedb.org/kb/api/collection-images}
     * 
     * @param url String representation of request url 
     * @return all of the images for a particular collection.
     */
    public CollectionImagesBean getCollectionImages(String url) {
        return getCollectionImages(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method should be used when you’re wanting to retrieve all of the 
     * images for a particular collection.
     * 
     * {@link http://help.themoviedb.org/kb/api/collection-images}
     *
     * @param id tmdb id of the collection     
     * @param language language parameter acts as a filter
     * @return all of the images for a particular collection.
     */
    public CollectionImagesBean getCollectionImages(Integer id, String language) {
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getCollectionImages(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.COLLECTION, 
                    TMDbApiURL.IMAGES, 
                    id, 
                    paramApiKey,
                    paramLanguage));
    }
    
    /**
     * This method should be used when you’re wanting to retrieve all of the 
     * images for a particular collection.
     * 
     * {@link http://help.themoviedb.org/kb/api/collection-images}
     *
     * @param id tmdb id of the collection
     * @return all of the images for a particular collection.
     */
    public CollectionImagesBean getCollectionImages(Integer id) {
        return getCollectionImages(id, null);
    }
    
    
    /*
     * Movie Info
     *  - Movie Info
     *  - Movie Alternative Titles
     *  - Movie Casts
     *  - Movie Images
     *  - Movie Keywords
     *  - Movie Release Info
     *  - Movie Trailers
     *  - Movie Translations
     *  - Movie Similar Movies
     */    
    /**
     * This method is used to retrieve all of the basic movie information. 
     * It will return the single highest rated poster and backdrop.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-info}
     * 
     * @param url url request
     * @return all of the basic movie information
     */
    public MovieBean getMovieInfo(URL url) {
        return get(url, MovieBean.class);
    }
    
    /**
     * This method is used to retrieve all of the basic movie information. 
     * It will return the single highest rated poster and backdrop.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-info}
     * 
     * @param url String representation of url request
     * @return all of the basic movie information
     */
    public MovieBean getMovieInfo(String url) {
        return getMovieInfo(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method is used to retrieve all of the basic movie information. 
     * It will return the single highest rated poster and backdrop.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-info}
     *  
     * @param id tmdb movie id
     * @param language language parameter tries to localize the movie data we return
     * @return all of the basic movie information
     */
    public MovieBean getMovieInfo(Integer id, String language) {
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getMovieInfo(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.MOVIE, 
                    TMDbApiURL.EMPTY, 
                    id, 
                    paramApiKey, 
                    paramLanguage));
    }
    
    /**
     * This method is used to retrieve all of the basic movie information. 
     * It will return the single highest rated poster and backdrop.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-info}
     *  
     * @param id tmdb movie id
     * @return all of the basic movie information
     */
    public MovieBean getMovieInfo(Integer id) {
        return getMovieInfo(id, null);
    }

    
    /**
     * This method is used to retrieve all of the alternative titles 
     * we have for a particular movie.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-alternative-titles}
     * 
     * @param url url request
     * @return all of the alternative titles for a particular movie
     */
    public MovieAlternativeTitlesBean getMovieAlternativeTitles(URL url) {
        return get(url, MovieAlternativeTitlesBean.class);
    }
    
    /**
     * This method is used to retrieve all of the alternative titles 
     * we have for a particular movie.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-alternative-titles}
     * 
     * @param url url request
     * @return all of the alternative titles for a particular movie
     */
    public MovieAlternativeTitlesBean getMovieAlternativeTitles(String url) {
        return getMovieAlternativeTitles(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method is used to retrieve all of the alternative titles 
     * we have for a particular movie.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-alternative-titles}
     *  
     * @param id tmdb movie id
     * @param country filter the results to only include titles in that particular country
     * @return all of the alternative titles for a particular movie
     */
    public MovieAlternativeTitlesBean getMovieAlternativeTitles(Integer id, String country) {
        TMDbApiURLParameter paramCountry = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.COUNTRY_PARAMETER, country);
        
        return getMovieAlternativeTitles( 
                TMDbApiURL.createIdURL(
                    TMDbApiURL.MOVIE, 
                    TMDbApiURL.ALTERNATIVE_TITLES,
                    id,
                    paramApiKey,
                    paramCountry));
    }
    
    /**
     * This method is used to retrieve all of the alternative titles 
     * we have for a particular movie.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-alternative-titles}
     *  
     * @param id tmdb movie id
     * @return all of the alternative titles for a particular movie
     */
    public MovieAlternativeTitlesBean getMovieAlternativeTitles(Integer id) {
        return getMovieAlternativeTitles(id, null);
    }
    
    
    /**
     * This method is used to retrieve all of the movie cast information. 
     * The results are split into separate cast and crew arrays.
     *
     * @param url url request
     * @ returns all of the movie cast information
     */
    public MovieCastsBean getMovieCasts(URL url) {
        return get(url, MovieCastsBean.class);
    }
    
    /**
     * This method is used to retrieve all of the movie cast information. 
     * The results are split into separate cast and crew arrays.
     *
     * @param url String representation of url request
     * @ returns all of the movie cast information
     */
    public MovieCastsBean getMovieCasts(String url) {
        return getMovieCasts(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method is used to retrieve all of the movie cast information. 
     * The results are split into separate cast and crew arrays.
     *
     * @param id tmdb movie id
     * @ returns all of the movie cast information
     */
    public MovieCastsBean getMovieCasts(Integer id) {
        return getMovieCasts(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.MOVIE, 
                    TMDbApiURL.CASTS, 
                    id, 
                    paramApiKey));
    }
    
    
    /**
     * This method should be used when you’re wanting to retrieve all of 
     * the images for a particular movie.
     * 
     * http://help.themoviedb.org/kb/api/movie-images
     * 
     * @param url url request
     * @return all of the images for a particular movie
     */
    public MovieImagesBean getMovieImages(URL url) {
        return get(url, MovieImagesBean.class);
    }
    
    /**
     * This method should be used when you’re wanting to retrieve all of 
     * the images for a particular movie.
     * 
     * http://help.themoviedb.org/kb/api/movie-images
     * 
     * @param url String representation of url request
     * @return all of the images for a particular movie
     */
    public MovieImagesBean getMovieImages(String url) {
        return getMovieImages(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method should be used when you’re wanting to retrieve all of 
     * the images for a particular movie.
     * 
     * http://help.themoviedb.org/kb/api/movie-images
     * 
     * @param id tmdb movie id
     * @param language language parameter acts as a filter
     * @return all of the images for a particular movie
     */
    public MovieImagesBean getMovieImages(Integer id, String language) {
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getMovieImages(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.MOVIE,
                    TMDbApiURL.IMAGES, 
                    id, 
                    paramApiKey, 
                    paramLanguage));
    }
    
    /**
     * This method should be used when you’re wanting to retrieve all of 
     * the images for a particular movie.
     * 
     * http://help.themoviedb.org/kb/api/movie-images
     * 
     * @param id tmdb movie id
     * @return all of the images for a particular movie
     */
    public MovieImagesBean getMovieImages(Integer id) {
        return getMovieImages(id, null);
    }
    
    
    /**
     * This method is used to retrieve all of the keywords that have been 
     * added to a particular movie. Currently, only English keywords exist.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-keywords}
     * 
     * @param url url request
     * @return all of the keywords that have been added to a particular movie
     */
    public MovieKeywordsBean getMovieKeywords(URL url) {
        return get(url, MovieKeywordsBean.class);
    }
    
    /**
     * This method is used to retrieve all of the keywords that have been 
     * added to a particular movie. Currently, only English keywords exist.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-keywords}
     * 
     * @param url String representation url request
     * @return all of the keywords that have been added to a particular movie
     */
    public MovieKeywordsBean getMovieKeywords(String url) {
        return getMovieKeywords(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method is used to retrieve all of the keywords that have been 
     * added to a particular movie. Currently, only English keywords exist.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-keywords}
     * 
     * @param id tmdb movie id
     * @return all of the keywords that have been added to a particular movie
     */
    public MovieKeywordsBean getMovieKeywords(Integer id) {
        return getMovieKeywords(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.MOVIE, 
                    TMDbApiURL.KEYWORDS, 
                    id, 
                    paramApiKey));
    }
    
    
    /**
     * This method is used to retrieve all of the release and certification 
     * data we have for a specific movie.
     * 
     * @param url url request
     * @return all of the release and certification data we have for a specific movie
     */
    public MovieReleaseInfoBean getMovieReleaseInfo(URL url) {
        return get(url, MovieReleaseInfoBean.class);
    }
    
    /**
     * This method is used to retrieve all of the release and certification 
     * data we have for a specific movie.
     * 
     * @param url url request
     * @return all of the release and certification data we have for a specific movie
     */
    public MovieReleaseInfoBean getMovieReleaseInfo(String url) {
        return getMovieReleaseInfo(TMDbApiURL.createURL(url));
    }    
    
    /**
     * This method is used to retrieve all of the release and certification 
     * data we have for a specific movie.
     * 
     * @param id tmdb movie id
     * @return all of the release and certification data we have for a specific movie
     */
    public MovieReleaseInfoBean getMovieReleaseInfo(Integer id) {
        return getMovieReleaseInfo(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.MOVIE, 
                    TMDbApiURL.RELEASES, 
                    id, 
                    paramApiKey));
    }

    
    /**
     * This method is used to retrieve all of the trailers for a particular movie. 
     * Supported sites are YouTube and QuickTime.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-trailers}
     * 
     * @param url url request
     * @return all of the trailers for a particular movie
     */
    public MovieTrailersBean getMovieTrailers(URL url) {
        return get(url, MovieTrailersBean.class);        
    }
    
    /**
     * This method is used to retrieve all of the trailers for a particular movie. 
     * Supported sites are YouTube and QuickTime.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-trailers}
     * 
     * @param url url request
     * @return all of the trailers for a particular movie
     */
    public MovieTrailersBean getMovieTrailers(String url) {
        return getMovieTrailers(TMDbApiURL.createURL(url));        
    }
    
    /**
     * This method is used to retrieve all of the trailers for a particular movie. 
     * Supported sites are YouTube and QuickTime.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-trailers}
     * 
     * @param id tmdb movie id
     * @param language language parameter acts as a filter
     * @return all of the trailers for a particular movie
     */
    public MovieTrailersBean getMovieTrailers(Integer id, String language) {
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getMovieTrailers(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.MOVIE,
                    TMDbApiURL.TRAILERS, 
                    id, 
                    paramApiKey, 
                    paramLanguage));
    }
    
    /**
     * This method is used to retrieve all of the trailers for a particular movie. 
     * Supported sites are YouTube and QuickTime.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-trailers}
     * 
     * @param id tmdb movie id
     * @param language language parameter acts as a filter
     * @return all of the trailers for a particular movie
     */
    public MovieTrailersBean getMovieTrailers(Integer id) {
        return getMovieTrailers(id, null);
    }
    
    
    /**
     * This method is used to retrieve a list of the available translations for a specific movie.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-translations}
     * 
     * @param url url request
     * @return list of the available translations for a specific movie
     */
    public MovieTranslationsBean getMovieTranslations(URL url) {
        return get(url, MovieTranslationsBean.class);
    }
    
    /**
     * This method is used to retrieve a list of the available translations for a specific movie.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-translations}
     * 
     * @param url String representation of url request
     * @return list of the available translations for a specific movie
     */
    public MovieTranslationsBean getMovieTranslations(String url) {
        return getMovieTranslations(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method is used to retrieve a list of the available translations for a specific movie.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-translations}
     *  
     * @param id tmdb movie id
     * @return list of the available translations for a specific movie
     */
    public MovieTranslationsBean getMovieTranslations(Integer id) {
        return getMovieTranslations(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.MOVIE, 
                    TMDbApiURL.TRANSLATIONS, 
                    id, 
                    paramApiKey));
    }
    
    
    /**
     * The similar movies method will let you retrieve the similar movies for a 
     * particular movie. This data is created dynamically but with the help of 
     * users votes on TMDb. 
     * 
     * The data is much better with movies that have more keywords.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-similar-movies}
     * 
     * @param url url request
     * @return list of similar movies for a particular movie
     */
    public MoviesListBean getSimilarMovies(URL url) {
        return get(url, MoviesListBean.class);
    }
    
    /**
     * The similar movies method will let you retrieve the similar movies for a 
     * particular movie. This data is created dynamically but with the help of 
     * users votes on TMDb. 
     * 
     * The data is much better with movies that have more keywords.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-similar-movies}
     * 
     * @param url String representation of url request
     * @return list of similar movies for a particular movie
     */
    public MoviesListBean getSimilarMovies(String url) {
        return getSimilarMovies(TMDbApiURL.createURL(url));
    }
    
    /**
     * The similar movies method will let you retrieve the similar movies for a 
     * particular movie. This data is created dynamically but with the help of 
     * users votes on TMDb. 
     * 
     * The data is much better with movies that have more keywords.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-similar-movies}
     * 
     * @param id tmdb movie id
     * @param language language parameter acts as a filter
     * @return list of similar movies for a particular movie
     */
    public MoviesListBean getSimilarMovies(Integer id, String language) {
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getSimilarMovies(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.MOVIE,
                    TMDbApiURL.SIMILAR_MOVIES, 
                    id, 
                    paramApiKey, 
                    paramLanguage));
    }
    
    /**
     * The similar movies method will let you retrieve the similar movies for a 
     * particular movie. This data is created dynamically but with the help of 
     * users votes on TMDb. 
     * 
     * The data is much better with movies that have more keywords.
     * 
     * {@link http://help.themoviedb.org/kb/api/movie-similar-movies}
     * 
     * @param id tmdb movie id
     * @return list of similar movies for a particular movie
     */
    public MoviesListBean getSimilarMovies(Integer id) {
        return getSimilarMovies(id, null);
    }
    
    
    /*
     * Misc Movie
     *  - Movie Add Rating
     *  - Latest Movie
     *  - Upcoming Movies
     *  - Now Playing Movies
     *  - Popular Movie List
     *  - Top Rated Movies
     */
    /**
     * This method is used to retrieve the newest movie that was added to TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/latest-movie}
     * 
     * @param url url request
     * @return the newest movie that was added to TMDb
     */
    public MovieBean getLatestMovie(URL url) {
        return get(url, MovieBean.class);
    }
    
    /**
     * This method is used to retrieve the newest movie that was added to TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/latest-movie}
     * 
     * @param url String representation of url
     * @return the newest movie that was added to TMDb
     */
    public MovieBean getLatestMovie(String url) {
        return getLatestMovie(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method is used to retrieve the newest movie that was added to TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/latest-movie}
     * 
     * @return the newest movie that was added to TMDb
     */
    public MovieBean getLatestMovie() {
        return getLatestMovie(
                TMDbApiURL.createURL(
                    TMDbApiURL.MOVIE, 
                    TMDbApiURL.LATEST, 
                    paramApiKey));
    }
    
    
    /**
     * The upcoming movie method will let you retrieve the movies arriving 
     * to theatres within the next few weeks. This is a curated list that will 
     * normally contain 100 movies. The default response will return 20 movies
     * 
     * {@link http://help.themoviedb.org/kb/api/upcoming-movies}
     * 
     * @param url url request
     * @return movies arriving to theatres within the next few weeks
     */
    public MoviesListBean getUpcomingMovies(URL url) {
        return get(url, MoviesListBean.class);
    }
    
    /**
     * The upcoming movie method will let you retrieve the movies arriving 
     * to theatres within the next few weeks. This is a curated list that will 
     * normally contain 100 movies. The default response will return 20 movies
     * 
     * {@link http://help.themoviedb.org/kb/api/upcoming-movies}
     * 
     * @param url url request
     * @return movies arriving to theatres within the next few weeks
     */
    public MoviesListBean getUpcomingMovies(String url) {
        return getUpcomingMovies(TMDbApiURL.createURL(url));
    }
    
    /**
     * The upcoming movie method will let you retrieve the movies arriving 
     * to theatres within the next few weeks. This is a curated list that will 
     * normally contain 100 movies. The default response will return 20 movies
     * 
     * {@link http://help.themoviedb.org/kb/api/upcoming-movies}
     * 
     * @param page use to iterate through results 
     * @param language  acts as a filter for the title and poster field
     * @return movies arriving to theatres within the next few weeks
     */
    public MoviesListBean getUpcomingMovies(Integer page, String language) {
        TMDbApiURLParameter paramPage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.PAGE_PARAMETER, page);
        
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getUpcomingMovies(
                TMDbApiURL.createURL(
                    TMDbApiURL.MOVIE, 
                    TMDbApiURL.UPCOMING, 
                    paramApiKey,
                    paramPage,
                    paramLanguage));
    }
    
    /**
     * The upcoming movie method will let you retrieve the movies arriving 
     * to theatres within the next few weeks. This is a curated list that will 
     * normally contain 100 movies. The default response will return 20 movies
     * 
     * {@link http://help.themoviedb.org/kb/api/upcoming-movies}
     * 
     * @param page use to iterate through results 
     * @return movies arriving to theatres within the next few weeks
     */
    public MoviesListBean getUpcomingMovies(Integer page) {
        return getUpcomingMovies(page, null);
    }
    
    /**
     * The upcoming movie method will let you retrieve the movies arriving 
     * to theatres within the next few weeks. This is a curated list that will 
     * normally contain 100 movies. The default response will return 20 movies
     * 
     * {@link http://help.themoviedb.org/kb/api/upcoming-movies}
     * 
     * @return movies arriving to theatres within the next few weeks
     */
    public MoviesListBean getUpcomingMovies() {
        return getUpcomingMovies(null, null);
    }
    
    
    /**
     * This method will let you retrieve the movies currently in theatres. 
     * This is a curated list that will normally contain 100 movies. The default 
     * response will return 20 movies.
     * 
     * {@link http://help.themoviedb.org/kb/api/now-playing-movies
     * 
     * @param url url request
     * @return the movies currently in theatres
     */
    public MoviesListBean getNowPlayingMovies(URL url) {
        return get(url, MoviesListBean.class);
    }
    
    /**
     * This method will let you retrieve the movies currently in theatres. 
     * This is a curated list that will normally contain 100 movies. The default 
     * response will return 20 movies.
     * 
     * {@link http://help.themoviedb.org/kb/api/now-playing-movies
     * 
     * @param url String representation of url request
     * @return the movies currently in theatres
     */
    public MoviesListBean getNowPlayingMovies(String url) {
        return getNowPlayingMovies(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method will let you retrieve the movies currently in theatres. 
     * This is a curated list that will normally contain 100 movies. The default 
     * response will return 20 movies.
     * 
     * {@link http://help.themoviedb.org/kb/api/now-playing-movies
     * 
     * @param page use to iterate through results 
     * @param language  acts as a filter for the title and poster field
     * @return the movies currently in theatres
     */
    public MoviesListBean getNowPlayingMovies(Integer page, String language) {
        TMDbApiURLParameter paramPage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.PAGE_PARAMETER, page);
        
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getNowPlayingMovies(
                TMDbApiURL.createURL(
                    TMDbApiURL.MOVIE, 
                    TMDbApiURL.NOW_PLAYING, 
                    paramApiKey,
                    paramPage,
                    paramLanguage));
    }
    
    /**
     * This method will let you retrieve the movies currently in theatres. 
     * This is a curated list that will normally contain 100 movies. The default 
     * response will return 20 movies.
     * 
     * {@link http://help.themoviedb.org/kb/api/now-playing-movies
     * 
     * @param page use to iterate through results 
     * @return the movies currently in theatres
     */
    public MoviesListBean getNowPlayingMovies(Integer page) {
        return getNowPlayingMovies(page, null);
    }
    
    /**
     * This method will let you retrieve the movies currently in theatres. 
     * This is a curated list that will normally contain 100 movies. The default 
     * response will return 20 movies.
     * 
     * {@link http://help.themoviedb.org/kb/api/now-playing-movies
     * 
     * @return the movies currently in theatres
     */
    public MoviesListBean getNowPlayingMovies() {
        return getNowPlayingMovies(null, null);
    }
    
    
    /**
     * The popular movie method will let you retrieve the daily movie popularity 
     * list. This list is updated daily. The default response will return 20 movies.
     * 
     * @{link http://help.themoviedb.org/kb/api/popular-movie-list}
     * 
     * @param url url request
     * @return the daily movie popularity list
     */
    public MoviesListBean getPopularMovies(URL url) {
        return get(url, MoviesListBean.class);
    }
    
    /**
     * The popular movie method will let you retrieve the daily movie popularity 
     * list. This list is updated daily. The default response will return 20 movies.
     * 
     * @{link http://help.themoviedb.org/kb/api/popular-movie-list}
     * 
     * @param url String representation of url request
     * @return the daily movie popularity list
     */
    public MoviesListBean getPopularMovies(String url) {
        return getPopularMovies(TMDbApiURL.createURL(url));
    }
    
    /**
     * The popular movie method will let you retrieve the daily movie popularity 
     * list. This list is updated daily. The default response will return 20 movies.
     * 
     * @{link http://help.themoviedb.org/kb/api/popular-movie-list}
     * 
     * @param page use to iterate through results 
     * @param language  acts as a filter for the title and poster field
     * @return the daily movie popularity list
     */
    public MoviesListBean getPopularMovies(Integer page, String language) {
        TMDbApiURLParameter paramPage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.PAGE_PARAMETER, page);
        
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getPopularMovies(
                TMDbApiURL.createURL(
                    TMDbApiURL.MOVIE, 
                    TMDbApiURL.POPULAR, 
                    paramApiKey, 
                    paramPage, 
                    paramLanguage));
    }
    
    /**
     * The popular movie method will let you retrieve the daily movie popularity 
     * list. This list is updated daily. The default response will return 20 movies.
     * 
     * @{link http://help.themoviedb.org/kb/api/popular-movie-list}
     * 
     * @param page use to iterate through results 
     * @return the daily movie popularity list
     */
    public MoviesListBean getPopularMovies(Integer page) {
        return getPopularMovies(page, null);
    }
    
    /**
     * The popular movie method will let you retrieve the daily movie popularity 
     * list. This list is updated daily. The default response will return 20 movies.
     * 
     * @{link http://help.themoviedb.org/kb/api/popular-movie-list}
     * 
     * @return the daily movie popularity list
     */
    public MoviesListBean getPopularMovies() {
        return getPopularMovies(null, null);
    }
    
    
    /**
     * This method will let you retrieve the top rated movies that have over 
     * 10 votes on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/top-rated-movies}
     * 
     * @param url url request
     * @return the top rated movies that have over 10 votes on TMDb.
     */
    public MoviesListBean getTopRatedMovies(URL url) {
        return get(url, MoviesListBean.class);
    }
    
    /**
     * This method will let you retrieve the top rated movies that have over 
     * 10 votes on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/top-rated-movies}
     * 
     * @param url String representation of url request
     * @return the top rated movies that have over 10 votes on TMDb.
     */
    public MoviesListBean getTopRatedMovies(String url) {
        return getTopRatedMovies(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method will let you retrieve the top rated movies that have over 
     * 10 votes on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/top-rated-movies}
     * 
     * @param page use to iterate through results 
     * @param language  acts as a filter for the title and poster field
     * @return the top rated movies that have over 10 votes on TMDb.
     */
    public MoviesListBean getTopRatedMovies(Integer page, String language) {
        TMDbApiURLParameter paramPage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.PAGE_PARAMETER, page);
        
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getTopRatedMovies(
                TMDbApiURL.createURL(
                    TMDbApiURL.MOVIE, 
                    TMDbApiURL.TOP_RATED, 
                    paramApiKey, 
                    paramPage, 
                    paramLanguage));
    }
        
    /**
     * This method will let you retrieve the top rated movies that have over 
     * 10 votes on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/top-rated-movies}
     * 
     * @param page use to iterate through results 
     * @return the top rated movies that have over 10 votes on TMDb.
     */
    public MoviesListBean getTopRatedMovies(Integer page) {
        return getTopRatedMovies(page, null);
    }
    
    /**
     * This method will let you retrieve the top rated movies that have over 
     * 10 votes on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/top-rated-movies}
     * 
     * @return the top rated movies that have over 10 votes on TMDb.
     */
    public MoviesListBean getTopRatedMovies() {
        return getTopRatedMovies(null, null);
    }
    

    /*
     * Person Info
     *  - Person Info
     *  - Person Credits
     *  - Person Images
     */
    /**
     * This method is used to retrieve all of the basic person information. 
     * It will return the single highest rated profile image.
     * 
     * {@link http://help.themoviedb.org/kb/api/person-info}
     * 
     * @param url url request
     * @return all of the basic person information
     */
    public PersonBean getPersonInfo(URL url) {
        return get(url, PersonBean.class);
    }
    
    /**
     * This method is used to retrieve all of the basic person information. 
     * It will return the single highest rated profile image.
     * 
     * {@link http://help.themoviedb.org/kb/api/person-info}
     * 
     * @param url String representation of url request
     * @return all of the basic person information
     */
    public PersonBean getPersonInfo(String url) {
        return getPersonInfo(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method is used to retrieve all of the basic person information. 
     * It will return the single highest rated profile image.
     * 
     * {@link http://help.themoviedb.org/kb/api/person-info}
     *  
     * @param id tmdb person id
     * @return all of the basic person information
     */
    public PersonBean getPersonInfo(Integer id) {
        return getPersonInfo(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.PERSON,
                    TMDbApiURL.EMPTY,
                    id,
                    paramApiKey));
    }
    
    
    /**
     * This method is used to retrieve all of the cast & crew information 
     * for the person. 
     * It will return the single highest rated poster for each movie record.
     * 
     * {@link http://help.themoviedb.org/kb/api/person-credits}
     * 
     * @param url url request
     * @return all of the cast & crew information for the person
     */
    public PersonCreditsBean getPersonCredits(URL url) {
        return get(url, PersonCreditsBean.class);
    }
    
    /**
     * This method is used to retrieve all of the cast & crew information 
     * for the person. 
     * It will return the single highest rated poster for each movie record.
     * 
     * {@link http://help.themoviedb.org/kb/api/person-credits}
     * 
     * @param url url request
     * @return all of the cast & crew information for the person
     */
    public PersonCreditsBean getPersonCredits(String url) {
        return getPersonCredits(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method is used to retrieve all of the cast & crew information 
     * for the person. 
     * It will return the single highest rated poster for each movie record.
     * 
     * {@link http://help.themoviedb.org/kb/api/person-credits}
     *  
     * @param id tmdb person id
     * @param language parameter tries to localize the movie data we return
     * @return
     */
    public PersonCreditsBean getPersonCredits(Integer id, String language) {
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getPersonCredits(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.PERSON,
                    TMDbApiURL.CREDITS, 
                    id, 
                    paramApiKey, 
                    paramLanguage));
    }
    
    /**
     * This method is used to retrieve all of the cast & crew information 
     * for the person. 
     * It will return the single highest rated poster for each movie record.
     * 
     * {@link http://help.themoviedb.org/kb/api/person-credits}
     *  
     * @param id tmdb person id
     * @return
     */
    public PersonCreditsBean getPersonCredits(Integer id) {       
        return getPersonCredits(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.PERSON,
                    TMDbApiURL.CREDITS, 
                    id, 
                    paramApiKey));
    }
    
    
    /**
     * This method is used to retrieve all of the profile images for a person.
     * 
     * {@link http://help.themoviedb.org/kb/api/person-images}
     * 
     * @param url url request
     * @return all of the profile images for a person.
     */
    public PersonImagesBean getPersonImages(URL url) {
        return get(url, PersonImagesBean.class);
    }
    
    /**
     * This method is used to retrieve all of the profile images for a person.
     * 
     * {@link http://help.themoviedb.org/kb/api/person-images}
     * 
     * @param url String representation of url request
     * @return all of the profile images for a person.
     */
    public PersonImagesBean getPersonImages(String url) {
        return getPersonImages(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method is used to retrieve all of the profile images for a person.
     * 
     * {@link http://help.themoviedb.org/kb/api/person-images}
     * 
     * @param id tmdb person id
     * @return all of the profile images for a person.
     */
    public PersonImagesBean getPersonImages(Integer id) {
        return getPersonImages(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.PERSON, 
                    TMDbApiURL.IMAGES, 
                    id, 
                    paramApiKey));
    }
    
    
    /*
     * Company Info
     *  - Company Info
     *  - Company Movies 
     */
    /**
     * The company info method will return the basic information about a 
     * production company on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/company-info}
     * 
     * @param url url request
     * @return the basic information about a production company on TMDb
     */
    public CompanyBean getCompanyInfo(URL url) {
        return get(url, CompanyBean.class);
    }
    
    /**
     * The company info method will return the basic information about a 
     * production company on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/company-info}
     * 
     * @param url String representation of url request
     * @return the basic information about a production company on TMDb
     */
    public CompanyBean getCompanyInfo(String url) {
        return getCompanyInfo(TMDbApiURL.createURL(url));
    }
    
    /**
     * The company info method will return the basic information about a 
     * production company on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/company-info}
     * 
     * @param id tmdb company id
     * @return the basic information about a production company on TMDb
     */
    public CompanyBean getCompanyInfo(Integer id) {
        return getCompanyInfo(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.COMPANY, 
                    TMDbApiURL.EMPTY, 
                    id, 
                    paramApiKey));
    }
    
    
    /**
     * This method will let you retrieve the movies associated with a company. 
     * These movies are returned in order of most recently released to oldest. 
     * The default response will return 20 movies per page
     * 
     * {@link http://help.themoviedb.org/kb/api/company-movies}
     * 
     * @param url url request
     * @return list of the movies associated with a company
     */
    public CompanyMoviesBean getCompanyMovies(URL url) {
        return get(url, CompanyMoviesBean.class);
    }
    
    /**
     * This method will let you retrieve the movies associated with a company. 
     * These movies are returned in order of most recently released to oldest. 
     * The default response will return 20 movies per page
     * 
     * {@link http://help.themoviedb.org/kb/api/company-movies}
     * 
     * @param url String representation of the url request
     * @return list of the movies associated with a company
     */
    public CompanyMoviesBean getCompanyMovies(String url) {
        return getCompanyMovies(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method will let you retrieve the movies associated with a company. 
     * These movies are returned in order of most recently released to oldest. 
     * The default response will return 20 movies per page
     * 
     * {@link http://help.themoviedb.org/kb/api/company-movies}
     * 
     * @param id tmdb company id
     * @param page used to iterate through results
     * @param language acts as a filter for the title and poster field
     * @return list of the movies associated with a company
     */
    public CompanyMoviesBean getCompanyMovies(Integer id, Integer page, String language) {
        TMDbApiURLParameter paramPage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.PAGE_PARAMETER, page);
        
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getCompanyMovies(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.COMPANY, 
                    TMDbApiURL.MOVIES, 
                    id, 
                    paramApiKey, 
                    paramPage, 
                    paramLanguage));
    }
    
    /**
     * This method will let you retrieve the movies associated with a company. 
     * These movies are returned in order of most recently released to oldest. 
     * The default response will return 20 movies per page
     * 
     * {@link http://help.themoviedb.org/kb/api/company-movies}
     * 
     * @param id tmdb company id
     * @param page used to iterate through results
     * @return list of the movies associated with a company
     */
    public CompanyMoviesBean getCompanyMovies(Integer id, Integer page) {
        return getCompanyMovies(id, page, null);
    }
    
    /**
     * This method will let you retrieve the movies associated with a company. 
     * These movies are returned in order of most recently released to oldest. 
     * The default response will return 20 movies per page
     * 
     * {@link http://help.themoviedb.org/kb/api/company-movies}
     * 
     * @param id tmdb company id
     * @param language acts as a filter for the title and poster field
     * @return list of the movies associated with a company
     */
    public CompanyMoviesBean getCompanyMovies(Integer id, String language) {
        return getCompanyMovies(id, null, language);
    }
    
    /**
     * This method will let you retrieve the movies associated with a company. 
     * These movies are returned in order of most recently released to oldest. 
     * The default response will return 20 movies per page
     * 
     * {@link http://help.themoviedb.org/kb/api/company-movies}
     * 
     * @param id tmdb company id
     * @return list of the movies associated with a company
     */
    public CompanyMoviesBean getCompanyMovies(Integer id) {
        return getCompanyMovies(id, null, null);
    }
    

    /*
     * Genre Info
     *  - Genre List
     *  - Genre Movies
     */
    /**
     * This method is used to retrieve the list of genres used on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/genre-list}
     * 
     * @param url url request
     * @return the list of genres used on TMDb
     */
    public GenreListBean getGenres(URL url) {
        return get(url, GenreListBean.class);
    }
    
    /**
     * This method is used to retrieve the list of genres used on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/genre-list}
     * 
     * @param url String representation of url request
     * @return the list of genres used on TMDb
     */
    public GenreListBean getGenres(String url) {
        return getGenres(TMDbApiURL.createURL(url));
    }
    
    /**
     * This method is used to retrieve the list of genres used on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/genre-list}
     * 
     * @param language used as a filter
     * @return the list of genres used on TMDb
     */
//    public GenreListBean getGenres(String language) {
//        TMDbApiURLParameter paramLanguage = 
//            new TMDbApiURLParameter(
//                TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
//        
//        return getGenres(
//                TMDbApiURL.createURL(
//                    TMDbApiURL.GENRE, 
//                    TMDbApiURL.LIST, 
//                    paramApiKey, 
//                    paramLanguage));
//    }
    
    /**
     * This method is used to retrieve the list of genres used on TMDb.
     * 
     * {@link http://help.themoviedb.org/kb/api/genre-list}
     * 
     * @param language used as a filter
     * @return the list of genres used on TMDb
     */
    public GenreListBean getGenres() {
        return getGenres("");
    }

    
    /**
     * If you're looking to get a list of movies per genre, you can look them up 
     * with this method. It is important to understand that only movies with 
     * more than 10 votes get listed.
     * 
     * {@link http://help.themoviedb.org/kb/api/genre-movies}
     * 
     * @param url url request
     * @return a list of movies per genre
     */
    public GenreMoviesBean getGenreMovies(URL url) {
        return get(url, GenreMoviesBean.class);
    }
    
    /**
     * If you're looking to get a list of movies per genre, you can look them up 
     * with this method. It is important to understand that only movies with 
     * more than 10 votes get listed.
     * 
     * {@link http://help.themoviedb.org/kb/api/genre-movies}
     * 
     * @param url String representation of url request
     * @return a list of movies per genre
     */
    public GenreMoviesBean getGenreMovies(String url) {
        return getGenreMovies(TMDbApiURL.createURL(url));
    }
    
    /**
     * If you're looking to get a list of movies per genre, you can look them up 
     * with this method. It is important to understand that only movies with 
     * more than 10 votes get listed.
     * 
     * {@link http://help.themoviedb.org/kb/api/genre-movies}
     *  
     * @param id tmdb company id
     * @param page used to iterate through results
     * @param language acts as a filter for the title and poster field
     * @return a list of movies per genre
     */
    public GenreMoviesBean getGenreMovies(Integer id, Integer page, String language) {
        TMDbApiURLParameter paramPage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.PAGE_PARAMETER, page);
        
        TMDbApiURLParameter paramLanguage = 
            new TMDbApiURLParameter(
                TMDbApiURLParameter.LANGUAGE_PARAMETER, language);
        
        return getGenreMovies(
                TMDbApiURL.createIdURL(
                    TMDbApiURL.GENRE, 
                    TMDbApiURL.MOVIES, 
                    id, 
                    paramApiKey, 
                    paramPage, 
                    paramLanguage));
    }
    
    /**
     * If you're looking to get a list of movies per genre, you can look them up 
     * with this method. It is important to understand that only movies with 
     * more than 10 votes get listed.
     * 
     * {@link http://help.themoviedb.org/kb/api/genre-movies}
     *  
     * @param id tmdb company id
     * @param page used to iterate through results
     * @return a list of movies per genre
     */
    public GenreMoviesBean getGenreMovies(Integer id, Integer page){
        return getGenreMovies(id, page, null);
    }
    
    /**
     * If you're looking to get a list of movies per genre, you can look them up 
     * with this method. It is important to understand that only movies with 
     * more than 10 votes get listed.
     * 
     * {@link http://help.themoviedb.org/kb/api/genre-movies}
     *  
     * @param id tmdb company id
     * @param language acts as a filter for the title and poster field
     * @return a list of movies per genre
     */
    public GenreMoviesBean getGenreMovies(Integer id, String language){
        return getGenreMovies(id, null, language);
    }
    
    /**
     * If you're looking to get a list of movies per genre, you can look them up 
     * with this method. It is important to understand that only movies with 
     * more than 10 votes get listed.
     * 
     * {@link http://help.themoviedb.org/kb/api/genre-movies}
     *  
     * @param id tmdb company id
     * @return a list of movies per genre
     */
    public GenreMoviesBean getGenreMovies(Integer id){
        return getGenreMovies(id, null, null);
    }
    
    /*
     * Custom methods:
     *  - Random Top Rated Movie
     *  - Random Popular Movie
     */
    /**
     * Returns randomly picked movie from the list of top rated movies.
     * 
     * The first time it's one of the movies from the first page. Every other 
     * time, page is randomly picked and than the movie is picked from that page.
     * 
     * @return randomly picked movie from the list of top rated movies
     */
    public MovieBean getRandomTopRatedMovie() {
        MoviesListBean movies = null;
        
        if (topRatedMoviesTotalPages == 0) {
            /*
             * First time pick one movie from the first page.
             */
            movies = this.getTopRatedMovies();            
            topRatedMoviesTotalPages = movies.getTotalPages();
        } else {
            /*
             * We now know total number of pages, so let's pick one.
             */
            int randomPage = generator.nextInt(topRatedMoviesTotalPages) + 1;
            movies = this.getTopRatedMovies(randomPage);
        }
        
        return getRandomMovie(movies.getResults());
    }
    
    /**
     * Returns randomly picked movie from the list of popular movies.
     * 
     * The first time it's one of the movies from the first page. Every other 
     * time, page is randomly picked and than the movie is picked from that page.
     * 
     * @return randomly picked movie from the list of popular movies
     */
    public MovieBean getRandomPopularMovie() {
        MoviesListBean movies = null;
        
        if (popularMoviesTotalPages == 0) {
            /*
             * First time pick one movie from the first page.
             */
            movies = this.getPopularMovies();            
            popularMoviesTotalPages = movies.getTotalPages();
        } else {
            /*
             * We now know total number of pages, so let's pick one.
             */
            int randomPage = generator.nextInt(popularMoviesTotalPages) + 1;
            movies = this.getPopularMovies(randomPage);
        }
        
        return getRandomMovie(movies.getResults());
    }
    
    /**
     * Returns randomly picked movie from movies.
     * 
     * @param movies list of movies
     * @return randomly picked movie from movies.
     */
    protected MovieBean getRandomMovie(List<MovieBean> movies) {
        int randomInt = generator.nextInt(movies.size());        
        return movies.get(randomInt);
    }
    
    /**
     * Returns parsed JSON response got from URL, with valueType specified bean.
     * 
     * @param <T>
     * @param url request url
     * @param valueType class
     * @return parsed JSON response got from URL, with valueType specified bean.
     */
    protected static <T> T get(URL url, Class<T> valueType) {
        if (url == null) {
            log.trace("null url passed as an argument");
            return null;
        }
        
        if (valueType == null) {
            log.trace("null class (value type) passed as an argument");
            return null;
        }
        
        final ObjectMapper mapper = new ObjectMapper();
        
        try {
            String json = TMDbApiService.get(url);
            
            return mapper.readValue(json, valueType);
        } catch (JsonParseException e) {
            log.warn("Unable to parse JSON - " + e.toString());
        } catch (JsonMappingException e) {
            log.warn("Invalid JSON mappings - " + e.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
}
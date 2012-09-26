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
package com.soulware.tmdb4j.service.data;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;


/**
 * URL factory class. Provides support for creating TMDb API requests.
 * 
 * @author Luka Obradovic, 2012
 * 
 */
public class TMDbApiURL { 
    public static final Logger log = Logger.getLogger(TMDbApiURL.class);
    
    /*
     * URL specific delimiters.
     */
    public static final char PATH_DELIMITER            = '/';    
    public static final char FIRST_PARAMETER_DELIMITER = '?';
    public static final char PARAMETER_DELIMITER       = '&';
    
    /*
     * Basic information
     */
    public static final String BASE_API_URL = "http://api.themoviedb.org";
    public static final String API_VERISON = "3";
    
    /*
     * Empty (sub)method, used when ommiting
     */
    public static final String EMPTY  = "";
    
    /*
     * Methods
     */
    public static final String SEARCH     = "search";
    
    public static final String MOVIE      = "movie";
    public static final String GENRE      = "genre";
    public static final String PERSON     = "person";
    public static final String COMPANY    = "company";
    public static final String COLLECTION = "collection";
    
    /*
     * Genre non-id sub-method(s).
     */
    public static final String LIST = "list";
    
    /* 
     * Movie non-id sub-methods(s).
     */
    public static final String UPCOMING    = "upcoming";
    public static final String NOW_PLAYING = "now_playing";
    public static final String POPULAR     = "popular";
    public static final String TOP_RATED   = "top_rated";
    public static final String LATEST      = "latest";
    
    /*
     * Movie id required sub-methods(s).
     */
    public static final String RELEASES           = "releases";
    public static final String TRAILERS           = "trailers";
    public static final String TRANSLATIONS       = "translations";    
    public static final String KEYWORDS           = "keywords";
    public static final String CASTS              = "casts";
    public static final String ALTERNATIVE_TITLES = "alternative_titles";
    public static final String SIMILAR_MOVIES     = "similar_movies";
    
    /*
     * Person id reguired sub-methods(s). 
     */
    public static final String CREDITS  = "credits";
    
    /*
     * Authentication method(s). 
     */
    public static final String AUTHENTICATION = "authentication";
    
    /*
     * Authentication sub-method(s). 
     */
    public static final String TOKEN = "token";
    public static final String NEW   = "new";
    
    /*
     * Common id reguired sub-methods(s).
     */    
    public static final String IMAGES = "images";
    public static final String MOVIES = "movies";
    
    private TMDbApiURL() {
    }
    
    /**
     * Returns URL object from the String representation or 
     * null if MalformedURLException occures.
     * 
     * @param url String representation
     * 
     * @return URL object from the String representation or 
     *      null if MalformedURLException occures.
     */
    public static URL createURL(String url) {
        try {
            log.debug("URL created: " + url);
            return new URL(url);
        } catch (MalformedURLException ex) {
            log.warn("Failed to create URL '" + url + "' - " + ex.getMessage());
            return null;
        }
    }
    
    /**
     * Returns URL object constructed of method, submethod and parameters.
     * 
     * @param method TMDb method
     * @param submethod TMDb submethod
     * @param apiParameters TMDb parameters
     * 
     * @return URL object constructed of method, submethod and parameters.
     */
    public static URL createURL(
            String method, 
            String submethod, 
            TMDbApiURLParameter... apiParameters) {
        
        return createURL(
                createStringURL(
                    method, 
                    submethod, 
                    apiParameters));        
    }
    
    /**
     * Returns URL object constructed of method, submethod, id and parameters.
     * 
     * @param method TMDb method
     * @param submethod TMDb submethod
     * @param id TMDb id
     * @param apiParameters TMDb parameters
     * 
     * @return URL object constructed of method, submethod, id and parameters.
     */
    public static URL createIdURL(
            String method, 
            String submethod, 
            Integer id, 
            TMDbApiURLParameter... apiParameters) {
        
        return createURL(
                createStringIdURL(
                    method, 
                    submethod, 
                    id, 
                    apiParameters));        
    }
    
    /**
     * Returns url String representation constructed of method, submethod, id and parameters.
     * 
     * @param method TMDb method
     * @param submethod TMDb submethod
     * @param id TMDb id
     * @param apiParameters TMDb parameters
     * 
     * @return url String representation constructed of method, submethod, id and parameters.
     */
    protected static String createStringURL(
            String method, 
            String submethod, 
            TMDbApiURLParameter... apiParameters) {
        
        StringBuilder url = new StringBuilder();
        
        url.append(BASE_API_URL).append(PATH_DELIMITER);
        url.append(API_VERISON).append(PATH_DELIMITER);
        
        if (method != null && method.length() > 0) {
            url.append(PATH_DELIMITER).append(method);
        } else {
            log.debug("Method missing");
        }
        
        if (submethod != null && submethod.length() > 0) {
            url.append(PATH_DELIMITER).append(submethod);
        } else {
            log.debug("Sub-method missing");
        }
        
        url.append(patametersToString(apiParameters));
        
        return url.toString();
    }
    
    /**
     * Returns url String representation constructed of method, submethod, id and parameters.
     * 
     * @param method TMDb method
     * @param submethod TMDb submethod
     * @param id TMDb id
     * @param apiParameters TMDb parameters
     * 
     * @return url String representation constructed of method, submethod, id and parameters.
     */
    protected static String createStringIdURL(
            String method, 
            String submethod, 
            Integer id, 
            TMDbApiURLParameter... apiParameters) {
        
        StringBuilder url = new StringBuilder();
        
        url.append(BASE_API_URL).append(PATH_DELIMITER);
        url.append(API_VERISON);
        
        if (method != null && method.length() > 0) {
            url.append(PATH_DELIMITER).append(method);
        } else {
            log.debug("Method missing");
        }
                
        if (id != null && id > 1) {
            url.append(PATH_DELIMITER).append(id);
        } else {
            log.debug("Invalid tmdb id: " + id);
        }
        
        if (submethod != null && submethod.length() > 0) {
            url.append(PATH_DELIMITER).append(submethod);
        } else {
            log.debug("Sub-method missing");
        }

        url.append(patametersToString(apiParameters));
        
        return url.toString();
    }
    
    /**
     * Returns string representation of parameters array. First one has '?' as
     * a delimiter, others have '&'.
     *  
     * @param apiParameters TMDb parameters
     * 
     * @return string representation of parameters array
     */
    protected static String patametersToString(TMDbApiURLParameter... apiParameters) {
        StringBuilder url = new StringBuilder();
        
        if (apiParameters != null && apiParameters.length > 0) {
            boolean isFirst = true;
            
            for (int i = 0; i < apiParameters.length; i++) {
                /*
                 * Ignore null parameters
                 */
                if (apiParameters[i] != null) {
                    /*
                     * Ignore invalid parameters  
                     */
                    if (apiParameters[i].isValid()) {
                        /*
                         * First parameter has '?' as delimiter, others have '&.'
                         */
                        if (isFirst) {
                            url.append(FIRST_PARAMETER_DELIMITER);
                            url.append(apiParameters[i].toString());
                            
                            isFirst = false;
                        } else {
                            url.append(PARAMETER_DELIMITER);
                            url.append(apiParameters[i].toString());
                        }
                    } else {
                        log.debug("Invalid parameter " + apiParameters[i].toString());
                    } 
                }
            }
        }
        
        return url.toString();
    }
}

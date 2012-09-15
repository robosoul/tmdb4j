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
package com.tmdb4j.service.data;

import org.apache.log4j.Logger;

/**
 * Wrapper class for URL parameter.
 * 
 * @author Luka Obradovic, 2012
 * 
 */
public class TMDbApiURLParameter {
    public static final Logger log = Logger.getLogger(TMDbApiURLParameter.class);
    
    /*
     * Known TMDb API v3 parameters.
     */
    public static final String API_KEY_PARAMETER       = "api_key";
    public static final String QUERY_PARAMETER         = "query";
    public static final String PAGE_PARAMETER          = "page";
    public static final String INCLUDE_ADULT_PARAMETER = "include_adult";
    public static final String LANGUAGE_PARAMETER      = "language";
    public static final String COUNTRY_PARAMETER       = "country";
    public static final String YEAR_PARAMETER          = "year";
    
    /*
     * Parameter name.
     */
    private String name;
    
    /*
     * Parameter value.
     */
    private String value;

    /**
     * Creates new object of class TMDbApiURLParameter with name and value.
     * 
     * @param name
     * @param value
     */
    public TMDbApiURLParameter(String name, String value) {
        this.name  = name;
        this.value = value;
    }
    
    /**
     * Creates new object of class TMDbApiURLParameter with name and value.
     * 
     * @param name
     * @param value
     */
    public TMDbApiURLParameter(String name, Integer value) {
        this.name  = name;
        this.value = (value == null) ? null : String.valueOf(value);
    }
    
    /**
     * Creates new object of class TMDbApiURLParameter with name and value.
     * 
     * @param name
     * @param value
     */
    public TMDbApiURLParameter(String name, Boolean value) {
        this.name  = name;
        this.value = (value == null) ? null : String.valueOf(value);
    }
    
    /**
     * Returns true if both name and value are set (not null and not empty).
     * 
     * @return true if both name and value are set (not null and not empty).
     */
    public boolean isValid() {
        return name != null 
                && name.length() > 0 
                && value != null 
                && value.length() > 0;
    }
    
    @Override
    public String toString() {
        return name + "=" + value;
    }    
}

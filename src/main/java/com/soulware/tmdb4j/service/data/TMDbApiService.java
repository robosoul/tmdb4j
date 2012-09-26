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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;


public class TMDbApiService {
    public static final Logger log = Logger.getLogger(TMDbApiService.class);
        
    private TMDbApiService() {
        
    }
    
    public static InputStream get(URL url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            final int statusCode = connection.getResponseCode();
            if (statusCode == 200) {
                return connection.getInputStream();
            } else {
                log.warn("Error status code " + statusCode + "for URL " + url);
                return null;
            }
        } catch (IOException ex) {
            log.warn("Error for URL " + url, ex);
        }
        
        return null;
    }
}

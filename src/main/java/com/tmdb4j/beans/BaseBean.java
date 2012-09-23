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
package com.tmdb4j.beans;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonAnySetter;

/**
 * 
 * @author Luka Obradovic, 2012
 *
 */
public class BaseBean implements Serializable {
    public static final Logger log = Logger.getLogger(BaseBean.class);

    private static final long serialVersionUID = 1L;
    
    @JsonAnySetter
    public void handleUnknown(String key, Object value) {
        StringBuilder message = new StringBuilder();
        
        message.append("Unknown JSON property: '").append(key);
        message.append("' value: '").append(value).append("'");
        
        log.trace(message.toString());
    }
}

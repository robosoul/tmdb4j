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
package com.soulware.tmdb4j.beans.model.lists;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.soulware.tmdb4j.beans.BaseBean;
import com.soulware.tmdb4j.beans.model.GenreBean;

/**
 * Bean that stores genre list.
 *  
 * @author Luka Obradovic, 2012
 * 
 * Model: http://help.themoviedb.org/kb/api/genre-list
 */
public class GenreListBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("genres")
    private List<GenreBean> genres;

    /**
     * @return the genres
     */
    public List<GenreBean> getGenres() {
        return genres;
    }

    /**
     * @param genres the genres to set
     */
    public void setGenres(List<GenreBean> genres) {
        this.genres = genres;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("GenreList [genres=").append(genres);
        builder.append("]");
       
        return builder.toString();
    }
}

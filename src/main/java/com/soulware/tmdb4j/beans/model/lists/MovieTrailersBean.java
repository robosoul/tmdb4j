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
import com.soulware.tmdb4j.beans.model.TrailerBean;

/**
 * 
 * @author Luka Obradovic, 2012
 *
 * Model: http://help.themoviedb.org/kb/api/movie-trailers
 */
public class MovieTrailersBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private int id;
    
    @JsonProperty("quicktime")
    private List<TrailerBean> quicktime;
    
    @JsonProperty("youtube")
    private List<TrailerBean> youtube;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the quicktime
     */
    public List<TrailerBean> getQuicktime() {
        return quicktime;
    }

    /**
     * @param quicktime the quicktime to set
     */
    public void setQuicktime(List<TrailerBean> quicktime) {
        this.quicktime = quicktime;
    }

    /**
     * @return the youtube
     */
    public List<TrailerBean> getYoutube() {
        return youtube;
    }

    /**
     * @param youtube the youtube to set
     */
    public void setYoutube(List<TrailerBean> youtube) {
        this.youtube = youtube;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
       
        result = prime * result + id;
       
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (!(obj instanceof MovieTrailersBean)) {
            return false;
        }
        
        final MovieTrailersBean other = (MovieTrailersBean) obj;
        
        if (id != other.id) {
            return false;
        }        
        
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("MovieTrailers [id=").append(id);
        builder.append(", quicktime=").append(quicktime);
        builder.append(", youtube=").append(youtube);
        builder.append("]");
     
        return builder.toString();
    }    
}

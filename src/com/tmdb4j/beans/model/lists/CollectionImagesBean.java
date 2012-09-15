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
package com.tmdb4j.beans.model.lists;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tmdb4j.beans.BaseBean;
import com.tmdb4j.beans.model.ImageBean;

/**
 * Bean that stores collection images.
 * 
 * @author Luka Obradovic, 2012
 * 
 * Model: http://help.themoviedb.org/kb/api/collection-images
 * 
 */
public class CollectionImagesBean extends BaseBean {
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("id")
    private int id;
    
    @JsonProperty("backdrops")
    private List<ImageBean> backdrops;
    
    @JsonProperty("posters")
    private List<ImageBean> posters;

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
     * @return the backdrops
     */
    public List<ImageBean> getBackdrops() {
        return backdrops;
    }

    /**
     * @param backdrops the backdrops to set
     */
    public void setBackdrops(List<ImageBean> backdrops) {
        this.backdrops = backdrops;
    }

    /**
     * @return the posters
     */
    public List<ImageBean> getPosters() {
        return posters;
    }

    /**
     * @param posters the posters to set
     */
    public void setPosters(List<ImageBean> posters) {
        this.posters = posters;
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
        
        if (!(obj instanceof CollectionImagesBean)) {
            return false;
        }
        
        final CollectionImagesBean other = (CollectionImagesBean) obj;
        
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
        
        builder.append("CollectionImages [id=").append(id);
        builder.append(", backdrops=").append(backdrops);
        builder.append(", posters=").append(posters);
        builder.append("]");
     
        return builder.toString();
    }    
}

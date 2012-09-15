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
import com.tmdb4j.beans.model.CollectionBean;

/**
 * Bean that stores collection info.
 *
 * @author Luka Obradovic, 2012
 * 
 * Model: http://help.themoviedb.org/kb/api/collection-info
 * 
 */
public class CollectionInfoBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("backdrop_path")
    private String backdropPath;
    
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;
    
    @JsonProperty("poster_path")
    private String posterPath;
    
    @JsonProperty("parts")
    private List<CollectionBean> parts;

    /**
     * @return the backdropPath
     */
    public String getBackdropPath() {
        return backdropPath;
    }

    /**
     * @param backdropPath the backdropPath to set
     */
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the posterPath
     */
    public String getPosterPath() {
        return posterPath;
    }

    /**
     * @param posterPath the posterPath to set
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    /**
     * @return the parts
     */
    public List<CollectionBean> getParts() {
        return parts;
    }

    /**
     * @param parts the parts to set
     */
    public void setParts(List<CollectionBean> parts) {
        this.parts = parts;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        
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
        
        if (!(obj instanceof CollectionInfoBean)) {
            return false;
        }
        
        final CollectionInfoBean other = (CollectionInfoBean) obj;
        
        if (id != other.id) {
            return false;
        }
        
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
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
        
        builder.append("CollectionInfo [backdropPath=").append(backdropPath);
        builder.append(", id=").append(id);
        builder.append(", name=").append(name);
        builder.append(", posterPath=").append(posterPath);
        builder.append(", parts=").append(parts);
        builder.append("]");
     
        return builder.toString();
    }
}

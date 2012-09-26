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
import com.soulware.tmdb4j.beans.model.KeywordBean;

/**
 * 
 * @author Luka Obradovic, 2012
 *
 * Model: http://help.themoviedb.org/kb/api/movie-keywords
 */
public class MovieKeywordsBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private int id;
    
    @JsonProperty("keywords")
    private List<KeywordBean> keywords;

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
     * @return the keywords
     */
    public List<KeywordBean> getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(List<KeywordBean> keywords) {
        this.keywords = keywords;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        
        result = prime * result + id;
        result =
                prime * result + ((keywords == null) ? 0 : keywords.hashCode());
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
        
        if (!(obj instanceof MovieKeywordsBean)) {
            return false;
        }
        
        final MovieKeywordsBean other = (MovieKeywordsBean) obj;
        
        if (id != other.id) {
            return false;
        }
        
        if (keywords == null) {
            if (other.keywords != null) {
                return false;
            }
        } else if (!keywords.equals(other.keywords)) {
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
        
        builder.append("MovieKeywords [id=").append(id);
        builder.append(", keywords=").append(keywords);
        builder.append("]");
     
        return builder.toString();
    }
}

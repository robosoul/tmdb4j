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
package com.soulware.tmdb4j.beans.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.soulware.tmdb4j.beans.BaseBean;

/**
 * 
 * @author Luka Obradovic, 2012
 *
 */
public class TitleBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("iso_3166_1")
    private String isoCode;
    
    @JsonProperty("title")
    private String title;

    /**
     * @return the isoCode
     */
    public String getIsoCode() {
        return isoCode;
    }

    /**
     * @param isoCode the isoCode to set
     */
    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isoCode == null) ? 0 : isoCode.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
        
        if (!(obj instanceof TitleBean)) {
            return false;
        }
        
        final TitleBean other = (TitleBean) obj;
        
        if (isoCode == null) {
            if (other.isoCode != null) {
                return false;
            }
        } else if (!isoCode.equals(other.isoCode)) {
            return false;
        }
        
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
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
        
        builder.append("Title [isoCode=").append(isoCode);
        builder.append(", title=").append(title);
        builder.append("]");
     
        return builder.toString();
    }
}

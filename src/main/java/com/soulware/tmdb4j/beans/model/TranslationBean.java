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

public class TranslationBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("english_name")
    private String englishName;
    
    @JsonProperty("iso_639_1")
    private String isoCode;
    
    @JsonProperty("name")
    private String name;

    /**
     * @return the englishName
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * @param englishName the englishName to set
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        
        result =
                prime * result
                        + ((englishName == null) ? 0 : englishName.hashCode());
        result = prime * result + ((isoCode == null) ? 0 : isoCode.hashCode());
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
        
        if (!(obj instanceof TranslationBean)) {
            return false;
        }
        
        final TranslationBean other = (TranslationBean) obj;
        
        if (englishName == null) {
            if (other.englishName != null) {
                return false;
            }
        } else if (!englishName.equals(other.englishName)) {
            return false;
        }
        
        if (isoCode == null) {
            if (other.isoCode != null) {
                return false;
            }
        } else if (!isoCode.equals(other.isoCode)) {
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
        
        builder.append("Translation [englishName=").append(englishName);
        builder.append(", isoCode=").append(isoCode);
        builder.append(", name=").append(name);
        builder.append("]");
        
        return builder.toString();
    }
}

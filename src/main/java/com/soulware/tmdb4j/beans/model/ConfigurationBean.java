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


import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.soulware.tmdb4j.beans.BaseBean;

/**
 * 
 * @author Luka Obradovic, 2012
 *
 * Model: http://help.themoviedb.org/kb/api/configuration
 */
public class ConfigurationBean extends BaseBean {
    public static final Logger log = Logger.getLogger(ConfigurationBean.class);

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("base_url")
    private String baseUrl;
    
    @JsonProperty("poster_sizes")
    private List<String> posterSizes;
    
    @JsonProperty("backdrop_sizes")
    private List<String> backdropSizes;
    
    @JsonProperty("profile_sizes")
    private List<String> profileSizes;
    
    @JsonProperty("logo_sizes")
    private List<String> logoSizes;

    /**
     * @return the baseUrl
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * @param baseUrl the baseUrl to set
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * @return the posterSizes
     */
    public List<String> getPosterSizes() {
        return posterSizes;
    }

    /**
     * @param posterSizes the posterSizes to set
     */
    public void setPosterSizes(List<String> posterSizes) {
        this.posterSizes = posterSizes;
    }

    /**
     * @return the backdropSizes
     */
    public List<String> getBackdropSizes() {
        return backdropSizes;
    }

    /**
     * @param backdropSizes the backdropSizes to set
     */
    public void setBackdropSizes(List<String> backdropSizes) {
        this.backdropSizes = backdropSizes;
    }

    /**
     * @return the profileSizes
     */
    public List<String> getProfileSizes() {
        return profileSizes;
    }

    /**
     * @param profileSizes the profileSizes to set
     */
    public void setProfileSizes(List<String> profileSizes) {
        this.profileSizes = profileSizes;
    }

    /**
     * @return the logoSizes
     */
    public List<String> getLogoSizes() {
        return logoSizes;
    }

    /**
     * @param logoSizes the logoSizes to set
     */
    public void setLogoSizes(List<String> logoSizes) {
        this.logoSizes = logoSizes;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Configuration [baseUrl=").append(baseUrl);
        builder.append(", posterSizes=").append(posterSizes);
        builder.append(", backdropSizes=").append(backdropSizes);
        builder.append(", profileSizes=").append(profileSizes);
        builder.append(", logoSizes=").append(logoSizes);
        builder.append("]");
        
        return builder.toString();
    }
}

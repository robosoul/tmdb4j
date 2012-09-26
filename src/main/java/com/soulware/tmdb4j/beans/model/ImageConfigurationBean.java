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
public class ImageConfigurationBean extends BaseBean {
    public static final Logger log = Logger.getLogger(ImageConfigurationBean.class);

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("images")
    ConfigurationBean images;
    
    /**
     * @return the images
     */
    public ConfigurationBean getImages() {
        return images;
    }
    
    /**
     * @param images the images to set
     */
    public void setImages(ConfigurationBean images) {
        this.images = images;
    }

    /**
     * @return the backdropSizes
     */
    public List<String> getBackdropSizes() {
        return images.getBackdropSizes();
    }

    /**    
     * @return baseUrl
     */
    public String getBaseUrl() {
        return images.getBaseUrl();
    }    

    /**
     * @return the logoSizes
     */
    public List<String> getLogoSizes() {
        return images.getLogoSizes();
    }
    
    /**
     * @return the profileSizes
     */
    public List<String> getProfileSizes() {
        return images.getProfileSizes();
    }
    
    /**
     * @return the posterSizes
     */
    public List<String> getPosterSizes() {
        return images.getPosterSizes();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ImageConfigurationBean [images=");
        builder.append(images);
        builder.append("]");
        return builder.toString();
    }
}

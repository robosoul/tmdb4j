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
package com.tmdb4j.beans.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tmdb4j.beans.BaseBean;

/**
 * 
 * @author Luka Obradovic, 2012
 *
 */
public class ImageBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("aspect_ratio")
    private float aspectRatio;
    
    @JsonProperty("file_path")
    private String filePath;
    
    @JsonProperty("height")
    private int height;
    
    @JsonProperty("iso_639_1")
    private String isoCode;
    
    @JsonProperty("width")
    private int width;

    /**
     * @return the aspectRatio
     */
    public float getAspectRatio() {
        return aspectRatio;
    }

    /**
     * @param aspectRatio the aspectRatio to set
     */
    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
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
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        
        result = prime * result + Float.floatToIntBits(aspectRatio);
        result =
                prime * result + ((filePath == null) ? 0 : filePath.hashCode());
        result = prime * result + height;
        result = prime * result + ((isoCode == null) ? 0 : isoCode.hashCode());
        result = prime * result + width;
        
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
        
        if (!(obj instanceof ImageBean)) {
            return false;
        }
        
        final ImageBean other = (ImageBean) obj;
        if (Float.floatToIntBits(aspectRatio) != Float.floatToIntBits(other.aspectRatio)) {
            return false;
        }
        
        if (filePath == null) {
            if (other.filePath != null) {
                return false;
            }
        } else if (!filePath.equals(other.filePath)) {
            return false;
        }
        
        if (height != other.height) {
            return false;
        }
        
        if (isoCode == null) {
            if (other.isoCode != null) {
                return false;
            }
        } else if (!isoCode.equals(other.isoCode)) {
            return false;
        }
        
        if (width != other.width) {
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
        
        builder.append("Image [aspectRatio=").append(aspectRatio);
        builder.append(", filePath=").append(filePath);
        builder.append(", height=").append(height);
        builder.append(", isoCode=").append(isoCode);
        builder.append(", width=").append(width);
        builder.append("]");
        
        return builder.toString();
    }
}

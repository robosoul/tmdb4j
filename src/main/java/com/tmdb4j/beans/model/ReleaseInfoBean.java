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

public class ReleaseInfoBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("certification")
    private String certification;
    
    @JsonProperty("iso_3166_1")
    private String isoCode;
    
    @JsonProperty("release_date")
    private String releaseDate;

    /**
     * @return the certification
     */
    public String getCertification() {
        return certification;
    }

    /**
     * @param certification the certification to set
     */
    public void setCertification(String certification) {
        this.certification = certification;
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
     * @return the releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        
        result =
                prime
                        * result
                        + ((certification == null) ? 0 : certification
                            .hashCode());
        result = prime * result + ((isoCode == null) ? 0 : isoCode.hashCode());
        result =
                prime * result
                        + ((releaseDate == null) ? 0 : releaseDate.hashCode());
        
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
        
        if (!(obj instanceof ReleaseInfoBean)) {
            return false;
        }
        
        final ReleaseInfoBean other = (ReleaseInfoBean) obj;
        
        if (certification == null) {
            if (other.certification != null) {
                return false;
            }
        } else if (!certification.equals(other.certification)) {
            return false;
        }
        
        if (isoCode == null) {
            if (other.isoCode != null) {
                return false;
            }
        } else if (!isoCode.equals(other.isoCode)) {
            return false;
        }
        
        if (releaseDate == null) {
            if (other.releaseDate != null) {
                return false;
            }
        } else if (!releaseDate.equals(other.releaseDate)) {
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
        
        builder.append("ReleaseInfo [certification=").append(certification);
        builder.append(", isoCode=").append(isoCode);
        builder.append(", releaseDate=").append(releaseDate);
        builder.append("]");
        
        return builder.toString();
    }
}

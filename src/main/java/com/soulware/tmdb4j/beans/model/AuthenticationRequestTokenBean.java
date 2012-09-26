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
public class AuthenticationRequestTokenBean extends BaseBean {
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("expires_at")
    private String expiresAt;
    
    @JsonProperty("request_token")
    private String requestToken;
    
    @JsonProperty("success")
    private boolean success;

    /**
     * @return the expiresAt
     */
    public String getExpiresAt() {
        return expiresAt;
    }

    /**
     * @param expiresAt the expiresAt to set
     */
    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    /**
     * @return the requestToken
     */
    public String getRequestToken() {
        return requestToken;
    }

    /**
     * @param requestToken the requestToken to set
     */
    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
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
                        + ((requestToken == null) ? 0 : requestToken.hashCode());
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
        
        if (!(obj instanceof AuthenticationRequestTokenBean)) {
            return false;
        }
        
        AuthenticationRequestTokenBean other =
                (AuthenticationRequestTokenBean) obj;
        
        if (requestToken == null) {
            if (other.requestToken != null) {
                return false;
            }
        } else if (!requestToken.equals(other.requestToken)) {
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
        
        builder.append("AuthenticationRequestTokenBean [expiresAt=").append(expiresAt);
        builder.append(", requestToken=").append(requestToken);
        builder.append(", success=").append(success);
        builder.append("]");
     
        return builder.toString();
    }
    
}

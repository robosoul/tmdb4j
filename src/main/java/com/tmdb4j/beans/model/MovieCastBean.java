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

public class MovieCastBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("character")
    private String character;
    
    @JsonProperty("id")
    private int id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("order")
    private int order;
    
    @JsonProperty("profile_path")
    private String profilePath;

    /**
     * @return the character
     */
    public String getCharacter() {
        return character;
    }

    /**
     * @param character the character to set
     */
    public void setCharacter(String character) {
        this.character = character;
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
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * @return the profilePath
     */
    public String getProfilePath() {
        return profilePath;
    }

    /**
     * @param profilePath the profilePath to set
     */
    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
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
                        + ((character == null) ? 0 : character.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + order;
        result =
                prime * result
                        + ((profilePath == null) ? 0 : profilePath.hashCode());
        
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
        
        if (!(obj instanceof MovieCastBean)) {
            return false;
        }
        
        final MovieCastBean other = (MovieCastBean) obj;
        
        if (character == null) {
            if (other.character != null) {
                return false;
            }
        } else if (!character.equals(other.character)) {
            return false;
        }
        
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
        
        if (order != other.order) {
            return false;
        }
        
        if (profilePath == null) {
            if (other.profilePath != null) {
                return false;
            }
        } else if (!profilePath.equals(other.profilePath)) {
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
        
        builder.append("MovieCast [character=");
        builder.append(character);
        builder.append(", id=").append(id);
        builder.append(", name=").append(name);
        builder.append(", order=").append(order);
        builder.append(", profilePath=").append(profilePath);
        builder.append("]");
     
        return builder.toString();
    }
}

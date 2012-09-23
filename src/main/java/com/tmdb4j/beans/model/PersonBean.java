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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tmdb4j.beans.BaseBean;

/**
 * 
 * @author Luka Obradovic, 2012
 *
 * Model: http://help.themoviedb.org/kb/api/person-info
 */
public class PersonBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("adult")
    private boolean adult;
    
    @JsonProperty("also_known_as")
    private List<String> aka;
    
    @JsonProperty("biography")
    private String biography;
    
    @JsonProperty("birthday")
    private String birthday;
    
    @JsonProperty("deathday")
    private String deathday;
    
    @JsonProperty("homepage")
    private String homepage;
    
    @JsonProperty("id")
    private int id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("place_of_birth")
    private String placeOfBirth;
    
    @JsonProperty("profile_path")
    private String profilePath;

    /**
     * @return the adult
     */
    public boolean isAdult() {
        return adult;
    }

    /**
     * @param adult the adult to set
     */
    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    /**
     * @return the aka
     */
    public List<String> getAka() {
        return aka;
    }

    /**
     * @param aka the aka to set
     */
    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    /**
     * @return the biography
     */
    public String getBiography() {
        return biography;
    }

    /**
     * @param biography the biography to set
     */
    public void setBiography(String biography) {
        this.biography = biography;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the deathday
     */
    public String getDeathday() {
        return deathday;
    }

    /**
     * @param deathday the deathday to set
     */
    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    /**
     * @return the homepage
     */
    public String getHomepage() {
        return homepage;
    }

    /**
     * @param homepage the homepage to set
     */
    public void setHomepage(String homepage) {
        this.homepage = homepage;
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
     * @return the placeOfBirth
     */
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * @param placeOfBirth the placeOfBirth to set
     */
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
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
        
        if (!(obj instanceof PersonBean)) {
            return false;
        }
        
        final PersonBean other = (PersonBean) obj;
        
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
        
        builder.append("Person [adult=").append(adult);
        builder.append(", a.k.a.=").append(aka);
        builder.append(", biography=").append(biography);
        builder.append(", birthday=").append(birthday);
        builder.append(", deathday=").append(deathday);
        builder.append(", homepage=").append(homepage);
        builder.append(", id=").append(id);
        builder.append(", name=").append(name);
        builder.append(", placeOfBirth=").append(placeOfBirth);
        builder.append(", profilePath=").append(profilePath);
        builder.append("]");
     
        return builder.toString();
    }       
}

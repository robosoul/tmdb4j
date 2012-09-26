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
 * Model: http://help.themoviedb.org/kb/api/company-info
 */
public class CompanyBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("description")
    private String description;
    
    @JsonProperty("headquarters")
    private String headquarters;
    
    @JsonProperty("homepage")
    private String homepage;
    
    @JsonProperty("id")
    private int id;
    
    @JsonProperty("logo_path")
    private String logoPath;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("parent_company")
    private String parentCompany;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the headquarters
     */
    public String getHeadquarters() {
        return headquarters;
    }

    /**
     * @param headquarters the headquarters to set
     */
    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
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
     * @return the logoPath
     */
    public String getLogoPath() {
        return logoPath;
    }

    /**
     * @param logoPath the logoPath to set
     */
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
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
     * @return the parentCompany
     */
    public String getParentCompany() {
        return parentCompany;
    }

    /**
     * @param parentCompany the parentCompany to set
     */
    public void setParentCompany(String parentCompany) {
        this.parentCompany = parentCompany;
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
                prime * result + ((logoPath == null) ? 0 : logoPath.hashCode());
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
        
        if (!(obj instanceof CompanyBean)) {
            return false;
        }
        
        final CompanyBean other = (CompanyBean) obj;
        
        if (id != other.id) {
            return false;
        }
        
        if (logoPath == null) {
            if (other.logoPath != null) {
                return false;
            }
        } else if (!logoPath.equals(other.logoPath)) {
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
}

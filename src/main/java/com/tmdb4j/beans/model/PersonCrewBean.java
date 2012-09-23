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
public class PersonCrewBean extends BaseBean {
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("department")
    private String department;
    
    @JsonProperty("id")
    private int id;
    
    @JsonProperty("job")
    private String job; 
    
    @JsonProperty("original_title")
    private String originalTitle; 
    
    @JsonProperty("poster_path")
    private String posterPath; 
    
    @JsonProperty("release_date")
    private String releaseDate; 
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("adult")
    private String adult;
    
    /**
     * @return the adult
     */
    public String getAdult() {
        return adult;
    }

    /**
     * @param adult the adult to set
     */
    public void setAdult(String adult) {
        this.adult = adult;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
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
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return the originalTitle
     */
    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     * @param originalTitle the originalTitle to set
     */
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    /**
     * @return the posterPath
     */
    public String getPosterPath() {
        return posterPath;
    }

    /**
     * @param posterPath the posterPath to set
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
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
        result =
                prime * result
                        + ((department == null) ? 0 : department.hashCode());
        result = prime * result + id;
        result = prime * result + ((job == null) ? 0 : job.hashCode());
        result =
                prime
                        * result
                        + ((originalTitle == null) ? 0 : originalTitle
                            .hashCode());
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
        
        if (!(obj instanceof PersonCrewBean)) {
            return false;
        }
        
        final PersonCrewBean other = (PersonCrewBean) obj;        
        if (department == null) {
            if (other.department != null) {
                return false;
            }
        } else if (!department.equals(other.department)) {
            return false;
        }
        
        if (id != other.id) {
            return false;
        }
        
        if (job == null) {
            if (other.job != null) {
                return false;
            }
        } else if (!job.equals(other.job)) {
            return false;
        }
        
        if (originalTitle == null) {
            if (other.originalTitle != null) {
                return false;
            }
        } else if (!originalTitle.equals(other.originalTitle)) {
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
    
        builder.append("Crew [department=").append(department);
        builder.append(", id=").append(id);
        builder.append(", job=").append(job);
        builder.append(", originalTitle=").append(originalTitle);
        builder.append(", posterPath=").append(posterPath);
        builder.append(", releaseDate=").append(releaseDate);
        builder.append(", adult=").append(adult);
        builder.append(", title=").append(title);        
        builder.append("]");
        
        return builder.toString();
    }
    
}

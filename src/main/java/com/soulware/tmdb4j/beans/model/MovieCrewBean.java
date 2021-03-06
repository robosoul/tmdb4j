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
public class MovieCrewBean extends BaseBean {
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("department")
    private String department;
    
    @JsonProperty("id")
    private int id;
    
    @JsonProperty("job")
    private String job;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("profile_path")
    private String profilePath;

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
                        + ((department == null) ? 0 : department.hashCode());
        result = prime * result + id;
        result = prime * result + ((job == null) ? 0 : job.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        
        if (!(obj instanceof MovieCrewBean)) {
            return false;
        }
        
        final MovieCrewBean other = (MovieCrewBean) obj;
        
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
        
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
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
        
        builder.append("MovieCrew [department=").append(department);
        builder.append(", id=").append(id);
        builder.append(", job=").append(job);
        builder.append(", name=").append(name);
        builder.append(", profilePath=").append(profilePath);
        builder.append("]");
        
        return builder.toString();
    }
}

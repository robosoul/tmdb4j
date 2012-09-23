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
package com.tmdb4j.beans.model.lists;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tmdb4j.beans.BaseBean;
import com.tmdb4j.beans.model.MovieBean;

/**
 * Wrapper class for all movies list.
 * 
 * @author Luka Obradovic, 2012
 * 
 * Handles:
 *http://help.themoviedb.org/kb/api/movie-similar-movies
 *http://help.themoviedb.org/kb/api/upcoming-movies
 *http://help.themoviedb.org/kb/api/now-playing-movies
 *http://help.themoviedb.org/kb/api/top-rated-movies
 */
public class MoviesListBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("page")
    private int page;
    
    @JsonProperty("total_pages")
    private int totalPages;
    
    @JsonProperty("total_results")
    private int totalResults;
    
    @JsonProperty("results")
    private List<MovieBean> results;

    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return the totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * @param totalPages the totalPages to set
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * @return the totalResults
     */
    public int getTotalResults() {
        return totalResults;
    }

    /**
     * @param totalResults the totalResults to set
     */
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * @return the results
     */
    public List<MovieBean> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<MovieBean> results) {
        this.results = results;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("MoviesList [page=").append(page);
        builder.append(", totalPages=").append(totalPages);
        builder.append(", totalResults=").append(totalResults);
        builder.append(", results=").append(results);
        builder.append("]");
        
        return builder.toString();
    }
}

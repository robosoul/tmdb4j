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
 * Model: http://help.themoviedb.org/kb/api/movie-info
 */
public class MovieBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    @JsonProperty("adult")
    private boolean adult;
    
    @JsonProperty("backdrop_path")
    private String backdropPath;
    
    @JsonProperty("belongs_to_collection")
    private CollectionBean belongsToCollection;
    
    @JsonProperty("budget")
    private String budget;
    
    @JsonProperty("genres")
    private List<GenreBean> genres;
    
    @JsonProperty("homepage")
    private String homepage;
    
    @JsonProperty("id")
    private int id;
    
    @JsonProperty("imdb_id")
    private String imdbId;
    
    @JsonProperty("original_title")
    private String originalTitle;
    
    @JsonProperty("overview")
    private String overview;
    
    @JsonProperty("popularity")
    private float popularity;
    
    @JsonProperty("poster_path")
    private String posterPath;
    
    @JsonProperty("production_companies")
    private List<ProductionCompanyBean> productionCompanies;
    
    @JsonProperty("production_countries")
    private List<ProductionCountryBean> productionCountries;
    
    @JsonProperty("release_date")
    private String releaseDate;
    
    @JsonProperty("revenue")
    private long revenue;
    
    @JsonProperty("runtime")
    private int runtime;
    
    @JsonProperty("spoken_languages")
    private List<LanguageBean> spokenLanguages;
    
    @JsonProperty("tagline")
    private String tagline;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("vote_average")
    private float voteAverage;
    
    @JsonProperty("vote_count")
    private int voteCount;

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
     * @return the backdropPath
     */
    public String getBackdropPath() {
        return backdropPath;
    }

    /**
     * @param backdropPath the backdropPath to set
     */
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    /**
     * @return the belongsToCollection
     */
    public CollectionBean getBelongsToCollection() {
        return belongsToCollection;
    }

    /**
     * @param belongsToCollection the belongsToCollection to set
     */
    public void setBelongsToCollection(CollectionBean belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    /**
     * @return the budget
     */
    public String getBudget() {
        return budget;
    }

    /**
     * @param budget the budget to set
     */
    public void setBudget(String budget) {
        this.budget = budget;
    }

    /**
     * @return the genres
     */
    public List<GenreBean> getGenres() {
        return genres;
    }

    /**
     * @param genres the genres to set
     */
    public void setGenres(List<GenreBean> genres) {
        this.genres = genres;
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
     * @return the imdbId
     */
    public String getImdbId() {
        return imdbId;
    }

    /**
     * @param imdbId the imdbId to set
     */
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
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
     * @return the overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * @param overview the overview to set
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * @return the popularity
     */
    public float getPopularity() {
        return popularity;
    }

    /**
     * @param popularity the popularity to set
     */
    public void setPopularity(float popularity) {
        this.popularity = popularity;
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
     * @return the productionCompanies
     */
    public List<ProductionCompanyBean> getProductionCompanies() {
        return productionCompanies;
    }

    /**
     * @param productionCompanies the productionCompanies to set
     */
    public void setProductionCompanies(List<ProductionCompanyBean> productionCompanies) {
        this.productionCompanies = productionCompanies;
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
     * @return the revenue
     */
    public long getRevenue() {
        return revenue;
    }

    /**
     * @param revenue the revenue to set
     */
    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    /**
     * @return the runtime
     */
    public int getRuntime() {
        return runtime;
    }

    /**
     * @param runtime the runtime to set
     */
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    /**
     * @return the spokenLanguages
     */
    public List<LanguageBean> getSpokenLanguages() {
        return spokenLanguages;
    }

    /**
     * @param spokenLanguages the spokenLanguages to set
     */
    public void setSpokenLanguages(List<LanguageBean> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    /**
     * @return the tagline
     */
    public String getTagline() {
        return tagline;
    }

    /**
     * @param tagline the tagline to set
     */
    public void setTagline(String tagline) {
        this.tagline = tagline;
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

    /**
     * @return the voteAverage
     */
    public float getVoteAverage() {
        return voteAverage;
    }

    /**
     * @param voteAverage the voteAverage to set
     */
    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    /**
     * @return the voteCount
     */
    public int getVoteCount() {
        return voteCount;
    }

    /**
     * @param voteCount the voteCount to set
     */
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
    
    /**
     * @return the productionCountries
     */
    public List<ProductionCountryBean> getProductionCountries() {
        return productionCountries;
    }

    /**
     * @param productionCountries the productionCountries to set
     */
    public void setProductionCountries(List<ProductionCountryBean> productionCountries) {
        this.productionCountries = productionCountries;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((imdbId == null) ? 0 : imdbId.hashCode());
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
        
        if (!(obj instanceof MovieBean)) {
            return false;
        }
        
        final MovieBean other = (MovieBean) obj;
        
        if (id != other.id) {
            return false;
        }
        
        if (imdbId == null) {
            if (other.imdbId != null) {
                return false;
            }
        } else if (!imdbId.equals(other.imdbId)) {
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
        
        builder.append("Movie [adult=").append(adult);
        builder.append(", backdropPath=").append(backdropPath);
        builder.append(", belongsToCollection=").append(belongsToCollection);
        builder.append(", budget=").append(budget);
        builder.append(", genres=").append(genres);
        builder.append(", homepage=").append(homepage);
        builder.append(", id=").append(id);
        builder.append(", imdbId=").append(imdbId);
        builder.append(", originalTitle=").append(originalTitle);
        builder.append(", overview=").append(overview);
        builder.append(", popularity=").append(popularity);
        builder.append(", posterPath=").append(posterPath);
        builder.append(", productionCompanies=").append(productionCompanies);
        builder.append(", productionCountries=").append(productionCountries);
        builder.append(", releaseDate=").append(releaseDate);
        builder.append(", revenue=").append(revenue);
        builder.append(", runtime=").append(runtime);
        builder.append(", spokenLanguages=").append(spokenLanguages);
        builder.append(", tagline=").append(tagline);
        builder.append(", title=").append(title);
        builder.append(", voteAverage=").append(voteAverage);
        builder.append(", voteCount=").append(voteCount);
        builder.append("]");
        
        return builder.toString();
    }
}

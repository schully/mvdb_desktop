/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.mvdb_desktop;

/**
 *
 * @author ElKebabHenry
 */
public class MoviePreview {
    private int movieId;
    private String title;

    public MoviePreview(int movieId, String title) {
        this.movieId = movieId;
        this.title = title;
    }
    
    public MoviePreview(String title) {
        this.title = title;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

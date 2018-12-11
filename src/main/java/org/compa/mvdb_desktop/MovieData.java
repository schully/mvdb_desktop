/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.mvdb_desktop;

import java.util.List;

/**
 *
 * @author ElKebabHenry
 */
public class MovieData {
    private int id;
    private String title;
    private int runtime;
    private double imdbScore;
    private String ageRated;
    private String plot;
    private List<String> genre;
    private String possessor;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public double getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public String getAgeRated() {
        return ageRated;
    }

    public void setAgeRated(String ageRated) {
        this.ageRated = ageRated;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public String getPossessor() {
        return possessor;
    }

    public void setPossessor(String possessor) {
        this.possessor = possessor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

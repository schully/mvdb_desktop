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
public class MovieSearch {

    public String searchQuery;
    public infoType it;

    public MovieSearch(String searchQuery, infoType it) {
        this.searchQuery = searchQuery;
        this.it = it;
    }
    
    
    public enum infoType {
        MOVIE("movie"),
        GENRE("genre");

        private String stringValue;

        private infoType(String stringValue) {
            this.stringValue = stringValue;
        }

        @Override
        public String toString() {
            return stringValue;
        }
    }

}

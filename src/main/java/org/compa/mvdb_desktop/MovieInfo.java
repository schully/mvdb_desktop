/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.mvdb_desktop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author ElKebabHenry
 */
public class MovieInfo {

    private static MovieInfo instance = new MovieInfo();

    public static MovieInfo getInstance() {
        return instance;
    }

    public Movie fetchMovie(int id) throws IOException {
        JSONObject result = BackendRequest.getInstance().request("/movie/" + id, BackendRequest.CallMethod.GET, null);
        try {
            return getMovieFromJson(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Movie getMovieFromJson(JSONObject obj) {
        JSONArray genre = obj.getJSONArray("genre");
        Movie m = new Movie();
        m.setId(obj.getString("id"));
        m.setTitle(obj.getString("title"));
        m.setRuntime(obj.getIntValue("runtime"));
        m.setImdbScore(obj.getDoubleValue("imdbScore"));
        m.setAgeRated(obj.getString("ageRated"));
        m.setPlot(obj.getString("plot"));
        m.setGenre(Arrays.asList(genre.toArray(new String[genre.size()])));
       
        return m;
    }
    
}



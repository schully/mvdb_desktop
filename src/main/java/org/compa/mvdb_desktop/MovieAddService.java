/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.mvdb_desktop;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ElKebabHenry
 */
public class MovieAddService {

    private static MovieAddService masIn = new MovieAddService();

    public static MovieAddService getMasIn() {
        return masIn;
    }

    public Movie fetchMovieFromImdb(String id) throws Exception {
        JSONObject res = BackendRequest.getInstance().request("/movie/imdb/" + URLEncoder.encode(id, "UTF8"), BackendRequest.CallMethod.GET, null);
        if ("noMatch".contentEquals(res.getString("result"))) {
            throw new IllegalArgumentException("Invalid id: " + id);
        }

        return MovieInfo.getInstance().getMovieFromJson(res.getJSONObject("result"));
    }

    public MovieAddResult submit(MovieData md) throws Exception, IOException, IllegalArgumentException {
        return submit(md, false);
    }

    public MovieAddResult submit(MovieData md, boolean updateExisting) throws Exception, IOException, IllegalArgumentException {
        Map<String, Object> p = new HashMap<>();
        p.put("title", md.getTitle());
        p.put("runtime", md.getRuntime());
        p.put("plot", md.getPlot());
        p.put("imdbScore", md.getImdbScore());
        p.put("ageRated", md.getAgeRated());
        p.put("possessor", md.getPossessor());

        List<String> genre = md.getGenre();
        if (genre != null) {
            StringBuilder joinedGenres = new StringBuilder();
            for (int i = 0, n = genre.size() - 1; i <= n; i++) {
                joinedGenres.append(genre.get(i).replaceAll("\\[|\\]", ""));
                if (i < n) {
                    joinedGenres.append(",");
                }
            }
            p.put("genre", joinedGenres.toString());
        }
        JSONObject res = BackendRequest.getInstance().request("/movie" + (!updateExisting ? "" : ("/" + md.getId())) , updateExisting ? BackendRequest.CallMethod.PUT : BackendRequest.CallMethod.POST, p);

        if (res.containsKey("validationError")) {
            throw new IllegalArgumentException(res.getString("validationError"));
        }

        if (!res.getBoolean("ok")) {
            throw new Exception("Unknown error");
        }

        return new MovieAddResult(res.getIntValue("movie_id"));

    }
}

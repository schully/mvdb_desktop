/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.mvdb_desktop;

import com.alibaba.fastjson.JSONObject;
import org.compa.mvdb_desktop.BackendRequest.CallMethod;

/**
 *
 * @author ElKebabHenry
 */
public class ListOfMovies {

    public JSONObject fetchMoviesFromDB() throws Exception {
        JSONObject res = BackendRequest.getInstance().request("/movies/", CallMethod.GET);
        return res;
    }

}

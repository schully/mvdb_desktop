/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.mvdb_desktop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author ElKebabHenry
 */
public class BackendRequest {

    private static BackendRequest instance;

    public static BackendRequest getInstance() {
        if (instance == null) {
            instance = new BackendRequest();
        }

        return instance;
    }

    public String apiUrl = "http://localhost:8094/api";

    public JSONObject request(String path, CallMethod method) throws IOException {
        return (JSONObject) request(path, method, null);
    }

    public JSONObject request(String path, CallMethod method, Map<String, Object> body) throws IOException {
        return (JSONObject) request(path, method, body, false);
    }

    public JSON request(String path, CallMethod method, Map<String, Object> body, boolean exeptArray) throws IOException {
        String url = apiUrl + path;

        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpUriRequest request;

        HttpEntity entity = null;

        switch (method) {
            case POST:
            case PUT:
                List<NameValuePair> pairs = new LinkedList<>();
                body.entrySet().forEach((arg) -> {
                    pairs.add(new BasicNameValuePair(arg.getKey(), arg.getValue().toString()));
                });
                entity = new UrlEncodedFormEntity(pairs);
                break;
        }
        switch (method) {
            case GET:
            default:
                request = new HttpGet(url);
                break;
                
            case DELETE:
                request = new HttpDelete(url);
                break;
            case POST:
                request = new HttpPost(url);
                ((HttpPost) request).setEntity(entity);
                break;

            case PUT:
                request = new HttpPut(url);
                ((HttpPut) request).setEntity(entity);
                break;
        }

        System.out.println("utl: " + url);

        HttpResponse response = client.execute(request);
        String responseText = new BasicResponseHandler().handleEntity(response.getEntity());

        System.out.println("responseText: " + responseText);

        if (exeptArray) {
            return JSON.parseArray(responseText);
        }

        return JSON.parseObject(responseText);
    }

    public static interface SuccessJsonCallBack {

        public void onSuccess(JSONObject data, int statusCode);
    }

    public static enum CallMethod {
        GET, POST, PUT, DELETE;
    }
}

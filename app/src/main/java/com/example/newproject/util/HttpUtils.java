package com.example.newproject.util;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {

    public void register(String email) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String url = "http://192.168.5.146:8080/login/";
        url += email;
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)")
                .build();
        Response response = client.newCall(request).execute();
    }
}

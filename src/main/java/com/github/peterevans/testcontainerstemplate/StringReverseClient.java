package com.github.peterevans.testcontainerstemplate;

import okhttp3.*;

import java.io.IOException;

/**
 * A simple client for our StringReverse API.
 */
public class StringReverseClient {
    private static final String CONTENT_TYPE_TEXTPLAIN = "text/plain";
    private OkHttpClient client = new OkHttpClient();
    private String url;

    public StringReverseClient(String ipAddress, int port) {
        this.url = String.format("http://%s:%d", ipAddress, port);
    }

    public String reverse(String stringToReverse) throws IOException {
        MediaType mediaType = MediaType.parse(CONTENT_TYPE_TEXTPLAIN);
        RequestBody body = RequestBody.create(mediaType, stringToReverse);
        Request request = new Request.Builder()
                .url(url + "/reverse")
                .post(body)
                .addHeader("content-type", CONTENT_TYPE_TEXTPLAIN)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}

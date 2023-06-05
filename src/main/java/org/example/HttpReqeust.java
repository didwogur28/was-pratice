package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpReqeust {

    private final RequestLine requestLine;

    public HttpReqeust(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());
    }

    public boolean isGetReqeust() {
        return requestLine.isGetRequest();
    }

    public boolean matchPath(String requestPath) {
        return requestLine.matchPath(requestPath);
    }

    public QueryStrings getQueryString() {
        return requestLine.getQueryStrings();
    }
}

package org.example;

import java.util.Objects;

public class RequestLine {

    private final String method;    // GET
    private final String urlPath;   // /calculate
    private QueryStrings querytStrings;    // operand1=11&operator=*&operand2=55

    public RequestLine(String method, String urlPath, String querytString) {
        this.method = method;
        this.urlPath = urlPath;
        this.querytStrings = new QueryStrings(querytString);
    }

    public RequestLine(String requestLine) {

        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        if (urlPathTokens.length == 2) {
            this.querytStrings = new QueryStrings(urlPathTokens[1]);
        }
    }

    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String requestPath) {
        return urlPath.equals(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return this.querytStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestLine that)) return false;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(querytStrings, that.querytStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, querytStrings);
    }

}

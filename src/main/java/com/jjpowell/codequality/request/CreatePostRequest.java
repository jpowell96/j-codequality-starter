package com.jjpowell.codequality.request;

public class CreatePostRequest {
    private final String title;
    private final String content;

    public CreatePostRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

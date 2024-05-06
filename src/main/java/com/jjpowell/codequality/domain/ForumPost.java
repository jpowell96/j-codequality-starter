package com.jjpowell.codequality.domain;

import java.util.*;

public class ForumPost {
    private final String title;
    private final String content;
    private final UUID uuid;

    // I want to be able to get the first 20 comments on the post (at depth 0) ordered by timestamp
    public ForumPost(String title, String content, UUID uuid) {
        this.title = title;
        this.content = content;
        this.uuid = uuid;
    }
}

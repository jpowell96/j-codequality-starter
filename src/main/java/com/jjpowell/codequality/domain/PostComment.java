package com.jjpowell.codequality.domain;

import java.util.*;

public class PostComment {
    private final UUID postId;
    private final UUID commentId;
    private final String content;
    private final List<PostComment>
            replies; // This is a derived field. We'll just do a recursive CTE up to depth 5 from this comment's id
    private final UUID parent;
    private final long depth; // Represents how far down a comment chain this comment is. Default is 0

    public PostComment(UUID postId, UUID commentId, String content) {
        this.postId = postId;
        this.commentId = commentId;
        this.content = content;
        this.replies = new ArrayList<>();
        this.parent = null;
        this.depth = 0;
    }
}

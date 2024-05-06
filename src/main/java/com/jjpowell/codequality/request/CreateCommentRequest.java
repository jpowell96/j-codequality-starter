package com.jjpowell.codequality.request;

import java.util.*;

public class CreateCommentRequest {
    private String content;
    private UUID postUuid;
    private UUID parentCommentUuid;
    private long depth;

    public CreateCommentRequest(String content, UUID postUuid, UUID parentCommentUuid, long depth) {
        this.content = content;
        this.postUuid = postUuid;
        this.parentCommentUuid = parentCommentUuid;
        this.depth = depth;
    }

    public CreateCommentRequest(String content, UUID postUuid) {
        this.content = content;
        this.postUuid = postUuid;
        this.parentCommentUuid = null;
        this.depth = 0;
    }
}

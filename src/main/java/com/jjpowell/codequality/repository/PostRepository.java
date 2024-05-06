package com.jjpowell.codequality.repository;

import com.jjpowell.codequality.domain.ForumPost;
import com.jjpowell.codequality.domain.PostComment;
import java.util.*;

public interface PostRepository {
    void savePost(String title, String content);

    Optional<ForumPost> getPost(UUID id);

    void deletePost(UUID id);

    void updatePost(ForumPost post);

    List<PostComment> getComments(UUID id);

    List<ForumPost> getPosts();
}

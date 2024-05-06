package com.jjpowell.codequality.repository;

import com.jjpowell.codequality.domain.ForumPost;
import com.jjpowell.codequality.domain.PostComment;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryPostRepository implements PostRepository {
    Map<UUID, ForumPost> posts;

    public InMemoryPostRepository() {}

    public void savePost(String title, String content) {
        UUID id = UUID.randomUUID();
        posts.put(id, new ForumPost(title, content, id));
    }

    public Optional<ForumPost> getPost(UUID id) {
        return Optional.ofNullable(posts.get(id));
    }

    public void deletePost(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePost'");
    }

    public void updatePost(ForumPost post) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePost'");
    }

    public List<PostComment> getComments(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComments'");
    }

    public List<ForumPost> getPosts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPosts'");
    }
}

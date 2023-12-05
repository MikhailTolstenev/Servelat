package ru.netology.repository;

import ru.netology.model.Post;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// Stub
public class PostRepository {
  private final Map<Long, Post> list = new ConcurrentHashMap<>();
  private final AtomicLong postID = new AtomicLong();
  public List<Post> all() {

    return new ArrayList<>(list.values());
  }

  public Optional<Post> getById(long id) {

    return  Optional.ofNullable(list.get(id));
  }

  public Post save(Post post) {
    long postId = post.getId();
    if (postId == 0) {
      long newPostId = postID .getAndIncrement();
      post.setId(newPostId);
      list.put(newPostId,post);
    } else {
      list.put(postId,post);
    }
    return post;
  }

  public void removeById(long id) {
    try {
      list.remove(id);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}

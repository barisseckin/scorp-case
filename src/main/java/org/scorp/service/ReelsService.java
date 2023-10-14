package org.scorp.service;

import org.scorp.context.ApplicationContext;
import org.scorp.entity.Post;
import org.scorp.entity.User;
import org.scorp.repository.PostRepository;
import org.scorp.repository.UserRepository;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ReelsService {

    private final PostRepository postRepository = ApplicationContext.getPostRepository();
    private final UserRepository userRepository = ApplicationContext.getUserRepository();

    public List<Post> getPosts(Long userId, List<Long> postIds) {
        User owner = userRepository.findById(userId);
        List<Post> posts = postRepository.findAllByIds(postIds);
        List<Post> orderedPosts = new ArrayList<>();

        for (Long postId : postIds) {
            for (Post post : posts) {
                if (post.getId().equals(postId)) {
                    post.setOwner(owner);
                    orderedPosts.add(post);
                    break;
                }
            }
        }

        return orderedPosts;
    }

    public List<Post> mergePosts(List<List<Post>> listOfPosts) {
        List<Post> mergedList = new ArrayList<>();
        for (List<Post> posts : listOfPosts) {
            mergedList.addAll(posts);
        }

        sortByCreatedAtIfSameSortById(mergedList);

        sortByCreatedAtDesc(mergedList);

        sortByCreatedAtIfSameSortByIdDesc(mergedList);

        mergedList = convertToUniqueList(mergedList);

        return mergedList;
    }

    private void sortByCreatedAtIfSameSortById(List<Post> mergedList) {
        for (int i = 0; i < mergedList.size() - 1; i++) {
            for (int j = i + 1; j < mergedList.size(); j++) {
                Post currentPost = mergedList.get(i);
                Post secondPost = mergedList.get(j);

                if (currentPost.getCreatedAt() > secondPost.getCreatedAt() ||
                        (currentPost.getCreatedAt() == secondPost.getCreatedAt() && currentPost.getId() > secondPost.getId())) {
                    mergedList.set(i, secondPost);
                    mergedList.set(j, currentPost);
                }
            }
        }
    }

    private void sortByCreatedAtDesc(List<Post> mergedList) {
        for (int i = 0; i < mergedList.size(); i++) {
            for (int j = i + 1; j < mergedList.size(); j++) {
                Post currentPost = mergedList.get(i);
                Post secondPost = mergedList.get(j);

                if (currentPost.getCreatedAt() < secondPost.getCreatedAt()) {
                    Post temp = mergedList.get(i);
                    mergedList.set(i, mergedList.get(j));
                    mergedList.set(j, temp);
                }
            }
        }
    }


    private void sortByCreatedAtIfSameSortByIdDesc(List<Post> mergedList) {
        for (int i = 0; i < mergedList.size(); i++) {
            for (int j = i + 1; j < mergedList.size(); j++) {
                Post currentPost = mergedList.get(i);
                Post secondPost = mergedList.get(j);

                if (currentPost.getCreatedAt() < secondPost.getCreatedAt() ||
                        (currentPost.getCreatedAt() == secondPost.getCreatedAt() && currentPost.getId() < secondPost.getId())) {
                    Post temp = mergedList.get(i);
                    mergedList.set(i, mergedList.get(j));
                    mergedList.set(j, temp);
                }
            }
        }
    }

    private List<Post> convertToUniqueList(List<Post> mergedList) {
        Set<Post> setPost = new LinkedHashSet<>(mergedList);
        return setPost.stream().toList();
    }
}
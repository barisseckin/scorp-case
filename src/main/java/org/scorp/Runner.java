package org.scorp;

import org.scorp.context.ApplicationContext;
import org.scorp.entity.Post;
import org.scorp.service.ReelsService;
import org.scorp.util.MockDataGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<List<Post>> response = new ArrayList<>();

        List<Post> postListStepOne = MockDataGenerator.createPostListStepOne();

        List<Post> postListStepTwo =MockDataGenerator.createPostListStepTwo();

        response.add(postListStepOne);
        response.add(postListStepTwo);

        ReelsService reelsService = ApplicationContext.getReelsService();

        List<Post> posts = reelsService.mergePosts(response);

        System.out.println("posts: " + posts);

        List<Post> postList = reelsService.getPosts(10L, Arrays.asList(1L, 2L));

        System.out.println("postList: " + postList);
    }
}

package org.scorp.util;

import org.scorp.core.exception.GeneralException;
import org.scorp.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class MockDataGenerator {

    private MockDataGenerator() {
        throw new GeneralException("MockDataGenerator Error");
    }

    public static List<Post> createPostListStepOne() {
        List<Post> response = new ArrayList<>();
        response.add(new Post(3L,"Test Description","Post 3", 3, false));
        response.add(new Post(1L,"Test Description","Post 1", 1, false));
        response.add(new Post(4L,"Test Description","Post 4", 2, false));
        response.add(new Post(1L,"Test Description","Post 2", 2, false));
        return response;
    }

    public static List<Post> createPostListStepTwo() {
        List<Post> response = new ArrayList<>();
        response.add(new Post(8L,"Test Description","Post 8", 2, false));
        response.add(new Post(6L,"Test Description","Post 6", 6, false));
        response.add(new Post(7L,"Test Description","Post 7", 3, false));
        response.add(new Post(5L,"Test Description","Post 5", 5, false));
        return response;
    }
}

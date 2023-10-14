package org.scorp.context;

import org.scorp.core.exception.GeneralException;
import org.scorp.repository.PostRepository;
import org.scorp.repository.UserRepository;
import org.scorp.service.ReelsService;

import java.util.Objects;

public class ApplicationContext {

    private ApplicationContext() {
        throw new GeneralException("ApplicationContext Error");
    }

    private static PostRepository postRepository;
    private static UserRepository userRepository;
    private static ReelsService reelsService;

    public static PostRepository getPostRepository() {
        if (Objects.isNull(postRepository)) {
            postRepository = new PostRepository();
        }

        return postRepository;
    }

    public static UserRepository getUserRepository() {
        if (Objects.isNull(userRepository)) {
            userRepository = new UserRepository();
        }

        return userRepository;
    }

    public static ReelsService getReelsService() {
        if (Objects.isNull(reelsService)) {
            reelsService = new ReelsService();
        }

        return reelsService;
    }
}

package ru.netology.config;


import ru.netology.controller.PostController;
import ru.netology.repository.PostRepository;
import ru.netology.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class Config {

        @Bean
        public PostController postController() {
            return new PostController(postService());
        }

        @Bean
        public PostService postService() {
            return new PostService(postRepository());
        }

        @Bean
        public PostRepository postRepository() {
            return new PostRepository();
        }
    }


package com.tts.techtalentblog.configuration;

import com.tts.techtalentblog.model.BlogPost;
import com.tts.techtalentblog.repository.BlogPostRepository;
import com.tts.techtalentblog.service.BlogPostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Configuration
public class BlogPostConfig {
    BlogPostService service;
    CommandLineRunner commandLineRunner(BlogPostRepository repository){
    return args -> {
            repository.saveAll(List.of(service.getAllBlogs().toArray(new BlogPost[0])));
    };
}

}

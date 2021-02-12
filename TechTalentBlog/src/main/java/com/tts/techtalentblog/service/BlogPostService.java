package com.tts.techtalentblog.service;

import com.tts.techtalentblog.model.BlogPost;
import com.tts.techtalentblog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public List<BlogPost> getAllBlogs(){
        return (List<BlogPost>) blogPostRepository.findAll();
    }
    public void addNewBlogPost(BlogPost blogPost){
        Optional<BlogPost> blogPostOptional = blogPostRepository
        .findBlog(blogPost.getId());
        blogPostRepository.save(blogPost);
    }
    public void deleteById(Long id){
    boolean found = blogPostRepository.existsById(id);
    if (!found){
        throw new IllegalStateException("blog with id " + id + " not found");
    }
    blogPostRepository.deleteById(id);
    }
}

package com.tts.techtalentblog.controller;

import com.tts.techtalentblog.model.BlogPost;
import com.tts.techtalentblog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogPostController {
    //allows dependency injection
    //dependency injection gives objects the dependencies they need
    //@autowired is optional
    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPostController(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }
    private BlogPost blogPost;
    @GetMapping(value="/")
    public String index(BlogPost blogPost){
        //output generated via template
        //show desired data
        return "blogpost/index";
    }
    //mapping post requests
    @PostMapping(value="/")
    public String addNewBlogPost(BlogPost blogPost, Model model){
        //blogPost is our object we're getting from thymeleaf form
        blogPostRepository.save(blogPost);
        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";
    }
}

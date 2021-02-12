package com.tts.techtalentblog.controller;

import com.tts.techtalentblog.model.BlogPost;
import com.tts.techtalentblog.repository.BlogPostRepository;
import com.tts.techtalentblog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//giant router page similar to react
@Controller
public class BlogPostController {
    private BlogPostService blogPostService;
    private BlogPostRepository repository;
    private static List<BlogPost> posts = new ArrayList<>();
    //allows dependency injection
    //dependency injection gives objects the dependencies they need
    //@autowired is optional
    @Autowired
   // private BlogPostRepository blogPostRepository;
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }
//    @GetMapping(value = "/")
//    public List<BlogPost> getBlogPost(){
//        return blogPostService.getBlog();
//    }

    @GetMapping(value = "/")
    public String index(BlogPost blogPost, Model model) {
        //output generated via template
        //show desired data
        model.addAttribute("post ", posts);
        return "blogpost/index";
    }

    private BlogPost blogPost;

    //mapping post requests
    @PostMapping(value = "/blogpost")
    public String createNewBlogPost(BlogPost blogPost, Model model) {
        //blogPost is our object we're getting from thymeleaf form
        posts = blogPostService.getAllBlogs();
        blogPostService.addNewBlogPost(blogPost);
        model.addAttribute("id", blogPost.getId());
        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";
    }

    @GetMapping(value = "/blogpost/new")
    public String newBlog(BlogPost blogPost) {
        return "blogpost/createpost";
    }

    @RequestMapping(value = "/blogpost/{id}", method = RequestMethod.DELETE)
    public String deleteWithId(@PathVariable Long id, BlogPost blogPost) {
        blogPostService.deleteById(blogPost.getId());
        posts = blogPostService.getAllBlogs();
        return "blogpost/delete";
    }
}


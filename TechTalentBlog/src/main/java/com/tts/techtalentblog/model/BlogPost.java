package com.tts.techtalentblog.model;

import javax.persistence.*;


//table in database, entity aligns with our database
@Entity
@Table(name = "Blog_Post")
public class BlogPost {
    //@Id identify primary key in database
    //@GeneratedValue allows system to generate values: in sequence or
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String blog;

    public BlogPost(String title, String author, String blogEntry) {
        this.title = title;
        this.author = author;
        this.blog = blogEntry;
    }

    public BlogPost(Long id, String title, String author, String blog) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.blog = blog;
    }

    //default constructors are needed for @Entity, bean pick this up
    public BlogPost() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBlogEntry() {
        return blog;
    }

    public void setBlogEntry(String blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return " Title: " +  title + '\r'+'\n' +
                " Author: " + author + '\n' +
                " Entry: " + blog + "\n";
    }


    //override hashcode and equals as well.... .equals() and .hashcode()

}

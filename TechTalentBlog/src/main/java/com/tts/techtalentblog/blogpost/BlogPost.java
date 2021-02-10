package com.tts.techtalentblog.blogpost;

import javax.persistence.GeneratedValue;

public class BlogPost {
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String blogEntry;
}

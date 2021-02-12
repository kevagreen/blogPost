package com.tts.techtalentblog.repository;

import com.tts.techtalentblog.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//wrapper class, Long represent id
@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    @Query("SELECT i FROM BlogPost i WHERE i.id = ?1")
    public List<BlogPost> findBlog(Long id);
}

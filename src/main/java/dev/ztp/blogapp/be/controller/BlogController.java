package dev.ztp.blogapp.be.controller;

import dev.ztp.blogapp.be.model.BlogPost;
import dev.ztp.blogapp.be.repository.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogPostRepository blogPostRepository;

    private final Random rand = new Random();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BlogPost> getBlogPosts() {
        simulateLag();
        return blogPostRepository.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BlogPost CreateBlogPost(@RequestBody BlogPost blogPost) {
        simulateLag();
        return blogPostRepository.save(blogPost);
    }

    private void simulateLag() {
        int randomValue = rand.nextInt(100);
        if (randomValue < 30) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BlogPost updateBlogPost(@RequestBody BlogPost blogPost) {
        simulateLag();
        return blogPostRepository.save(blogPost);
    }

    @DeleteMapping("{id}")
    public void updateBlogPost(@PathVariable("id") Long id) {
        simulateLag();
        blogPostRepository.deleteById(id);
    }

}

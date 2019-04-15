package com.test.javaspringvue.api.Post;

import com.test.javaspringvue.models.post.Post;
import com.test.javaspringvue.models.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {


    @Autowired
    PostRepository postRepository;

    @GetMapping("/")
    Iterable<Post> sendAllUsersOverApi(){
        return postRepository.findAll();
    }

    @PostMapping("/")
    String createNewPost(@RequestBody Post body){
        postRepository.save(body);
        return "Shit was crap";
    }
}

package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {
    @RequestMapping("/")
    public String listPosts(ModelMap modelMap){
        List<Post> posts = postRepository.getAllPosts();
        modelMap.put("posts", posts);
        return "home";
    }

    private PostRepository postRepository;

    public BlogController (PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap) {
        Post Post = postRepository.findById(id);
        modelMap.put("post", Post);
        return "post-details";
    }
}

package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
    @RequestMapping("/")
    public String listPosts(ModelMap modelMap){

        modelMap.put("title", "Blog Post 1");
        return "home";
    }

    private PostRepository postRepository;

    public PostRepository postRepository(PostRepository postRepository) {
        return postRepository;
    }
}

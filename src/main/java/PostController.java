package technicalblog;

import Model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


import java.util.ArrayList;

@Controller
public class PostController {

    @Autowired
    private technicalblog.PostService postService;

    @RequestMapping("posts")
    public String getUserPosts(Model model) {
        ArrayList<Post> posts = postService.getOnePost();
        model.addAttribute("posts", posts);
        return "posts";

    }
}

package technicalblog;

import Model.Post;
import Model.User;
import technicalblog.UserService;
import technicalblog.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private PostService postService;
    private UserService userService;

    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registration() {
        return "users/registration";
    }

    @RequestMapping(value = "users/registration", method=RequestMethod.POST)
    public String registerUser(User user) {
        return "users/login";
    }

    @RequestMapping(value = "users/login", method= RequestMethod.POST)
    public String loginUser(User user) {
        if (user != null) {
            System.out.println("Valid User" + user.getUsername());
            return "redirect:/posts";
            //if (userService.login(user)) {
             //   return "redirect:/posts";
            //} else {
             //   return "users/login";
            //}
        } else {
            System.out.println("Null User");
            return "users/login";
        }
    }

    @RequestMapping(value = "users/logout", method= RequestMethod.POST)

    public String logoutUser(Model model) {
        ArrayList<Post> posts = postService.getAllPosts();

        model.addAttribute("posts", posts);

        return "index2";
    }

}

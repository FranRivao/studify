package frangroup.studify.view;

import frangroup.studify.StudifyApplication;
import frangroup.studify.entity.User;
import frangroup.studify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(StudifyApplication.route + "users/")
public class UserView {
    @Autowired
    private final UserService userService;
    private final String DIRECTORY = "user/";

    public UserView(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("create")
    public String showCreate() {
        return DIRECTORY + "create";
    }

    @PostMapping("create")
    public String createProcess(@RequestParam String name, @RequestParam String email, @RequestParam String password, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("password", password);

        System.out.println(name + " " + email + " " + password);
        this.userService.saveOrUpdate(User.builder().name(name).email(email).password(password).build());
        return DIRECTORY + "resultado";
    }
}

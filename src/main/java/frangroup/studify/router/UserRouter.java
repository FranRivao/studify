package frangroup.studify.router;

import frangroup.studify.StudifyApplication;
import frangroup.studify.entity.User;
import frangroup.studify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = StudifyApplication.route + "users")
public class UserRouter {
    @Autowired
    private final UserService userService;

    public UserRouter(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User saveOrUpdate(@RequestBody User user) {
        return this.userService.saveOrUpdate(user);
    }

    @GetMapping
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable("userId") Integer id) {
        return this.userService.findById(id);
    }

    @GetMapping("/{userEmail}")
    public User findByEmail(@PathVariable("userEmail") String email) {
        return this.userService.findByEmail(email);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") Integer id) {
        this.userService.delete(id);
    }
}
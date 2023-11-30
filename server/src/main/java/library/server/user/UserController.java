package library.server.user;

import library.server.book.Book;
import library.server.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public void registerUser(@RequestBody User user){
        this.userService.registerUser(user);
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody User user){
        this.userService.loginUser(user);
    }

}

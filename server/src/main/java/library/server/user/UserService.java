package library.server.user;

import library.server.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public void registerUser(User user) {
        if (isValidUser(user)) {
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Invalid user details");
        }
    }

    public User loginUser(User user) {
        User userFinded = userRepository.findByUsernameAndPassword(
                user.getUsername(), user.getPassword()
        );
        if (userFinded != null) {
            return userFinded;
        } else {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }

    private boolean isValidUser(User user) {
        return user != null && user.getUsername() != null && !user.getUsername().isEmpty()
                && user.getPassword() != null && !user.getPassword().isEmpty();
    }
}

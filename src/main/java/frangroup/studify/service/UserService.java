package frangroup.studify.service;

import frangroup.studify.entity.User;
import frangroup.studify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveOrUpdate(User user) {
        if (this.findByEmail(user.getEmail()) == null) {
            return this.userRepository.save(user);
        } else return null;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(Integer id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email).orElse(null);
    }

    public void delete(Integer id) {
        this.userRepository.deleteById(id);
    }
}

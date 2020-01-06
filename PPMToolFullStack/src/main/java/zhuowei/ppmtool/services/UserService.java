package zhuowei.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import zhuowei.ppmtool.domain.User;
import zhuowei.ppmtool.exception.UsernameAlreadyExistsException;
import zhuowei.ppmtool.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;// cannot see password

    public User saveUser(User newUser) {
        try{
             newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
             // Username has to be unique(exception)
            newUser.setUsername(newUser.getUsername());
            // make sure password and confirm password identical
        //we dont persist or show the confirm password
             newUser.setConfirmPassword(bCryptPasswordEncoder.encode(newUser.getConfirmPassword()));
             return userRepository.save(newUser);
        } catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username '" + newUser.getUsername() + "' already exists");

        }
    }
}

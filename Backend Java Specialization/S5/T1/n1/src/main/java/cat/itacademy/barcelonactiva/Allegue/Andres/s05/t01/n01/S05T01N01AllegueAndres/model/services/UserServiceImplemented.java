package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.User;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.enums.UserRoles;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.UserDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.repositories.UserRepository;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplemented implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean isUserRegisteredByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean isUserRegisteredByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserDTO add(UserDTO userDTO, String password) {
        User userToSave = convertToNonDTO(userDTO, password);
        User savedUser = userRepository.save(userToSave);
        return convertToDTO(savedUser);
    }

    @Override
    public UserDTO getOne(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private User convertToNonDTO(UserDTO userDTO, String password){
        return User.builder()
                .username(userDTO.username())
                .email(userDTO.email())
                .roles(UserRoles.USER)
                .password(passwordEncoder.encode(password))
                .build();
    }
    private UserDTO convertToDTO(User user){
        return UserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(String.valueOf(user.getRoles()))
                .profile_pic_link(user.getProfile_pic())
                .build();
    }
}

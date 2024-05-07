package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.MyUser;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.enums.UserRoles;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.AuthenticateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.RegisterRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.MyUserDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.repositories.MyUserRepository;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**/@Service
public class UserServiceImplemented implements UserService {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private static PasswordEncoder passwordEncoder;

    @Override
    public boolean isUserRegisteredByUsername(String username) {
        return myUserRepository.existsByUsername(username);
    }

    @Override
    public boolean isUserRegisteredByEmail(String email) {
        return myUserRepository.existsByEmail(email);
    }

    @Override
    public MyUserDTO add(RegisterRequest registerRequest) {
        MyUser userToSave = convertToNonDTO(registerRequest);
        return convertToDTO(myUserRepository.save(userToSave));
    }

    @Override
    public MyUserDTO getOne(AuthenticateRequest authenticateRequest) {
        return convertToDTO(myUserRepository.findByUsername(authenticateRequest.username())
                .orElseThrow());
    }

    @Override
    public MyUserDTO update(MyUserDTO myUserDTO) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public static MyUser convertToNonDTO(RegisterRequest registerRequest){
        return MyUser.builder()
                .username(registerRequest.username())
                .email(registerRequest.email())
                .roles(UserRoles.USER)
                .password(passwordEncoder.encode(registerRequest.password()))
                .build();
    }
    public static MyUser convertToNonDTO(AuthenticateRequest authenticateRequest){
        return MyUser.builder()
                .username(authenticateRequest.username())
                .email(null)
                .roles(UserRoles.USER)
                .password(passwordEncoder.encode(authenticateRequest.password()))
                .build();
    }
    private MyUserDTO convertToDTO(MyUser myUser){
        return MyUserDTO.builder()
                .username(myUser.getUsername())
                .email(myUser.getEmail())
                .roles(String.valueOf(myUser.getRoles()))
                .profile_pic_link(myUser.getProfile_pic())
                .build();
    }
}

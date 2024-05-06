package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.MyUser;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.enums.UserRoles;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.RegistrationDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.MyUserDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.repositories.MyUserRepository;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**/@Service
public class UserServiceImplemented implements UserService, UserDetailsService {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = myUserRepository.findByUsername(username);
        if (user.isPresent()){
            return new User(
                    user.get().getUsername(),
                    user.get().getPassword(),
                    user.get().getRoles().getAuthority()
            );
        } else {
            throw new UsernameNotFoundException("Username " + username + " not found.");
        }
    }

    @Override
    public boolean isUserRegisteredByUsername(String username) {
        return myUserRepository.existsByUsername(username);
    }

    @Override
    public boolean isUserRegisteredByEmail(String email) {
        return myUserRepository.existsByEmail(email);
    }

    @Override
    public MyUserDTO add(RegistrationDTO registrationDTO) {
        MyUser userToSave = convertToNonDTO(registrationDTO);
        return convertToDTO(myUserRepository.save(userToSave));
    }

    @Override
    public MyUserDTO getOne(MyUserDTO myUserDTO) {
        return convertToDTO(myUserRepository.findByUsername(myUserDTO.username())
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

    private MyUser convertToNonDTO(RegistrationDTO registrationDTO){
        return MyUser.builder()
                .username(registrationDTO.username())
                .email(registrationDTO.email())
                .roles(UserRoles.USER)
                .password(passwordEncoder.encode(registrationDTO.password()))
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

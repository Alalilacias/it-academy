package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.interfaces;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.RegistrationDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.MyUserDTO;

public interface UserService {
    boolean isUserRegisteredByUsername(String username);
    boolean isUserRegisteredByEmail(String email);
    MyUserDTO add(RegistrationDTO registrationDTO);
    MyUserDTO getOne(MyUserDTO myUserDTO);
    MyUserDTO update(MyUserDTO myUserDTO);
    boolean delete(int id);
}

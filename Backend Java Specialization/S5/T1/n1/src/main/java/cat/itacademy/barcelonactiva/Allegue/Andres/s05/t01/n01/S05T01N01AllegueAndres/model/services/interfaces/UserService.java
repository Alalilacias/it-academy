package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.interfaces;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.AuthenticateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.RegisterRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.MyUserDTO;

public interface UserService {
    boolean isUserRegisteredByUsername(String username);
    boolean isUserRegisteredByEmail(String email);
    MyUserDTO add(RegisterRequest registerRequest);
    MyUserDTO getOne(AuthenticateRequest authenticateRequest);
    MyUserDTO update(MyUserDTO myUserDTO);
    boolean delete(int id);
}

package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.interfaces;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.UserDTO;

public interface UserService {
    boolean isUserRegisteredByUsername(String username);
    boolean isUserRegisteredByEmail(String email);
    UserDTO add(UserDTO userDTO, String password);
    UserDTO getOne(UserDTO userDTO);
    UserDTO update(UserDTO userDTO);
    boolean delete(int id);
}

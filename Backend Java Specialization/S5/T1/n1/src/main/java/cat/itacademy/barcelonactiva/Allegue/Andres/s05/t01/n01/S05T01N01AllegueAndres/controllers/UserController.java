package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.controllers;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.RegistrationDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.UserServiceImplemented;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("users/")
public class UserController {
    @Autowired
    private UserServiceImplemented userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationDTO registrationDTO){
        if (userService.isUserRegisteredByUsername(registrationDTO.email())){
            ResponseEntity.ok(
                    Map.of(
                            "already_registered_email", true
                    )
            );
        }
        if (userService.isUserRegisteredByUsername(registrationDTO.username())){
            ResponseEntity.ok(
                    Map.of(
                            "username_registered_username", true
                    )
            );
        }

        userService.add(registrationDTO);
        return ResponseEntity.ok(
                Map.of(
                        "user_registered", true
                )
        );
    }
}

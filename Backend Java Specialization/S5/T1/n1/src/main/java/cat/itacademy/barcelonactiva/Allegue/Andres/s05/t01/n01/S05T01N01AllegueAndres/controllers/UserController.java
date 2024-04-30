package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.controllers;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.UserDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.UserServiceImplemented;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/")
public class UserController {
    @Autowired
    private UserServiceImplemented userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO, @RequestParam String password){
        if(userService.isUserRegisteredByUsername(userDTO.username())){
            return ResponseEntity.badRequest().body("Username already registered");
        }
        if (userService.isUserRegisteredByEmail(userDTO.email())){
            return ResponseEntity.badRequest().body("Email already registered.");
        }

        userService.add(userDTO, password);
        // User registration
        return ResponseEntity.ok("Username registered.");
    }
}

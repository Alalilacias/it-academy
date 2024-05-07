package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.AuthResponse;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.AuthenticateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.MyUserDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.RegisterRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.interfaces.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticationServiceImplemented implements AuthenticationService {
    private UserServiceImplemented userService;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userService.isUserRegisteredByUsername(request.email())){
            return AuthResponse.builder()
                            .alreadyRegisteredEmail(true)
                            .build();
        }
        if (userService.isUserRegisteredByUsername(request.username())){
            return AuthResponse.builder()
                            .alreadyRegisteredUsername(true)
                            .build();
        }

        String token = jwtService.generateToken(request.toUserDetails());
        return AuthResponse.builder()
                .userRegistered(true)
                .token(token)
                .build();
    }

    @Override
    public AuthResponse authenticate(AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        MyUserDTO user = userService.getOne(request);
        String token = jwtService.generateToken(request.toUserDetails());
        return AuthResponse.builder()
                .user_authenticated(true)
                .token(token)
                .build();
    }
}

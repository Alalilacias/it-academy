package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@SuppressWarnings("unused")
@Builder
public record UserDTO(
        @Schema(description = "The username of the user", example = "Bayonetta345") String username,
        @Schema(description = "The email address of the user", example = "bayonetta345@gmail.com") String email,
        @Schema(description = "The roles of the user, used for Spring Security purposes. Might be deprecated later", example = "USER") String roles,
        @Schema(description = "The link saved in the database to the profile picture of the user", example = "/static/images/**") String profile_pic_link
) {}

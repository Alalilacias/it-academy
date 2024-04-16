package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;

@ApiModel("DTO for the branches.")
@Builder
@Getter
@Setter
public record BranchDTO(long id, String name, String country, String type) implements Serializable {}

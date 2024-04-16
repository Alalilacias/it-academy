package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

@SuppressWarnings("unused")
public record BranchDTO (
        @Schema(description = "The unique identifier for the branch, automatically given by the database.", example = "1") long id,
        @Schema(description = "The name of the branch", example = "Example Branch") String name,
        @Schema(description = "The country where the branch is located", example = "Country Name") String country,
        @Schema(description = "The type of the branch, it will be filled using the BranchType enum", example = "EU/NON_EU") String type
) implements Serializable {}

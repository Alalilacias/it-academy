package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.Branch;

public record BranchUpdateRequest(int id, String name, String country) {
    Branch toBranch(){
        return Branch.builder()
                .id(id)
                .name(name)
                .country(country)
                .build();
    }
}

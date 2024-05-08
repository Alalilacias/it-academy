package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.Branch;

public record BranchAddRequest(String name, String country) {
    public Branch toBranch(){
        return Branch.builder()
                .name(this.name)
                .country(this.country)
                .build();
    }
}
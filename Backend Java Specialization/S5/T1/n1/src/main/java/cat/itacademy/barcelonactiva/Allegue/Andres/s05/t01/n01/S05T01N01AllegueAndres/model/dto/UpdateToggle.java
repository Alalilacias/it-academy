package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto;

import lombok.Builder;

@Builder
public record UpdateToggle(int id, String name, String country, boolean updateModalOpen) {}

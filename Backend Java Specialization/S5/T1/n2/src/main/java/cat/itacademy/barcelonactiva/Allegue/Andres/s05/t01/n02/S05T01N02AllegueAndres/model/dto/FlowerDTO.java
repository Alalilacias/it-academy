package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto;

import lombok.Builder;

@Builder
public record FlowerDTO(int id, String name, String country, String type) {}

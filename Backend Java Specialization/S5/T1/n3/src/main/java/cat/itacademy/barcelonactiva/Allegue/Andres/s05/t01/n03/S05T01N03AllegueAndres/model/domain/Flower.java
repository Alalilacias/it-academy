package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.domain;

import lombok.Builder;

@Builder
public record Flower(int id, String name, String country, String type) {}
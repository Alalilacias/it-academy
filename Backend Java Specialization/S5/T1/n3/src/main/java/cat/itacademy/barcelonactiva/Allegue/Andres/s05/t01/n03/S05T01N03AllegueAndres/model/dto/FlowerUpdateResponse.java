package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.dto;

import lombok.Builder;

@Builder
public record FlowerUpdateResponse(Flower flower, String message) {}

package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record WebResponse(List<Flower> flowers, String message) {}

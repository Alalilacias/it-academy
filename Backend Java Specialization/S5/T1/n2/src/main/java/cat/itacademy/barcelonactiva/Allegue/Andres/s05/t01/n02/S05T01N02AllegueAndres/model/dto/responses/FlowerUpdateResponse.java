package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.responses;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.FlowerDTO;
import lombok.Builder;

@Builder
public record FlowerUpdateResponse(FlowerDTO flower, String message) {}

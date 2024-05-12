package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.responses;

import lombok.Builder;

@Builder
public record FlowerUpdateResponse(boolean nameUpdated, String oldName, boolean countryUpdated, String oldCountry, FlowerResponse flowerResponse) {}

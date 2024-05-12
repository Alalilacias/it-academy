package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.requests;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.domain.Flower;

public record FlowerCreateRequest(String name, String country) {
    public Flower toFlower(){
        return Flower.builder()
                .name(name)
                .country(country)
                .build();
    }
}

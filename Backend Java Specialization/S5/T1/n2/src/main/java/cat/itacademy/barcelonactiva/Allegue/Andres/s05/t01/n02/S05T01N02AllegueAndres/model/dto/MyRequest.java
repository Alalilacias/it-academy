package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto;

public record MyRequest(String name, String country) {
    public FlowerDTO toFlowerDTO(){
        return FlowerDTO.builder()
                .name(name)
                .country(country)
                .build();
    }
}

package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.services.interfaces;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.FlowerDTO;

import java.util.List;

public interface FlowerService {
    FlowerDTO add(FlowerDTO flower);
    FlowerDTO getOne(int id);
    List<FlowerDTO> getAll();
    FlowerDTO update(FlowerDTO flower);
    boolean delete(int id);
}

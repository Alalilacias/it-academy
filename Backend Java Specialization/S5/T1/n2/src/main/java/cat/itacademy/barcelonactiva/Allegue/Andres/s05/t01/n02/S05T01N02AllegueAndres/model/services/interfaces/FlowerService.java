package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.services.interfaces;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.requests.FlowerCreateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.requests.FlowerUpdateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.responses.FlowerUpdateResponse;

import java.util.List;

public interface FlowerService {
    FlowerDTO add(FlowerCreateRequest flower);
    FlowerDTO getOne(int id);
    List<FlowerDTO> getAll();
    FlowerUpdateResponse update(FlowerUpdateRequest flower);
    boolean delete(int id);
}

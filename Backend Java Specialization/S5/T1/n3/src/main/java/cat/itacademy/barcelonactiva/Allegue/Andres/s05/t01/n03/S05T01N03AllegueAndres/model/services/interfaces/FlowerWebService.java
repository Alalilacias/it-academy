package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.services.interfaces;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.domain.FlowerCreateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.domain.FlowerUpdateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.dto.Flower;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.dto.FlowerUpdateResponse;

import java.util.List;

public interface FlowerWebService {
    Flower add(FlowerCreateRequest request);
    Flower getOne(int id);
    List<Flower> getAll();
    FlowerUpdateResponse update (FlowerUpdateRequest request);
    boolean delete(int id);
}

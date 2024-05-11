package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.services.interfaces.FlowerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerServiceImplemented implements FlowerService {
    @Override
    public FlowerDTO add(FlowerDTO flower) {
        return null;
    }

    @Override
    public FlowerDTO getOne(int id) {
        return null;
    }

    @Override
    public List<FlowerDTO> getAll() {
        return List.of();
    }

    @Override
    public FlowerDTO update(FlowerDTO flower) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}

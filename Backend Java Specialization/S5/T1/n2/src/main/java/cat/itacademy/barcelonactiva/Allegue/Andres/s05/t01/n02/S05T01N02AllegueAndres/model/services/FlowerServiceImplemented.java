package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.domain.Flower;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.exceptions.FlowerException;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.requests.FlowerCreateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.requests.FlowerUpdateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.responses.FlowerResponse;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.responses.FlowerUpdateResponse;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.repository.FlowerRepository;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.services.interfaces.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlowerServiceImplemented implements FlowerService {
    @Autowired
    private FlowerRepository repository;

    @Override
    public FlowerDTO add(FlowerCreateRequest request) {
        return repository
                .save(request.toFlower())   //SaveRequest, after turning to EntityObject.
                .toDTO();                   //Return the entity, returned to DTO for controller processing.
    }

    @Override
    public FlowerDTO getOne(int id) {
        Optional<Flower> optional = repository.findById(id);
        return optional.map(Flower::toDTO).orElse(null);
    }

    @Override
    public List<FlowerDTO> getAll() {
        return repository.findAll().stream()
                .map(Flower::toDTO)
                .toList();
    }

    @Override
    public FlowerUpdateResponse update(FlowerUpdateRequest updateFlower) {
        Flower originalFlower = repository.findById(updateFlower.originalId()).orElse(null);
        FlowerResponse response;
        boolean nameUpdated = false;
        String originalName = "";
        boolean countryUpdated = false;
        String originalCountry = "";


        if(originalFlower == null){
            response = FlowerResponse.builder()
                    .flower(null)
                    .error(new FlowerException("Flower Service, update method, findById operation.",
                            "Unable to find flower with id " + updateFlower.originalId()))
                    .build();

            return FlowerUpdateResponse.builder()
                    .nameUpdated(nameUpdated)
                    .oldName(originalName)
                    .countryUpdated(countryUpdated)
                    .oldCountry(originalCountry)
                    .flowerResponse(response)
                    .build();
        }

        if(!originalFlower.getName().equals(updateFlower.requestName())){
            nameUpdated = true;
            originalName = originalFlower.getName();
            originalFlower.setName(updateFlower.requestName());
        }
        if ((originalFlower.getCountry().equals(updateFlower.requestCountry()))){
            countryUpdated = true;
            originalCountry = originalFlower.getCountry();
            originalFlower.setCountry(updateFlower.requestCountry());
        }

        FlowerDTO flowerToReturn = repository.save(originalFlower).toDTO();

        response = FlowerResponse.builder()
                .flower(flowerToReturn)
                .error(null)
                .build();

        return FlowerUpdateResponse.builder()
                .nameUpdated(nameUpdated)
                .oldName(originalName)
                .countryUpdated(countryUpdated)
                .oldCountry(originalCountry)
                .flowerResponse(response)
                .build();

    }

    @Override
    public boolean delete(int id) {
        Optional<Flower> optional = repository.findById(id);
        if(optional.isPresent()){
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

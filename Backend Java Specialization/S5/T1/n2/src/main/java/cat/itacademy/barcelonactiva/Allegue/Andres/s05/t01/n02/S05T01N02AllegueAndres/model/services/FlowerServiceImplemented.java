package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.exceptions.implementations.FlowerServerAddException;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.exceptions.implementations.FlowerServerGetAllException;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.exceptions.implementations.FlowerServerGetOneException;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.exceptions.implementations.FlowerServerUpdateException;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.domain.Flower;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.requests.FlowerCreateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.requests.FlowerUpdateRequest;
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
        try{
            return repository
                    .save(request.toFlower())
                    .toDTO();
        } catch (Exception e){
            throw new FlowerServerAddException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public FlowerDTO getOne(int id) throws FlowerServerGetOneException {
        try{
            Optional<Flower> optional = repository.findById(id);
            return optional.map(Flower::toDTO).orElse(null);
        } catch (Exception e) {
            throw new FlowerServerGetOneException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<FlowerDTO> getAll() {
        try{
            return repository.findAll().stream()
                    .map(Flower::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new FlowerServerGetAllException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public FlowerUpdateResponse update(FlowerUpdateRequest request) {
        try {
            Optional<Flower> flower = repository.findById(request.originalId());
            if (flower.isEmpty()){
                throw new FlowerServerUpdateException("Unable to recover the flower you've requested to update");
            }

            return updateFlower(flower.get(), request);
        } catch (Exception e) {
            throw new FlowerServerUpdateException(e.getMessage(), e.getCause());
        }
    }

    private FlowerUpdateResponse updateFlower(Flower flower, FlowerUpdateRequest request){
        boolean isUpdated = false;
        StringBuilder message = new StringBuilder("Changes:\n");

        if(!flower.getName().equals(request.requestName())){
            isUpdated = true;
            message.append(flower.updateName(request.requestName()));
        }
        if (!flower.getCountry().equals(request.requestCountry())){
            isUpdated = true;
            message.append(flower.updateCountry(request.requestCountry()));
        }
        if(isUpdated){
            repository.save(flower).toDTO();
        }

        return FlowerUpdateResponse.builder()
                .flower(flower.toDTO())
                .message(message.toString())
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
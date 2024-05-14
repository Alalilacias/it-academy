package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.domain.FlowerCreateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.domain.FlowerUpdateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.dto.Flower;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.dto.FlowerUpdateResponse;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.services.interfaces.FlowerWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class FlowerWebServiceImplemented implements FlowerWebService {
    @Autowired
    private WebClient client;

    @Override
    public Flower add(FlowerCreateRequest request) {
        return client.post()
                .uri("/flower/add")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Flower.class)
                .block();
    }

    @Override
    public Flower getOne(int id) {
        return client.get()
                .uri("/flower/getOne/{id}", id)
                .retrieve()
                .bodyToMono(Flower.class)
                .block();
    }

    @Override
    public List<Flower> getAll() {
        return client.get()
                .uri("/flower/getAll")
                .retrieve()
                .bodyToFlux(Flower.class)
                .collectList()
                .block();
    }

    @Override
    public FlowerUpdateResponse update(FlowerUpdateRequest request) {
        return client.put()
                .uri("/flower/update")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(FlowerUpdateResponse.class)
                .block();
    }

    @Override
    public boolean delete(int id) {
        return Boolean.TRUE.equals(client.delete()
                .uri("/flower/delete/{id}", id)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());
    }
}

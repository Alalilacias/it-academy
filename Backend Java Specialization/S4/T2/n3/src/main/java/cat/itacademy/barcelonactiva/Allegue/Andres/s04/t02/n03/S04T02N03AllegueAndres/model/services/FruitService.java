package cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n03.S04T02N03AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n03.S04T02N03AllegueAndres.model.domain.Fruit;

import java.util.List;

public interface FruitService {
    Fruit add(Fruit fruit);
    Fruit getOne(String id);
    List<Fruit> getAll();
    Fruit update(Fruit fruit);
    Boolean delete(String id);
}

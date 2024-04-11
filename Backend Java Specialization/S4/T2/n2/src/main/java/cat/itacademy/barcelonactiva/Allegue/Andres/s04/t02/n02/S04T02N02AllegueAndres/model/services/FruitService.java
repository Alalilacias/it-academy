package cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n02.S04T02N02AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n02.S04T02N02AllegueAndres.model.domain.Fruit;

import java.util.List;

public interface FruitService {
    Fruit add(Fruit fruit);
    Fruit getOne(long id);
    List<Fruit> getAll();
    Fruit update(Fruit fruit);
    Boolean delete(long id);
}

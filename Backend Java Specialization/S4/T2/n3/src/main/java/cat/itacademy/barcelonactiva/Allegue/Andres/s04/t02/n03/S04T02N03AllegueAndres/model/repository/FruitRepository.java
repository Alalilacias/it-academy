package cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n03.S04T02N03AllegueAndres.model.repository;

import cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n03.S04T02N03AllegueAndres.model.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitRepository extends MongoRepository<Fruit, String> {}

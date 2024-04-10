package cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n01.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {}

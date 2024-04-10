package cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n01.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n01.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Fruit add(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit getOne(long id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("No fruit found with id: " + id));
    }

    @Override
    public List<Fruit> getAll() {
        return fruitRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Fruit update(Fruit updatedFruit) {
        Fruit inDatabaseFruit = getOne(updatedFruit.getId());

        if(!inDatabaseFruit.getName().equals(updatedFruit.getName())){
            inDatabaseFruit.setName(updatedFruit.getName());
        }
        if(!(inDatabaseFruit.getQuantityKilos() == updatedFruit.getQuantityKilos())){
            inDatabaseFruit.setQuantityKilos(updatedFruit.getQuantityKilos());
        }

        return fruitRepository.save(inDatabaseFruit);
    }

    @Override
    public Boolean delete(long id) {
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        if(optionalFruit.isPresent()){
            fruitRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

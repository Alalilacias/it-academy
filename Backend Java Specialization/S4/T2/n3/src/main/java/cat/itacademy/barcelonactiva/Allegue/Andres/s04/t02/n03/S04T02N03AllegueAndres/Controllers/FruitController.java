package cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n03.S04T02N03AllegueAndres.Controllers;

import cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n03.S04T02N03AllegueAndres.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n03.S04T02N03AllegueAndres.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @PostMapping("/add")
    public ResponseEntity<String> addFruit(@RequestBody Fruit fruit) {
        try {
            Fruit savedFruit = fruitService.add(fruit);
            String responseMessage = "Fruit created: " + savedFruit.getName() + ", Quantity: " + savedFruit.getQuantityKilos();
            return ResponseEntity.ok().body(responseMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating fruit: " + e.getMessage());
        }
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOneFruit(@PathVariable String id) {
        Fruit fruit = fruitService.getOne(id);
        return ResponseEntity.ok().body(fruit);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = fruitService.getAll();
        return ResponseEntity.ok().body(fruits);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitService.update(fruit);
        return ResponseEntity.ok().body(updatedFruit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable String id) {
        Boolean isDeleted = fruitService.delete(id);
        if (isDeleted) {
            return ResponseEntity.ok().body("Fruit with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit with ID " + id + " not found");
        }
    }
}

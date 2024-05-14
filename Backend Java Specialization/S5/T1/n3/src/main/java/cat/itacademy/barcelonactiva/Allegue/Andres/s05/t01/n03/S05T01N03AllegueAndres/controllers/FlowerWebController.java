package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.controllers;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.domain.FlowerCreateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.domain.FlowerUpdateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.dto.Flower;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.dto.FlowerUpdateResponse;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.dto.WebResponse;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.services.interfaces.FlowerWebService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerWebController {
    @Autowired
    private FlowerWebService service;

    @Operation(summary = "Add flower POST request.")
    @PostMapping("/addClient")
    public ResponseEntity<WebResponse> add(@RequestBody FlowerCreateRequest request){
        Flower flower = service.add(request);

        String message = "Flower created.";

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/flower/getOne/{id}")
                .buildAndExpand(flower.id())
                .toUri();

        WebResponse response = WebResponse.builder()
                .flowers(Collections.singletonList(flower))
                .message(message)
                .build();

        return ResponseEntity
                .created(location)
                .body(response);
    }

    @Operation(summary = "Get one flower GET request.")
    @GetMapping("/getOneClient/{id}")
    public ResponseEntity<WebResponse> getOne(@PathVariable int id){
        Flower flower = service.getOne(id);

        if(flower == null){
            return ResponseEntity.notFound().build();
        }

        WebResponse response = WebResponse.builder()
                .flowers(Collections.singletonList(flower))
                .message("Flower with ID: " + id + " found.")
                .build();

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get all flowerS GET request.")
    @GetMapping("/getAllClient")
    public ResponseEntity<WebResponse> getAll(){
        List<Flower> flowers = service.getAll();
        String message = flowers.isEmpty() ? "List is empty :(" : "";
        WebResponse response = WebResponse.builder()
                .flowers(flowers)
                .message(message)
                .build();

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update one flower PUT request")
    @PutMapping("/updateClient")
    public ResponseEntity<WebResponse> update(@RequestBody FlowerUpdateRequest request){
        FlowerUpdateResponse serviceResponse = service.update(request);
        WebResponse response = WebResponse.builder()
                .flowers(Collections.singletonList(serviceResponse.flower()))
                .message(serviceResponse.message())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete one flower DELETE request")
    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        if (service.delete(id)){
            return ResponseEntity.ok("Flower ID: " + id + " deleted.");
        } else {
            return ResponseEntity.badRequest().body("Unable to delete flower ID: " + id);
        }

    }

}

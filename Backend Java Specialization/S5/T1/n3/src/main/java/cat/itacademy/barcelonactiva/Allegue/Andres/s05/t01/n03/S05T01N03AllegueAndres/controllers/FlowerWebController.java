package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.controllers;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.domain.FlowerCreateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.domain.FlowerUpdateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.dto.WebResponse;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.services.interfaces.FlowerWebService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flower")
public class FlowerWebController {
    @Autowired
    private FlowerWebService service;

    @Operation(summary = "Add flower POST request.")
    @PostMapping("/addClient")
    public ResponseEntity<WebResponse> add(@RequestBody FlowerCreateRequest request){
        return null;
    }

    @Operation(summary = "Get one flower GET request.")
    @GetMapping("/getOneClient/{id}")
    public ResponseEntity<WebResponse> getOne(@PathVariable int id){
        return null;
    }

    @Operation(summary = "Get all flowerS GET request.")
    @GetMapping("/getAllClient")
    public ResponseEntity<WebResponse> getAll(){
        return null;
    }

    @Operation(summary = "Update one flower PUT request")
    @PutMapping("/updateClient/{id}")
    public ResponseEntity<WebResponse> update(@RequestBody FlowerUpdateRequest request){
        return null;
    }

    @Operation(summary = "Delete one flower DELETE request")
    @PutMapping("/deleteClient/{id}")
    public ResponseEntity<WebResponse> delete(@PathVariable int id){
        return null;
    }

}

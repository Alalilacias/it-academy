package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.controllers;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.domain.Flower;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.requests.FlowerCreateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.requests.FlowerUpdateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.responses.FlowerUpdateResponse;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.services.interfaces.FlowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @Operation(summary = "Create a Flower Controller.")
    @PostMapping("/add")
    public FlowerDTO createFlower(@RequestBody FlowerCreateRequest request) {
        return flowerService.add(request);
    }

    @Operation(summary = "Retrieve a single flower by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the flower", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Flower.class))
            }),
            @ApiResponse(responseCode = "404", description = "Flower not found")
    })
    @GetMapping("/getOne/{id}")
    public FlowerDTO getOne(@Parameter(description = "Id of the flower to be obtained. Cannot be empty.", required = true)
                                   @PathVariable int id) {
        return flowerService.getOne(id);
    }

    @Operation(summary = "Retrieve all flowers")
    @GetMapping("/getAll")
    public List<FlowerDTO> getAllFlowers() {
        return flowerService.getAll();
    }

    @Operation(summary = "Update an existing flower")
    @PutMapping("/update")
    public ResponseEntity<FlowerUpdateResponse> updateFlower(@RequestBody FlowerUpdateRequest flower) {
        FlowerUpdateResponse serviceUpdateResponse = flowerService.update(flower);
        return ResponseEntity.ok(serviceUpdateResponse);
    }

    @Operation(summary = "Delete a flower")
    @DeleteMapping("/delete/{id}")
    public boolean deleteFlower(@PathVariable int id) {
        return flowerService.delete(id);
    }

}
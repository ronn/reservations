package com.ronn.reservations.resource;

import com.ronn.reservations.domain.model.Client;
import com.ronn.reservations.domain.service.ClientService;
import com.ronn.reservations.util.ModelMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@Api(tags = "client")
public class ClientResource {

    private final ClientService clientService;

    private final ModelMapper mapper;

    public ClientResource(ClientService clientService, ModelMapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @GetMapping
    @ApiOperation(value = "Find all existing clients")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Clients gotten"),
            @ApiResponse(code = 404, message = "Couldn't find any client")
    })
    public ResponseEntity<List<Client>> getAll(){
        return ResponseEntity.ok(clientService.getAll());
    }

    @PostMapping
    @ApiOperation(value = "Create a new client", notes = "Service to create new client by calling here")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),
            @ApiResponse(code = 400, message = "No a valid client")
    })
    public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVO){
        Client c = mapper.map(clientVO, Client.class);

        return new ResponseEntity<>(clientService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/{dni}")
    @ApiOperation(value = "Update an esisting client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client updated"),
            @ApiResponse(code = 404, message = "No a valid client")
    })
    public ResponseEntity<Client> updateClient(@RequestBody ClientVO clientVO, @PathVariable("dni") String dni){
        return clientService.findByDni(dni)
                .map(client -> new ResponseEntity<>(
                        clientService.save(mapper.map(clientVO, Client.class)),
                        HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{dni}")
    @ApiOperation(value = "Delete an existing client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client deleted"),
            @ApiResponse(code = 404, message = "Client doesn't exist")
    })
    public void delete(@PathVariable("dni") String dni){
        clientService.delete(dni);
    }
}
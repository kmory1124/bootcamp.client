package com.bootcamp.client.controller;

import com.bootcamp.client.entity.ClientEntity;
import com.bootcamp.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/Client")
public class ClientController {
    @Autowired
    ClientService clientService;

    //List all client of bank
    @GetMapping(value = "/ListAll")
    public Flux<ClientEntity> ListAll(){
        return clientService.getAll();
    }

    //List all the client by documentNumber
    @GetMapping(value = "/ListByDocument/{documentNumber}")
    public Mono<ClientEntity> ListByDocument(@PathVariable("documentNumber") String documentNumber){
        return clientService.filterByDocument(documentNumber);
    }

    //Insert new client
    @PostMapping(value = "/RegisterClient")
    public Mono<ClientEntity> registerClient(@RequestBody ClientEntity cli){
        return clientService.registerClient(cli);
    }

    @PostMapping(value = "/register")
    public Mono<ClientEntity> Save(@RequestBody ClientEntity cli){
        return clientService.register(cli);
    }
    @PutMapping(value = "/UpdateClient/{documentNumber}/{name}")
    public Mono<ClientEntity> updateClient(@PathVariable("documentNumber") String documentNumber, @PathVariable("name") String name){
        return clientService.updateClient(documentNumber,name);
    }

}

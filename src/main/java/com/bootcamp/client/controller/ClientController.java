package com.bootcamp.client.controller;

import com.bootcamp.client.entity.ClientEntity;
import com.bootcamp.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//anotacion para indicar que esta clase será el controlador
@RestController
//anotacion para indicar la url de acceso será localhost:puerto/Client/
@RequestMapping(value="/Client")
public class ClientController {

    //anotacion para enlazar con la clase clientservice
    @Autowired
    ClientService clientService;

    //se expone el controlador tipo get para acceder al servicio que lista todos los usuarios
    @GetMapping(value = "/ListAll")
    public Flux<ClientEntity> ListAll(){
        return clientService.getAll();
    }

    //se expone el controlador tipo get para acceder al servicio que lista los usuarios filtrados por dni
    @GetMapping(value = "/ListByDocument/{documentNumber}")
    public Mono<ClientEntity> ListByDocument(@PathVariable("documentNumber") String documentNumber){
        return clientService.filterByDocument(documentNumber);
    }

    //se expone el controlador tipo post para registrar clientes validando antes la existencia de estos
    @PostMapping(value = "/RegisterClient")
    public Mono<ClientEntity> registerClient(@RequestBody ClientEntity cli){
        return clientService.registerClient(cli);
    }

    //se expone el controlador tipo post para registrar clientes sin validar existencia
    @PostMapping(value = "/register")
    public Mono<ClientEntity> Save(@RequestBody ClientEntity cli){
        return clientService.register(cli);
    }

    //se expone el controlador tipo put para actualizar los valores del nombre del usuario.
    @PutMapping(value = "/UpdateClient/{documentNumber}/{name}")
    public Mono<ClientEntity> updateClient(@PathVariable("documentNumber") String documentNumber, @PathVariable("name") String name){
        return clientService.updateClient(documentNumber,name);
    }

}

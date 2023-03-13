package com.bootcamp.client.service;

import com.bootcamp.client.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.bootcamp.client.repository.ClientRepository;


import java.util.Date;

@Service
public class ClientServiceImplementation implements ClientService {

    //anotacion de spring para enlazar con la clase repository
    @Autowired
    private ClientRepository clientRepository;

    //implementacion para listar todos los clientes
     public Flux<ClientEntity> getAll() {
        return clientRepository.findAll();
    }

    //implementacion para buscar clientes por dni, (de uso interno)
        public Mono<ClientEntity>getByDocument(String documentNumber){
         return clientRepository.findAll().filter(x -> x.getDocumentNumber()!=null && x.getDocumentNumber().equals(documentNumber)).next();
    }

    //implementacion para buscar clientes por dni, inicialmente se intentaba poner un mensaje personalizado cuando no encontraba clientes.
    //por falta de tiempo se retiro y queda pendiente para implementarlo posteriormente, por el momento queda igual que la implementacion anterior.
    @Override
    public Mono<ClientEntity> filterByDocument(String documentNumber) {
        return clientRepository.findAll().filter(x -> x.getDocumentNumber() != null && x.getDocumentNumber().equals(documentNumber)).next();

    }

    //implementacion para registrar clientes sin validar su existencia, puede ser por si el Front lo requiera o para reutilizarlo.
    @Override
    public Mono<ClientEntity> register(ClientEntity EntCli) {
        EntCli.setCreateDate(new Date());
        return clientRepository.save(EntCli);
    }

    //implementacion para registrar cliente validando la existencia de su dni, se expone en el controller.
    @Override
    public Mono<ClientEntity> registerClient(ClientEntity EntCli) {
        EntCli.setCreateDate(new Date());
        return getByDocument(EntCli.getDocumentNumber())
                .switchIfEmpty(clientRepository.save(EntCli));
    }
    //implementacion para actualizar el dato del nombre del cliente.
    @Override
    public Mono<ClientEntity> updateClient(String documentNumber, String name) {
        return getByDocument(documentNumber).flatMap(c -> {
            c.setName(name);
            c.setModifyDate(new Date());
            return clientRepository.save(c);
        });
    }
}

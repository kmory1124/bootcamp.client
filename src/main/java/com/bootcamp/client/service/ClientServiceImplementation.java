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
    @Autowired
    private ClientRepository clientRepository;

    //export in controller
     public Flux<ClientEntity> getAll() {
        return clientRepository.findAll();
    }

        public Mono<ClientEntity>getByDocument(String documentNumber){
         return clientRepository.findAll().filter(x -> x.getDocumentNumber()!=null && x.getDocumentNumber().equals(documentNumber)).next();
    }

    //export in controller
    @Override
    public Mono<ClientEntity> filterByDocument(String documentNumber) {
        return clientRepository.findAll().filter(x -> x.getDocumentNumber() != null && x.getDocumentNumber().equals(documentNumber)).next();

    }

    //Register client with no validate
    @Override
    public Mono<ClientEntity> register(ClientEntity EntCli) {
        EntCli.setCreateDate(new Date());
        return clientRepository.save(EntCli);
    }

    //Register client with validate
    @Override
    public Mono<ClientEntity> registerClient(ClientEntity EntCli) {
        EntCli.setCreateDate(new Date());
        return getByDocument(EntCli.getDocumentNumber())
                .switchIfEmpty(clientRepository.save(EntCli));
    }
    @Override
    public Mono<ClientEntity> updateClient(String documentNumber, String name) {
        return getByDocument(documentNumber).flatMap(c -> {
            c.setName(name);
            c.setModifyDate(new Date());
            return clientRepository.save(c);
        });
    }
}

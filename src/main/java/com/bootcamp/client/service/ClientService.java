package com.bootcamp.client.service;

import com.bootcamp.client.entity.ClientEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface ClientService {
    public Flux<ClientEntity> getAll();
    public Mono<ClientEntity> getByDocument(String documentNumber);
    public Mono<ClientEntity> filterByDocument(String documentNumber);
    public Mono<ClientEntity> register(ClientEntity EntCli);
    public Mono<ClientEntity> registerClient(ClientEntity EntCli);
    public Mono<ClientEntity> updateClient(String documentNumber, String Name);
}

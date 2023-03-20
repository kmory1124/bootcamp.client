package com.bootcamp.client.service;

import com.bootcamp.client.entity.ClientEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface ClientService {

    //se crea interfaz para listar todos los usuarios. (se expone en el controller)
    public Flux<ClientEntity> getAll();
    //se crea interfaz para buscar un usuario por dni, para uso interno. (no se expone en el controller)
    public Mono<ClientEntity> getByDocument(String documentNumber);
    //se crea interfaz para buscar un usuario por dni (se tenia la intencion para que cuando no encuentre un registro mostrar un mensaje personalizado,
    // se implementará posteriormente por el momento se deja igual que la interfaz anterior.) (se expone en el controller)
    public Mono<ClientEntity> filterByDocument(String documentNumber);
    //se crea interfaz para registrar usuarios, por si el front necesita agregar registros sin validar que existan (se expone en el controller)
    public Mono<ClientEntity> register(ClientEntity EntCli);
    //se crea interfaz para registrar usarios, validando que el dni no exista, por si el front requiere que el microservicio valide la existencia
    // del cliente antes de registrarlo (se expone en el controller)
    public Mono<ClientEntity> registerClient(ClientEntity EntCli);
    //se crea intefaz para actualizar la información deL tipo de persona del cliente (se expone en el controller)
    public Mono<ClientEntity> updateTypeClient(String documentNumber, String type);
    //Valida si el usuario existe y si es de tipo persona
    public Mono<Boolean> checkClientPersona(String documentNumber);
    //Valida si el usuario existe y si es de tipo persona
    public Mono<Boolean> checkClientCompany(String documentNumber);
}

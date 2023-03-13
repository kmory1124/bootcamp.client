package com.bootcamp.client.repository;
import com.bootcamp.client.entity.ClientEntity;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


//reference: https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/reactive/ReactiveCrudRepository.html
//al extender a la interfaz ReactiveCrudRepository se obtiene los metodos necesarios para poder operar con mongodb, de esta forma se ahorra el codigo.
public interface ClientRepository extends ReactiveCrudRepository<ClientEntity, ObjectId> {
}

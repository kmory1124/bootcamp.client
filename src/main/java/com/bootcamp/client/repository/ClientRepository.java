package com.bootcamp.client.repository;
import com.bootcamp.client.entity.ClientEntity;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

//reference: https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/reactive/ReactiveCrudRepository.html
public interface ClientRepository extends ReactiveCrudRepository<ClientEntity, ObjectId> {
}

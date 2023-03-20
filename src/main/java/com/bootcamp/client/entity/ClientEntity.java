package com.bootcamp.client.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

//anotacion que ahorra codigo para la obtencion y configuracion de los atributos de la clase.
@Data
//anotacion para ahorrar codigo de constructor con 1 parametro
@AllArgsConstructor
//anotacion para ahorrar codigo de constructor sin parametros
@NoArgsConstructor
//anotacion que indica que se utilizará para mapear a la collection "Client" de la bd mongo
@Document(collection = "Client")
public class ClientEntity {
    @Id
    private String id;
    private  String documentNumber;
    private  String documentType;
    private  String clientType; // P-> Personal | C-> Company
    private  String profile; // PYME / VYP
    private  String name;
    private  String lastname;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date createDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private  Date modifyDate;
}

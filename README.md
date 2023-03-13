# bootcamp.client
microservices Client

Microservicio para: consultar la informacion de clientes
permite realizar un CRUD de estos.

link para postman:
http://localhost:8085/Client/ListAll
http://localhost:8085/Client/ListByDocument/47304033
http://localhost:8085/Client/UpdateClient/47304033/Kennji E.
http://localhost:8085/Client/register
http://localhost:8085/Client/RegisterClient 

body para RegisterClient/register:
{
"documentNumber": "33312611",
"documentType":"DNI",
"clientType":"P",
"name":"PEPO2 PABLO",
"lastname":"FEDER CALDERON2",
"createDate":"11/03/2023",
"modifyDate":"11/03/2023"
}

Porcentaje de Avance: 100% terminado
# bootcamp.client
microservices Client

Microservicio para: consultar la informacion de clientes
permite realizar un CRUD de estos.

link para postman: SE ADICIONARON NUEVOS ENDPOINT NECESARIOS PARA LA VALIDACION DEL FRONT CUANDO REQUIERA CREAR CUENTAS O CREDITOS.

http://localhost:8085/Client/ListAll (LISTA TODOS LOS CLIENTES)

http://localhost:8085/Client/ListByDocument/47304033 (LISTA CLIENTES POR DOCUMENTO IDENTIDAD)

http://localhost:8085/Client/UpdateClient/47304033/P (AHORA ACTUALIZA TIPO DE CLIENTE PERSONA O EMPRESA)

http://localhost:8085/Client/register (REGISTRAR CLIENTE SIN VALIDACION POR SI EL FRONT LO REQUIERE)

http://localhost:8085/Client/RegisterClient (REGISTRA CLIENTE VALIDANDO QUE NO EXISTA)

http://localhost:8085/Client/checkClientPersona/47304033 (VALIDA SI EL CLIENTE ES TIPO PERSONA-SE USA PARA QUE EL FRONT VALIDE QUE TIPOS DE CUENTA O CREDITO CREAR)

http://localhost:8085/Client/checkClientCompany/47304036 (VALIDA SI EL CLIENTE ES TIPO EMPRESA-SE USA PARA QUE EL FRONT VALIDE QUE TIPOS DE CUENTA O CREDITO CREAR)


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
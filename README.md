# Microservicio de Perfil de Riesgo

## Descripción

Este microservicio se encarga de evaluar y gestionar el perfil de riesgo de los clientes de Bancolombia.  Analiza la información financiera y crediticia de cada cliente para determinar su nivel de riesgo, lo cual es fundamental para la toma de decisiones en la concesión de productos financieros, como préstamos o tarjetas de crédito.

## Arquitectura

El microservicio de Perfil de Riesgo sigue la arquitectura limpia de Bancolombia, con los siguientes componentes:

### Domain

* **Entidades:** Define las entidades del dominio, como `PerfilRiesgo`, `Cliente` y `FuenteDatos`.
* **Reglas de negocio:** Implementa las reglas y algoritmos para calcular la puntuación y el nivel de riesgo de los clientes.

### Use Cases

* **Evaluar perfil de riesgo:** Orquesta el flujo para evaluar el perfil de riesgo de un cliente, incluyendo la obtención de datos del cliente, la consulta a fuentes externas (ej. buró de crédito) y la aplicación de las reglas de negocio.
* **Gestionar perfiles de riesgo:** Permite crear, actualizar y consultar los perfiles de riesgo de los clientes.

### Infrastructure

* **Driven Adapters:**
    * **Repositorio de Perfiles de Riesgo:** Persiste los perfiles de riesgo en una base de datos.
    * **API Client para Perfil de Cliente:** Obtiene la información del cliente desde el microservicio de Perfil de Cliente.
    * **Conector a fuentes externas:**  Se conecta a fuentes externas de datos, como el buró de crédito, para obtener información crediticia.
* **Entry Points:**
    * **Controlador REST:** Expone las APIs REST para que otros microservicios puedan solicitar la evaluación del perfil de riesgo de un cliente o consultar un perfil existente.

## Dependencias

* **Microservicio de Perfil de Cliente:** Para obtener la información del cliente.
* **Fuentes externas de datos:**  Para obtener información crediticia (ej. buró de crédito).
* **Base de datos:** Para persistir los perfiles de riesgo.

## Flujo de trabajo

1.  Un microservicio (ej. Simulador de Créditos) envía una solicitud al servicio de Perfil de Riesgo para evaluar el riesgo de un cliente.
2.  El controlador REST recibe la solicitud y la envía al Use Case "Evaluar perfil de riesgo".
3.  El Use Case obtiene la información del cliente desde el microservicio de Perfil de Cliente.
4.  El Use Case consulta a las fuentes externas de datos para obtener información crediticia del cliente.
5.  El Use Case aplica las reglas de negocio para calcular la puntuación y el nivel de riesgo del cliente.
6.  El Use Case crea un nuevo `PerfilRiesgo` con la información calculada.
7.  El Use Case guarda el `PerfilRiesgo` en la base de datos a través del Repositorio de Perfiles de Riesgo.
8.  El Use Case devuelve el `PerfilRiesgo` al controlador REST.
9.  El controlador REST envía la respuesta al microservicio solicitante.

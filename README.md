T1 Grupo 3 - Consumo de mensajes y cálculo de Fibonacci.

## Integrantes

- Ignacio Rodrigo Machuca Gutierrez
- Carquin Hoyos Carlos Alonso
- Angélica Egas Quispe
- Jhaser Alexander Campos Castañeda

## Función del proyecto

El consumidor recibe la lista de números enviada mediante RabbitMQ, convierte los valores recibidos y calcula la secuencia de Fibonacci correspondiente.

## Configuración RabbitMQ

- Queue: `Grupo3Queue`
- Exchange: `Grupo3Exchange`
- Routing key: `Grupo3Routing`

## Tecnologías utilizadas

- Java 25
- Spring Boot 4.1.1
- Spring Cloud 2025.1.3
- RabbitMQ
- Maven

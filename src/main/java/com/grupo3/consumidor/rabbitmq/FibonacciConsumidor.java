package com.grupo3.consumidor.rabbitmq;

import com.grupo3.consumidor.config.RabbitMQConfig;
import com.grupo3.consumidor.dto.FibonacciRequest;
import com.grupo3.consumidor.service.FibonacciService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class FibonacciConsumidor {

    private final FibonacciService fibonacciService;

    public FibonacciConsumidor(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumirNumeros(FibonacciRequest request) {
        System.out.println("Mensaje recibido desde RabbitMQ: " + request.numbers());

        List<Integer> posiciones = Stream.of(request.numbers().split("[;,]"))
                .map(String::trim)
                .filter(valor -> !valor.isBlank())
                .map(Integer::parseInt)
                .toList();

        esperar20Segundos();

        List<Long> resultados = fibonacciService.calculateSequence(posiciones);

        for (int i = 0; i < posiciones.size(); i++) {
            System.out.println("Fibonacci posicion " + posiciones.get(i) + " = " + resultados.get(i));
        }

        System.out.println("-----------------------------------------");
    }

    private void esperar20Segundos() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("La pausa de 20 segundos fue interrumpida", e);
        }
    }
}

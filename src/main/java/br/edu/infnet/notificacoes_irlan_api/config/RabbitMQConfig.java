package br.edu.infnet.notificacoes_irlan_api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_ALUGUEL = "notificacoes.biblioteca.aluguel";
    public static final String QUEUE_DEVOLUCAO = "notificacoes.biblioteca.devolucao";

    @Bean
    public Queue queueAluguel() {
        return new Queue(QUEUE_ALUGUEL, true);
    }

    @Bean
    public Queue queueDevolucao() {
        return new Queue(QUEUE_DEVOLUCAO, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}

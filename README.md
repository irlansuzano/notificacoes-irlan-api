# Notificações IRLAN API

Este microserviço é responsável pelo processamento e envio de notificações para o sistema de biblioteca. Ele consome eventos de mensagens via RabbitMQ, busca informações complementares de alunos e envia e-mails de notificação.

## Módulos e Utilizações

- **`client`**: Contém os clientes Feign para comunicação síncrona com outros microserviços.
    - `AlunoClient`: Utilizado para buscar dados cadastrais do aluno no `aluno-service`.
- **`config`**: Configurações da aplicação.
    - `RabbitMQConfig`: Define as filas (`notificacoes.biblioteca.aluguel` e `notificacoes.biblioteca.devolucao`) e o conversor de mensagens JSON.
- **`dto`**: Objetos de Transferência de Dados (DTOs).
    - `NotificacaoDTO`: Representa o evento recebido da fila.
    - `AlunoDTO`: Representa os dados do aluno recebidos do serviço externo.
- **`listener`**: Componentes que escutam filas de mensagens.
    - `NotificacaoListener`: Processa mensagens de aluguel e devolução, orquestrando a busca de dados e o envio de e-mail.
- **`service`**: Camada de serviços de negócio.
    - `EmailService`: Responsável pela integração com o servidor SMTP para o envio efetivo dos e-mails.

## Tecnologias Utilizadas
- Spring Boot
- Spring AMQP (RabbitMQ)
- Spring Cloud OpenFeign
- Spring Mail

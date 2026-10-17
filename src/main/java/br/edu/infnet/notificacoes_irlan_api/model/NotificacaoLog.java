package br.edu.infnet.notificacoes_irlan_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDateTime;

@RedisHash("NotificacaoLog")
public record NotificacaoLog(
        @Id
        String id,
        @Indexed
        Long alunoId,
        String alunoNome,
        String alunoEmail,
        String tipoEvento,
        String livroTitulo,
        String assunto,
        String corpo,
        LocalDateTime dataEnvio,
        boolean sucesso,
        String erro
) {
}

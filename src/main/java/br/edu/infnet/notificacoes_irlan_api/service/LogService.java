package br.edu.infnet.notificacoes_irlan_api.service;

import br.edu.infnet.notificacoes_irlan_api.dto.AlunoDTO;
import br.edu.infnet.notificacoes_irlan_api.dto.NotificacaoDTO;
import br.edu.infnet.notificacoes_irlan_api.model.NotificacaoLog;
import br.edu.infnet.notificacoes_irlan_api.repository.NotificacaoLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class LogService {

    @Autowired
    private NotificacaoLogRepository logRepository;

    public void registrarLog(NotificacaoDTO notificacao, AlunoDTO aluno, String assunto, String corpo, boolean sucesso, String erro) {
        NotificacaoLog log = new NotificacaoLog(
                UUID.randomUUID().toString(),
                aluno.id(),
                aluno.nome(),
                aluno.email(),
                notificacao.tipoEvento(),
                notificacao.livroTitulo(),
                assunto,
                corpo,
                LocalDateTime.now(),
                sucesso,
                erro
        );
        logRepository.save(log);
    }
}

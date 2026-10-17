package br.edu.infnet.notificacoes_irlan_api.repository;

import br.edu.infnet.notificacoes_irlan_api.model.NotificacaoLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoLogRepository extends CrudRepository<NotificacaoLog, String> {
    List<NotificacaoLog> findByAlunoId(Long alunoId);
}

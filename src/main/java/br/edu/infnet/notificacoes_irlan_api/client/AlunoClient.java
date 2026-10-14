package br.edu.infnet.notificacoes_irlan_api.client;

import br.edu.infnet.notificacoes_irlan_api.dto.AlunoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "aluno-service", url = "${aluno.service.url}")
public interface AlunoClient {

    @GetMapping("/alunos/{id}")
    AlunoDTO buscarPorId(@PathVariable("id") Long id);
}

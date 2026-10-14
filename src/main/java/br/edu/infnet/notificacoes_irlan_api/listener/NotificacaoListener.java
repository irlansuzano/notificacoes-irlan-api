package br.edu.infnet.notificacoes_irlan_api.listener;

import br.edu.infnet.notificacoes_irlan_api.client.AlunoClient;
import br.edu.infnet.notificacoes_irlan_api.dto.AlunoDTO;
import br.edu.infnet.notificacoes_irlan_api.dto.NotificacaoDTO;
import br.edu.infnet.notificacoes_irlan_api.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoListener {

    @Autowired
    private AlunoClient alunoClient;

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "notificacoes.biblioteca.aluguel")
    public void escutarAluguel(NotificacaoDTO notificacao) {
        processarNotificacao(notificacao);
    }

    @RabbitListener(queues = "notificacoes.biblioteca.devolucao")
    public void escutarDevolucao(NotificacaoDTO notificacao) {
        processarNotificacao(notificacao);
    }

    private void processarNotificacao(NotificacaoDTO notificacao) {
        AlunoDTO aluno = alunoClient.buscarPorId(notificacao.alunoId());

        String assunto = "Notificação de " + notificacao.tipoEvento() + ": " + notificacao.livroTitulo();
        String corpo;

        if ("ALUGUEL".equals(notificacao.tipoEvento())) {
            corpo = String.format("Olá %s! Seu aluguel do livro %s foi confirmado. Prazo para devolução: %s. Boa leitura!",
                    aluno.nome(), notificacao.livroTitulo(), notificacao.dataFim());
        } else if ("DEVOLUCAO".equals(notificacao.tipoEvento())) {
            corpo = String.format("Olá %s! Sua devolução do livro %s foi confirmada em %s. Obrigado!",
                    aluno.nome(), notificacao.livroTitulo(), notificacao.dataDevolucao());
        } else if ("RENOVACAO".equals(notificacao.tipoEvento())) {
            corpo = String.format("Olá %s! Sua renovação do livro %s foi confirmada. Novo prazo para devolução: %s. Boa leitura!",
                    aluno.nome(), notificacao.livroTitulo(), notificacao.dataFim());
        } else {
            corpo = String.format("Olá %s! O evento de %s para o livro %s foi processado com sucesso.",
                    aluno.nome(), notificacao.tipoEvento(), notificacao.livroTitulo());
        }

        emailService.enviarEmail(aluno.email(), assunto, corpo);
    }
}

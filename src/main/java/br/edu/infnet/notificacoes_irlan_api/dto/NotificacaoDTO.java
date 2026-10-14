package br.edu.infnet.notificacoes_irlan_api.dto;

import java.time.LocalDate;

public record NotificacaoDTO(
    Long alunoId,
    String livroTitulo,
    LocalDate dataInicio,
    LocalDate dataFim,
    LocalDate dataDevolucao,
    String tipoEvento // ALUGUEL, DEVOLUCAO, RENOVACAO
) {}

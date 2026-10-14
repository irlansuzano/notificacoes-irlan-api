package br.edu.infnet.notificacoes_irlan_api.dto;

public record AlunoDTO(
    Long id,
    String nome,
    String email,
    String matricula
) {}

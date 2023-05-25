package br.com.digix.api.domain.familia;

import br.com.digix.api.domain.pessoa.Pessoa;

public record DadosCadastroFamilia(double rendaTotal,
                                   int dependentes,
                                   Pessoa pessoa) {
}

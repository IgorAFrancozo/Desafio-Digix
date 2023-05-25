package br.com.digix.api.domain.familia;

import br.com.digix.api.domain.pessoa.Pessoa;

public record DadosAtualizacaoFamilia(Long id,
                                      double rendaTotal,
                                      int dependentes,
                                      Pessoa pessoa) {
}

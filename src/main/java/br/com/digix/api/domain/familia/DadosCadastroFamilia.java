package br.com.digix.api.domain.familia;

import br.com.digix.api.domain.pessoa.Pessoa;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFamilia(@NotNull
                                   double rendaTotal,
                                   int dependentes,
                                   Pessoa pessoa) {
}

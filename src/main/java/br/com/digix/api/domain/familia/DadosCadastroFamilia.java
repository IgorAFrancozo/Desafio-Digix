package br.com.digix.api.domain.familia;

import br.com.digix.api.domain.pessoa.Pessoa;
import lombok.Getter;

import java.util.List;
public record DadosCadastroFamilia(
        double rendaTotal,
        int dependentes,
        Pessoa pessoa
) {
}

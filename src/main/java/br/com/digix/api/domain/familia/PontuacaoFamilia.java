package br.com.digix.api.domain.familia;

import br.com.digix.api.domain.familia.Familia;
import lombok.Data;

@Data
public class PontuacaoFamilia {
    private Familia familia;
    private int pontuacao;

    public PontuacaoFamilia(Familia familia, int pontuacao) {
        this.familia = familia;
        this.pontuacao = pontuacao;
    }
}

package br.com.digix.api.service;

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

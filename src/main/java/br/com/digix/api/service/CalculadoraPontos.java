package br.com.digix.api.service;

import br.com.digix.api.domain.familia.Familia;

import java.util.HashMap;
import java.util.Map;

public class CalculadoraPontos {
    private static final Map<String, Integer> criteriosPontuacao = new HashMap<>();

    static {
        criteriosPontuacao.put(CriteriosPontuacao.RENDA_ATE_900, 5);
        criteriosPontuacao.put(CriteriosPontuacao.RENDA_901_ATE_1500, 3);
        criteriosPontuacao.put(CriteriosPontuacao.DEPENDENTES_3_OU_MAIS, 3);
        criteriosPontuacao.put(CriteriosPontuacao.DEPENDENTES_1_OU_2, 2);
    }

    public static PontuacaoFamilia calcularPontuacao(Familia familia) {
        int pontuacao = 0;

        if (familia.getRendaTotal() <= 900) {
            pontuacao += criteriosPontuacao.get(CriteriosPontuacao.RENDA_ATE_900);
        } else if (familia.getRendaTotal() <= 1500) {
            pontuacao += criteriosPontuacao.get(CriteriosPontuacao.RENDA_901_ATE_1500);
        }

        if (familia.getDependentes() >= 3) {
            pontuacao += criteriosPontuacao.get(CriteriosPontuacao.DEPENDENTES_3_OU_MAIS);
        } else if (familia.getDependentes() >= 1) {
            pontuacao += criteriosPontuacao.get(CriteriosPontuacao.DEPENDENTES_1_OU_2);
        }

        return new PontuacaoFamilia(familia, pontuacao);
    }
}

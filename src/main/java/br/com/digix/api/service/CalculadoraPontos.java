package br.com.digix.api.service;

import br.com.digix.api.domain.familia.Familia;
import br.com.digix.api.domain.familia.PontuacaoFamilia;

import java.util.HashMap;
import java.util.Map;

public class CalculadoraPontos {
    private static final Map<String, Integer> criteriosPontuacao = new HashMap<>();
    public static final int rendaParaCincoPontos = 900;
    public static final int rendaParaTresPontos = 901;


    static {
        criteriosPontuacao.put(CriteriosDePontuacao.RENDA_ATE_900, 5);
        criteriosPontuacao.put(CriteriosDePontuacao.RENDA_901_ATE_1500, 3);
        criteriosPontuacao.put(CriteriosDePontuacao.DEPENDENTES_3_OU_MAIS, 3);
        criteriosPontuacao.put(CriteriosDePontuacao.DEPENDENTES_1_OU_2, 2);
        criteriosPontuacao.put(CriteriosDePontuacao.SEM_DEPENDENTES, 0);
    }

    public static PontuacaoFamilia calcularPontuacao(Familia familia) {
        int pontuacaoPorRenda = 0;
        int pontuacaoPorDependentes = 0;

        if (familia.getRendaTotal() <= rendaParaCincoPontos) {
            pontuacaoPorRenda = criteriosPontuacao.get(CriteriosDePontuacao.RENDA_ATE_900);
        } else if (familia.getRendaTotal() >= rendaParaTresPontos) {
            pontuacaoPorRenda = criteriosPontuacao.get(CriteriosDePontuacao.RENDA_901_ATE_1500);
        }

        if (familia.getDependentes() >= 3) {
            pontuacaoPorDependentes = criteriosPontuacao.get(CriteriosDePontuacao.DEPENDENTES_3_OU_MAIS);
        } else if (familia.getDependentes() >= 1) {
            pontuacaoPorDependentes = criteriosPontuacao.get(CriteriosDePontuacao.DEPENDENTES_1_OU_2);
        }

        int pontuacaoTotal = pontuacaoPorRenda + pontuacaoPorDependentes;

        return new PontuacaoFamilia(familia, pontuacaoTotal);
    }

}

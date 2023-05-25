package br.com.digix.api.service;

import br.com.digix.api.domain.familia.Familia;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculadoraPontosTest {

    @Test
    public void deve_calcular_pontuacao_renda_ate_900() {
        Familia familia = new Familia(1, 800, 0, null);
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        assertThat(pontuacao.getPontuacao())
                .as("Pontuação para Renda até 900")
                .isEqualTo(5);
    }

    @Test
    public void deve_calcular_pontuacao_renda_de_901_ate_1500() {
        Familia familia = new Familia(2, 1200, 0, null);
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        assertThat(pontuacao.getPontuacao())
                .as("Pontuação para Renda até 1500")
                .isEqualTo(3);
    }

    @Test
    public void deve_calcular_pontuacao_dependente_de_3_ou_Mais() {
        Familia familia = new Familia(3, 2000, 4, null);
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        assertThat(pontuacao.getPontuacao())
                .as("Pontuação com 3 dependentes ou mais")
                .isEqualTo(3);;
    }

    @Test
    public void deve_calcular_pontuacao_com_um_ou_dois_dependentes() {
        int pontuacaoEsperada = 2;
        Familia familia = new Familia(4, 2000, 1, null);
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        assertThat(pontuacao.getPontuacao())
                .as("Pontuação com 1 dependentes ou 2")
                .isEqualTo(pontuacaoEsperada);;;
    }
}

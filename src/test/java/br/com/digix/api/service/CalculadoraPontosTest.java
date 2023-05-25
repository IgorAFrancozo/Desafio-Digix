package br.com.digix.api.service;

import br.com.digix.api.domain.familia.Familia;
import br.com.digix.api.domain.familia.PontuacaoFamilia;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculadoraPontosTest {

    @Test
    public void deve_calcular_pontuacao_com_renda_ate_900() {
        Familia familia = new Familia(1, 800, 0, null);
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        assertThat(pontuacao.getPontuacao())
                .as("Renda Ate 900")
                .isEqualTo(5);
    }
    @Test
    public void deve_calcular_pontuacao_com_renda_ate_900_e_um_ou_dois_dependentes() {
        int pontuacaoEsperada = 7;
        Familia familia = new Familia(1, 900, 1, null, true);
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        assertThat(pontuacao.getPontuacao()).isEqualTo(pontuacaoEsperada);
    }

    @Test
    public void deve_calcular_pontuacao_com_renda_900_e_tres_ou_mais_dependentes(){
        Familia familia = new Familia(1, 900, 3, null, true);
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        assertThat(pontuacao.getPontuacao())
                .as("Pontuação com renda até 900 e 1 ou 2 dependentes")
                .isEqualTo(8);;
    }
    @Test
    public void deve_calcular_pontuacao_renda_de_901_ate_1500() {
        Familia familiaTeste = new Familia(2, 1200.00, 0, null, true);
        PontuacaoFamilia pontos = CalculadoraPontos.calcularPontuacao(familiaTeste);

        assertThat(pontos.getPontuacao())
                .as("Renda de 901 Ate 1500")
                .isEqualTo(3);
    }@Test
    public void deve_calcular_pontuacao_renda_de_901_ate_1500_e_3_ou_Mais_dependente() {
        Familia familiaTeste = new Familia(2, 1200.00, 3, null, true);
        PontuacaoFamilia pontos = CalculadoraPontos.calcularPontuacao(familiaTeste);

        assertThat(pontos.getPontuacao())
                .as("Reda de 901 a 1500 e 3 ou mais dependentes")
                .isEqualTo(6);
    }

}

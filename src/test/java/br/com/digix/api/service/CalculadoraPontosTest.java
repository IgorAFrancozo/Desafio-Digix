package br.com.digix.api.service;

import br.com.digix.api.domain.familia.Familia;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CalculadoraPontosTest {

    @Test
    public void calcularPontuacao_RendaAte900_PontuacaoCorreta() {
        // Arrange
        Familia familia = new Familia();
        familia.setRendaTotal(900);

        // Act
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        // Assert
        assertThat(pontuacao.getPontuacao()).isEqualTo(5);
    }

    @Test
    public void calcular_Pontuacao_de_Renda_Entre_901_e_1500() {
        // Arrange
        Familia familia = new Familia();
        familia.setRendaTotal(1200);

        // Act
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        // Assert
        assertThat(pontuacao.getPontuacao()).isEqualTo(3);
    }

    @Test
    public void calcularPontuacao_Dependentes3OuMais_PontuacaoCorreta() {
        // Arrange
        Familia familia = new Familia();
        familia.setRendaTotal(2000);
        familia.setDependentes(4);

        // Act
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        // Assert
        assertThat(pontuacao.getPontuacao()).isEqualTo(3);
    }

    @Test
    public void calcularPontuacao_DependentesEntre1e2_PontuacaoCorreta() {
        // Arrange
        Familia familia = new Familia();
        familia.setRendaTotal(2000);
        familia.setDependentes(2);

        // Act
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        // Assert
        assertThat(pontuacao.getPontuacao()).isEqualTo(2);
    }
}
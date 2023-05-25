package br.com.digix.api.service;

import br.com.digix.api.domain.builders.FamiliaBuilder;
import br.com.digix.api.domain.familia.Familia;
import br.com.digix.api.domain.familia.PontuacaoFamilia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculadoraPontosTest {

    @Test
    @DisplayName("Deve calcular pontuação para família com renda até 900 sem dependentes")
    void deve_calcular_pontuacao_com_renda_ate_900_sem_dependentes() {
        // Arrange
        Familia familia = new FamiliaBuilder()
                .comId(1L)
                .comRendaTotal(800)
                .comQuantidadeDependentes(0)
                .isAtivo(true)
                .build();

        // Act
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        // Assert
        assertThat(pontuacao.getPontuacao()).as("Pontuação para renda até 900 sem dependentes").isEqualTo(5);
    }

    @Test
    @DisplayName("Deve calcular pontuação para família com renda até 900 e um ou dois dependentes")
    void deve_calcular_pontuacao_com_renda_ate_900_e_um_ou_dois_dependentes() {
        // Arrange
        Familia familia = new FamiliaBuilder()
                .comId(1L)
                .comRendaTotal(900)
                .comQuantidadeDependentes(1)
                .isAtivo(true)
                .build();

        // Act
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        // Assert
        assertThat(pontuacao.getPontuacao()).isEqualTo(7);
    }

    @Test
    @DisplayName("Deve calcular pontuação para família com renda até 900 e três ou mais dependentes")
    void deve_calcular_pontuacao_com_renda_ate_900_e_tres_ou_mais_dependentes() {
        // Arrange
        Familia familia = new FamiliaBuilder()
                .comId(1L)
                .comRendaTotal(900)
                .comQuantidadeDependentes(3)
                .isAtivo(true)
                .build();

        // Act
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        // Assert
        assertThat(pontuacao.getPontuacao()).isEqualTo(8);
    }

    @Test
    @DisplayName("Deve calcular pontuação para família com renda de 901 a 1500")
    void deve_calcular_pontuacao_renda_de_901_ate_1500() {
        // Arrange
        Familia familia = new FamiliaBuilder()
                .comId(2L)
                .comRendaTotal(1200.00)
                .comQuantidadeDependentes(0)
                .isAtivo(true)
                .build();

        // Act
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);
    }

    @Test
    @DisplayName("Deve calcular pontuação para família com renda de 901 a 1500 e um ou dois dependentes")
    void deve_calcular_pontuacao_renda_de_901_ate_1500_e_1_ou_2_dependentes() {
        // Arrange
        Familia familia = new FamiliaBuilder()
                .comId(3L)
                .comRendaTotal(1200.00)
                .comQuantidadeDependentes(2)
                .isAtivo(true)
                .build();

        // Act
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        // Assert
        assertThat(pontuacao.getPontuacao()).isEqualTo(5);
    }

    @Test
    @DisplayName("Deve calcular pontuação para família com renda de 901 a 1500 e três ou mais dependentes")
    void deve_calcular_pontuacao_renda_de_901_ate_1500_e_3_ou_mais_dependentes() {
        // Arrange
        Familia familia = new FamiliaBuilder()
                .comId(2L)
                .comRendaTotal(1200.00)
                .comQuantidadeDependentes(3)
                .isAtivo(true)
                .build();

        // Act
        PontuacaoFamilia pontuacao = CalculadoraPontos.calcularPontuacao(familia);

        // Assert
        assertThat(pontuacao.getPontuacao()).isEqualTo(6);
    }
}




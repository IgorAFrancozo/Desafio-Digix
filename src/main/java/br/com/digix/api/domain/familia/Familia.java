package br.com.digix.api.domain.familia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Familia {
    private double rendaTotal;
    private int dependentes;

    public void atualizarInformacoes(DadosAtualizacaoFamilia dados) {
        if (dados.rendaTotal() != 0) {
            this.rendaTotal = dados.rendaTotal();
        }
        if (dados.dependentes() != 0) {
            this.dependentes = dados.dependentes();
        }
    }
}

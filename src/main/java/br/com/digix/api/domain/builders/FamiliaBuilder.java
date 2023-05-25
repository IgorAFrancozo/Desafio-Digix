package br.com.digix.api.domain.builders;

import br.com.digix.api.domain.familia.Familia;

public class FamiliaBuilder {
    private Long id;
    private double rendaTotal;
    private int quantidadeDependentes;
    private boolean isAtivo;

    public FamiliaBuilder comId(Long id) {
        this.id = id;
        return this;
    }

    public FamiliaBuilder comRendaTotal(double rendaTotal) {
        this.rendaTotal = rendaTotal;
        return this;
    }

    public FamiliaBuilder comQuantidadeDependentes(int quantidadeDependentes) {
        this.quantidadeDependentes = quantidadeDependentes;
        return this;
    }

    public FamiliaBuilder isAtivo(boolean isAtivo) {
        this.isAtivo = isAtivo;
        return this;
    }

    public Familia build() {
        return new Familia(id, rendaTotal, quantidadeDependentes, null, isAtivo);
    }
}


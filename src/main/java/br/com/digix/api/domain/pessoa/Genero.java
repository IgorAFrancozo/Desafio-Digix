package br.com.digix.api.domain.pessoa;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro"),
    NAO_ESPECIFICADO("Não Especificado"),
    PERSONALIZADO("Personalizado");

    private final String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
package br.com.digix.api.domain.familia;

import br.com.digix.api.domain.pessoa.Pessoa;

public record DadosDetalhesFamilia(Long id,
                                   double rendaTotal,
                                   int dependentes,
                                   Pessoa pessoa) {
    public DadosDetalhesFamilia(Familia familia) {
        this(familia.getId(), familia.getRendaTotal(), familia.getDependentes(), familia.getPessoa());
    }
}
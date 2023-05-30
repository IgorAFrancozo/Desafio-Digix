package br.com.digix.api.domain.pessoa;

import br.com.digix.api.domain.endereco.Endereco;
import br.com.digix.api.domain.familia.Familia;

public record DadosDetalhesPessoa(Long id,
                                  String nome,
                                  int idade,
                                  Genero genero,
                                  String cpf,
                                  Endereco endereco,
                                  String telefone,
                                  String email,
                                  Familia familia) {
    public DadosDetalhesPessoa(Pessoa pessoa) {
        this(pessoa.getId(),
                pessoa.getNome(),
                pessoa.getIdade(),
                pessoa.getGenero(),
                pessoa.getCpf(),
                pessoa.getEndereco(),
                pessoa.getTelefone(),
                pessoa.getEmail(),
                pessoa.getFamilia());
    }
}

package br.com.digix.api.domain.pessoa;

import br.com.digix.api.domain.endereco.Endereco;
import br.com.digix.api.domain.familia.Familia;

public record DadosCadastroPessoa(String nome,
                                  int idade,
                                  Genero genero,
                                  String cpf,
                                  Endereco endereco,
                                  String telefone,
                                  String email,
                                  Familia familia) {
}

package br.com.digix.api.domain.pessoa;

import br.com.digix.api.domain.endereco.DadosEndereco;
import br.com.digix.api.domain.familia.DadosCadastroFamilia;
import br.com.digix.api.domain.familia.Familia;

public record DadosAtualizacaoPessoa(Long id,
                                     String nome,
                                     int idade,
                                     Genero genero,
                                     String cpf,
                                     DadosEndereco endereco,
                                     String telefone,
                                     String email,
                                     DadosCadastroFamilia familia) {
}

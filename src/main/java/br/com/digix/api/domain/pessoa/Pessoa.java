package br.com.digix.api.domain.pessoa;

import br.com.digix.api.domain.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    private String nome;
    private int idade;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private String telefone;
    private String email;

}

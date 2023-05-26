package br.com.digix.api.domain.pessoa;


import br.com.digix.api.domain.endereco.Endereco;
import br.com.digix.api.domain.familia.Familia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "pessoa")
@Table(name = "pessoas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int idade;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private String telefone;
    private String email;
    @OneToOne
    @JoinColumn(name = "familia_id")
    private Familia familia;
    private boolean ativo;

    public Pessoa(DadosCadastroPessoa dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.genero = dados.genero();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.familia = dados.familia();
    }

    public void atualizarInformacoes(DadosAtualizacaoPessoa dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.idade() != 0) {
            this.idade = dados.idade();
        }
        if (dados.genero() != null) {
            Genero genero = dados.genero();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}

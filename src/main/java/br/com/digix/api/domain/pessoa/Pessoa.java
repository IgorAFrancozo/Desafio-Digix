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

}

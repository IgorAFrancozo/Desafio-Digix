package br.com.digix.api.domain.familia;

import br.com.digix.api.domain.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "familia")
@Table(name = "familias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double rendaTotal;
    private int dependentes;
    @OneToOne(mappedBy = "familia")
    private Pessoa pessoa;

    public Familia(DadosCadastroFamilia dados) {
        this.rendaTotal = dados.rendaTotal();
        this.dependentes = dados.dependentes();
        this.pessoa = dados.pessoa();

        if (this.pessoa != null) {
            this.pessoa.setFamilia(this);
        }
    }

    public void atualizarInformacoes(DadosAtualizacaoFamilia dados) {
        if (dados.rendaTotal() != 0) {
            this.rendaTotal = dados.rendaTotal();
        }
        if (dados.dependentes() != 0) {
            this.dependentes = dados.dependentes();
        }
        Pessoa pessoa = dados.pessoa();
        if (pessoa != null) {
            this.pessoa = pessoa;
            pessoa.setFamilia(this);
        }
    }
}

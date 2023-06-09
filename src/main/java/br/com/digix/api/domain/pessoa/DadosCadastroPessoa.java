package br.com.digix.api.domain.pessoa;

import br.com.digix.api.domain.endereco.DadosEndereco;
import br.com.digix.api.domain.familia.Familia;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPessoa(@NotBlank
                                  String nome,
                                  @NotNull
                                  int idade,
                                  @NotNull
                                  Genero genero,
                                  @NotBlank
                                  @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
                                  String cpf,
                                  @NotNull @Valid
                                  DadosEndereco endereco,
                                  @NotBlank
                                  String telefone,
                                  @NotBlank
                                  @Email
                                  String email,
                                  Familia familia) {
}

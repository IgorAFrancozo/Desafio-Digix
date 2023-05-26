package br.com.digix.api.service;

import br.com.digix.api.domain.builders.FamiliaBuilder;
import br.com.digix.api.domain.familia.Familia;
import br.com.digix.api.domain.familia.FamiliaRepository;
import br.com.digix.api.domain.familia.PontuacaoFamilia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FamiliaServiceTest {
    private FamiliaRepository familiaRepository;
    private FamiliaService familiaService;

    @BeforeEach
    public void setup() {
        familiaRepository = mock(FamiliaRepository.class);
        familiaService = new FamiliaService(familiaRepository);
    }

    @Test
    public void testListarFamiliasPorPontuacao() {
        Familia familia1 = new FamiliaBuilder().comId(1L).comRendaTotal(800).comQuantidadeDependentes(3).isAtivo(true).build();
        Familia familia2 = new FamiliaBuilder().comId(2L).comRendaTotal(1500).comQuantidadeDependentes(0).isAtivo(true).build();
        List<Familia> familias = Arrays.asList(familia1, familia2);

        when(familiaRepository.findAll()).thenReturn(familias);
        List<PontuacaoFamilia> result = familiaService.listarFamiliasPorPontuacao();

        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        assertThat(result).extracting(PontuacaoFamilia::getPontuacao)
                .isSortedAccordingTo((a, b) -> b - a);
        assertThat(result).extracting(PontuacaoFamilia::getFamilia)
                .containsExactlyInAnyOrder(familia1, familia2);
    }
}

package br.com.digix.api.service;
import br.com.digix.api.domain.familia.Familia;
import br.com.digix.api.domain.familia.FamiliaRepository;
import br.com.digix.api.domain.familia.PontuacaoFamilia;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamiliaService {
    private final FamiliaRepository familiaRepository;

    public FamiliaService(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    public List<PontuacaoFamilia> listarFamiliasPorPontuacao() {
        List<Familia> familias = familiaRepository.findAll();
        return familias.stream()
                .map(this::calcularPontuacao)
                .sorted(Comparator.comparingInt(PontuacaoFamilia::getPontuacao).reversed())
                .collect(Collectors.toList());
    }

    private PontuacaoFamilia calcularPontuacao(Familia familia) {
        return CalculadoraPontos.calcularPontuacao(familia);
    }
}

package br.com.digix.api.controller;

import br.com.digix.api.domain.familia.*;
import br.com.digix.api.service.FamiliaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familias")
public class FamiliaController {
    private final FamiliaService familiaService;
    @Autowired
    private FamiliaRepository repository;

    public FamiliaController(FamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    @GetMapping("/pontuacao")
    public ResponseEntity<List<PontuacaoFamilia>> listarFamiliasPorPontuacao() {
        List<PontuacaoFamilia> pontuacoes = familiaService.listarFamiliasPorPontuacao();
        return ResponseEntity.ok(pontuacoes);
    }

    @GetMapping
    public Page<DadosListagemFamilia> listarFamilia(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemFamilia::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroFamilia dados) {
        repository.save(new Familia(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoFamilia dados) {
        var familia = repository.getReferenceById(dados.id());
        familia.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var familia = repository.getReferenceById(id);
        familia.excluir();
    }
}

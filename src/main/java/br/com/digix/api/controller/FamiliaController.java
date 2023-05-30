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
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("familias")
public class FamiliaController {
    private final FamiliaService familiaService;
    @Autowired
    private FamiliaRepository repository;

    public FamiliaController(FamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    @GetMapping
    public Page<DadosListagemFamilia> listarFamilia(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemFamilia::new);
    }

    @GetMapping("/pontuacao")
    public ResponseEntity<List<PontuacaoFamilia>> listarFamiliasPorPontuacao() {
        List<PontuacaoFamilia> pontuacoes = familiaService.listarFamiliasPorPontuacao();
        return ResponseEntity.ok(pontuacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhesFamilia> detalharFamilia(@PathVariable long id) {
        var familia = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesFamilia(familia));
    }

    @GetMapping("/inativos")
    public ResponseEntity<Page<DadosListagemFamilia>> listarInativos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var familiaInativa = repository.findAllByAtivoFalse(paginacao).map(DadosListagemFamilia::new);
        return ResponseEntity.ok(familiaInativa);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroFamilia dados, UriComponentsBuilder uriBuilder) {
        var familia = new Familia(dados);
        repository.save(familia);
        var uri = uriBuilder.path("/familias/{id}").buildAndExpand(familia.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhesFamilia(familia));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoFamilia dados) {
        var familia = repository.getReferenceById(dados.id());
        familia.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhesFamilia(familia));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable long id) {
        var familia = repository.getReferenceById(id);
        familia.excluir();
        return ResponseEntity.noContent().build();
    }
}

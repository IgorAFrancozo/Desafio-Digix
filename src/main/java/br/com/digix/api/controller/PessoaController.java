package br.com.digix.api.controller;

import br.com.digix.api.domain.familia.DadosDetalhesFamilia;
import br.com.digix.api.domain.familia.DadosListagemFamilia;
import br.com.digix.api.domain.pessoa.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemPessoa>> listarPessoa(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var pessoa = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPessoa::new);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhesPessoa> detalharPessoa(@PathVariable long id) {
        var pessoa = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesPessoa(pessoa));
    }

    @GetMapping("/inativos")
    public ResponseEntity<Page<DadosListagemPessoa>> listarInativos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var pessoaInativa = repository.findAllByAtivoFalse(paginacao).map(DadosListagemPessoa::new);
        return ResponseEntity.ok(pessoaInativa);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
        var pessoa = new Pessoa(dados);
        repository.save(pessoa);
        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhesPessoa(pessoa));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPessoa dados) {
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhesPessoa(pessoa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var pessoa = repository.getReferenceById(id);
        pessoa.excluir();
        return ResponseEntity.noContent().build();
    }
}

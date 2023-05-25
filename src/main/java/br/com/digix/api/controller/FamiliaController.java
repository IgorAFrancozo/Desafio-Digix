package br.com.digix.api.controller;

import br.com.digix.api.domain.familia.DadosCadastroFamilia;
import br.com.digix.api.domain.familia.Familia;
import br.com.digix.api.domain.familia.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("familias")
public class FamiliaController {
    @Autowired
    private FamiliaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroFamilia dados) {
        repository.save(new Familia(dados));
    }
}

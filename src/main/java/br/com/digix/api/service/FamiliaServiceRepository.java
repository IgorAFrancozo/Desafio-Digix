package br.com.digix.api.service;

import br.com.digix.api.domain.familia.Familia;
import br.com.digix.api.domain.pessoa.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaServiceRepository extends JpaRepository<Familia, Long> {
    Page<Familia> findAllByAtivoTrue(Pageable paginacao);
}

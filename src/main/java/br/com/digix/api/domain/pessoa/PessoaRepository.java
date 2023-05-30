package br.com.digix.api.domain.pessoa;

import br.com.digix.api.domain.familia.Familia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Page<Pessoa> findAllByAtivoTrue(Pageable paginacao);
    Page<Pessoa> findAllByAtivoFalse(Pageable paginacao);
}

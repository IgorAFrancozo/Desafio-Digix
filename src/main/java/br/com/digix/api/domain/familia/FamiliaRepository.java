package br.com.digix.api.domain.familia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaRepository extends JpaRepository<Familia, Long> {
    Page<Familia> findAllByAtivoTrue(Pageable paginacao);
}

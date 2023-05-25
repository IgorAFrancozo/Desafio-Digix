package br.com.digix.api.service;

import br.com.digix.api.domain.familia.Familia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaServiceRepository extends JpaRepository<Familia, Long> {
}

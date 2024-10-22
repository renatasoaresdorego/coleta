package br.com.fiap.coleta.repository;

import br.com.fiap.coleta.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {
}

package br.com.fiap.coleta.repository;

import br.com.fiap.coleta.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {
}

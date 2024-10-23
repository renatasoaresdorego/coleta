package br.com.fiap.coleta.repository;

import br.com.fiap.coleta.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {
    public Optional<Caminhao> findById(Long id);
}

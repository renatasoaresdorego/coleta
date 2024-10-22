package br.com.fiap.coleta.repository;

import br.com.fiap.coleta.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgendaRepository extends JpaRepository<Agenda, Long> { }

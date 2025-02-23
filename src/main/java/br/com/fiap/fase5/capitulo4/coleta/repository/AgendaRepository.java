package br.com.fiap.fase5.capitulo4.coleta.repository;

import br.com.fiap.fase5.capitulo4.coleta.model.Agenda;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AgendaRepository extends MongoRepository<Agenda, Long> { }

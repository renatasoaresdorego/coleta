package br.com.fiap.fase5.capitulo4.coleta.repository;

import br.com.fiap.fase5.capitulo4.coleta.model.PontoDeColeta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PontoDeColetaRepository extends MongoRepository<PontoDeColeta, Long> {
}

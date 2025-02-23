package br.com.fiap.fase5.capitulo4.coleta.repository;

import br.com.fiap.fase5.capitulo4.coleta.model.Rota;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RotaRepository extends MongoRepository<Rota, Long> {

    Rota findRotaByIdRota(Long id);
}

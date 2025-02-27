package br.com.fiap.fase5.capitulo4.coleta.repository;

import br.com.fiap.fase5.capitulo4.coleta.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Long> {

    UserDetails findByCpf(String cpf);
}

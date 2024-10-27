package br.com.fiap.coleta.repository;

import br.com.fiap.coleta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByCpf(String cpf);
}

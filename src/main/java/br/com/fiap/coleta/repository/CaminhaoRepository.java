package br.com.fiap.coleta.repository;

import br.com.fiap.coleta.dto.CaminhaoCadastroDto;
import br.com.fiap.coleta.model.Caminhao;
import br.com.fiap.coleta.model.Rota;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

}

package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.UsuarioCadastroDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.UsuarioExibicaoDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.UsuarioMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.Role;
import br.com.fiap.fase5.capitulo4.coleta.model.Usuario;
import br.com.fiap.fase5.capitulo4.coleta.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioExibicaoDto cadastrar(UsuarioCadastroDto dto) {
        try {
            Usuario usuario = UsuarioMapper.INSTANCE.usuarioCadastroDtoToUsuario(dto);
            usuario.setSenha(criptografarSenha(dto.senha()));
            usuario.setRole(atribuirRole(dto.role()));
            repository.save(usuario);
            log.info("Usuário cadastrado com sucesso.", usuario);
            return UsuarioMapper.INSTANCE.usuarioToUsuarioExibicaoDto(usuario);
        } catch(IllegalArgumentException e) {
            throw new RuntimeException("Este usuário já está cadastrado.");
        }
    }

    public void atualizar(UsuarioCadastroDto dto) {
        try {
            Usuario usuario = repository.findUsuarioByCpf(dto.cpf());
            usuario = UsuarioMapper.INSTANCE.usuarioCadastroDtoToUsuario(dto);
            repository.save(usuario);
            log.info("Usuário atualizado com sucesso.");
        } catch(DataIntegrityViolationException e) {
            throw new RuntimeException("Usuário não encontrado.");
        }
    }

    public String criptografarSenha(String senha) {
        return new BCryptPasswordEncoder().encode(senha);
    }

    public Role atribuirRole(Role role) {
        try {
            if(role == Role.ADMIN) {
                log.info("Atribuída a role de admin.");
                return Role.ADMIN;
            }
            else {
                log.info("Atribuída a role de user.");
                return Role.USER;
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Role inválida.");
        }
    }

}

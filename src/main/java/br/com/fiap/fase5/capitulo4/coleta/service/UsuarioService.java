package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.UsuarioCadastroDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.UsuarioExibicaoDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.UsuarioMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.Role;
import br.com.fiap.fase5.capitulo4.coleta.model.Usuario;
import br.com.fiap.fase5.capitulo4.coleta.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    public UsuarioExibicaoDto cadastrar(UsuarioCadastroDto dto) {
        Usuario usuario = mapper.usuarioCadastroDtoToUsuario(dto);
        usuario.setSenha(criptografarSenha(dto.senha()));
        usuario.setRole(Role.USER);
        return mapper.usuarioToUsuarioExibicaoDto(repository.save(usuario));
    }

    public String criptografarSenha(String senha) {
        return new BCryptPasswordEncoder().encode(senha);
    }

}

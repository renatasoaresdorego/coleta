package br.com.fiap.coleta.service;

import br.com.fiap.coleta.dto.UsuarioCadastroDto;
import br.com.fiap.coleta.dto.UsuarioExibicaoDto;
import br.com.fiap.coleta.exception.AlreadyInUseException;
import br.com.fiap.coleta.model.Usuario;
import br.com.fiap.coleta.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto cadastrarUsuario(UsuarioCadastroDto usuarioCadastroDto) {
        validarCpf(usuarioCadastroDto.cpf());
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        usuario.setSenha(criptografarSenha(usuarioCadastroDto.senha()));
        usuarioRepository.save(usuario);
        return new UsuarioExibicaoDto(usuario.getCpf());
    }

    public Boolean validarCpf(String cpf) {
        try {
            return usuarioRepository.findByCpf(cpf) == null;
        } catch(AlreadyInUseException ex) {
            System.err.println("O cpf possui morador associado. Tente recuperar a conta.");
            return false;
        }
    }

    public String criptografarSenha(String senha) {
        return new BCryptPasswordEncoder().encode(senha);
    }
}

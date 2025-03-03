package br.com.fiap.fase5.capitulo4.coleta.mapper;

import br.com.fiap.fase5.capitulo4.coleta.dto.UsuarioCadastroDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.UsuarioExibicaoDto;
import br.com.fiap.fase5.capitulo4.coleta.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario usuarioCadastroDtoToUsuario(UsuarioCadastroDto dto);
    UsuarioExibicaoDto usuarioToUsuarioExibicaoDto(Usuario usuario);
}

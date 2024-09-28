package usuarioPlantilla.domian;

import exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usuarioPlantilla.infrastructure.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioPlantilla> obtenerUsuarios() {
        List<UsuarioPlantilla> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new ResourceNotFoundException("No hay usuarios");
        }
        return usuarios;
    }

}

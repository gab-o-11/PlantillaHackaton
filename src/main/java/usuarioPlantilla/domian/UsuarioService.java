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

    public UsuarioPlantilla actualizarUsuario(Long id, UsuarioPlantilla usuarioActualizado) {
        UsuarioPlantilla usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el id: " + id));

        usuarioExistente.setNombre(usuarioActualizado.getNombre());
        usuarioExistente.setApellido(usuarioActualizado.getApellido());
        usuarioExistente.setEdad(usuarioActualizado.getEdad());
        usuarioExistente.setTelefono(usuarioActualizado.getTelefono());

        return usuarioRepository.save(usuarioExistente);
    }
    public UsuarioPlantilla actualizarUsuarioParcial(Long id, UsuarioPlantilla usuarioParcial) {
        UsuarioPlantilla usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el id: " + id));

        if (usuarioParcial.getNombre() != null) {
            usuarioExistente.setNombre(usuarioParcial.getNombre());
        }
        if (usuarioParcial.getApellido() != null) {
            usuarioExistente.setApellido(usuarioParcial.getApellido());
        }
        if (usuarioParcial.getTelefono()!= null) {
            usuarioExistente.setTelefono(usuarioParcial.getTelefono());
        }
        if (usuarioParcial.getEdad()!=0){
            usuarioExistente.setEdad(usuarioParcial.getEdad());
        }

        return usuarioRepository.save(usuarioExistente);
    }
}

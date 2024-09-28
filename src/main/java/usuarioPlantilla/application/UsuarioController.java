package usuarioPlantilla.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usuarioPlantilla.domian.UsuarioPlantilla;
import usuarioPlantilla.domian.UsuarioService;
import usuarioPlantilla.infrastructure.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioPlantilla>> getAllUsers() {
        List<UsuarioPlantilla> usuarios = usuarioService.obtenerUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioPlantilla> actualizacionIntegral(@PathVariable long id, @RequestBody UsuarioPlantilla usuario) {
        UsuarioPlantilla usuarioActualizado = usuarioService.actualizarUsuario(id, usuario);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioPlantilla> actualizarUsuarioParcial(
            @PathVariable Long id, @RequestBody UsuarioPlantilla usuarioParcial) {
        UsuarioPlantilla usuario = usuarioService.actualizarUsuarioParcial(id, usuarioParcial);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}

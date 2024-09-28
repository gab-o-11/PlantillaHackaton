package usuarioPlantilla.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usuarioPlantilla.domian.UsuarioPlantilla;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioPlantilla,Long> {
}

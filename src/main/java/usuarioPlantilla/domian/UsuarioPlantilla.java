package usuarioPlantilla.domian;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UsuarioPlantilla {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;
    String nombre;
    String apellido;
    int edad;
    String telefono;
}

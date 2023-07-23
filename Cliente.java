import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;

    @Column(name = "numero_identificacion", unique = true) // El número de identificación debe ser único
    private String numeroIdentificacion;

    private String nombres;
    private String correo;

    @Column(name = "numero_celular")
    private String numeroCelular;

    // Otros campos y relaciones con otras entidades, como la dirección matriz y direcciones adicionales, si se requieren

    // Constructor, getters, setters y otros métodos si es necesario
}

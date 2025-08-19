package topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Table(name="topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private String nombreDelCurso;
    private String titulo;



    public Topico(DatosRegistroTopico datos) {
        this.id= datos.id();
        this.mensaje = datos.mensaje();
        this.nombreDelCurso= datos.nombreDelCurso();
        this.titulo= datos.titulo();
    }
}

package topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotNull Long id,
        @NotBlank String mensaje,
        @NotBlank String nombreDelCurso,
        @NotBlank String titulo) {

}

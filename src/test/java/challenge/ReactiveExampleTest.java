package challenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ReactiveExampleTest {

    @InjectMocks
    ReactiveExample reactiveExample;


    @Test
    void sumaDePuntajes(){
        Mono<Integer> valor = reactiveExample.sumaDePuntajes();

        StepVerifier.create(valor)
                .expectNext(265)
                .verifyComplete();
    }

    @Test
    void mayorPuntajeDeEstudiante(){
        var estudiante = reactiveExample.mayorPuntajeDeEstudiante();

        StepVerifier.create(estudiante)
                .expectNextMatches(response ->
                        response.getPuntaje().equals(85) && response.getNombre().equals("pedro")
                ).verifyComplete();
    }

    @Test
    void totalDeAsistenciasDeEstudiantesComMayorPuntajeDe(){
        var totalAsistencias = reactiveExample.totalDeAsistenciasDeEstudiantesConMayorPuntajeDe(80);
        StepVerifier.create(totalAsistencias)
                .expectNext(24)
                .verifyComplete();
    }

    @Test
    void elEstudianteTieneAsistenciasCorrectas(){
        var estudiante = new Estudiante("juan", 50, List.of(4,3,2,2,5));
        var asistenciasCorrectas = reactiveExample.elEstudianteTieneAsistenciasCorrectas(estudiante);

        StepVerifier.create(asistenciasCorrectas)
                .expectNext(true)
                .verifyComplete();
    }

    @Test
    void promedioDePuntajesPorEstudiantes(){
        var promedioPuntajes = reactiveExample.promedioDePuntajesPorEstudiantes();

        StepVerifier.create(promedioPuntajes)
                .expectNext(53.0)
                .verifyComplete();
    }

    @Test
    void estudiantesAprovados(){
        var estudiantesAprovados = reactiveExample.estudiantesAprovados();
        StepVerifier.create(estudiantesAprovados)
                .expectNext("juan", "pedro")
                .verifyComplete();
    }
}
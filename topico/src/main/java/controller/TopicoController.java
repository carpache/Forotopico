package controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import topico.DatosRegistroTopico;
import topico.Topico;
import topico.TopicoRepository;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {


@Autowired
private TopicoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder){
        repository.save(new Topico(datos));
        var uri= UriComponentsBuilder.fromHttpUrl("/topicos/{id}").buildAndExpand();
        return ResponseEntity.created(uri).body(datos);
    }

    @GetMapping
    public ResponseEntity<Page<Topico>>listar(Pageable paguinacion){
       var page = repository.findAll(paguinacion);
        return ResponseEntity.ok(page);
    }
    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosRegistroTopico datos){

        return ResponseEntity.ok(datos);
        }

     @Transactional
     @DeleteMapping ("/{id}")
     public ResponseEntity eliminar (@PathVariable Long id){
     repository.deleteById(id);
     return ResponseEntity.noContent().build();
     }

    }


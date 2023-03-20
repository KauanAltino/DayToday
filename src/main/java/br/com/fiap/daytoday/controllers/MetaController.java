package br.com.fiap.daytoday.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.daytoday.models.Meta;
import java.util.ArrayList;
import java.util.List;

@RestController 
public class MetaController {

    Logger log = LoggerFactory.getLogger(MetaController.class);

    List<Meta> metas = new ArrayList<>();

    @GetMapping("/api/metas")
    public List<Meta> index(){
        return metas;
    }

    @PostMapping("/api/metas")
    public ResponseEntity<Meta> create(@RequestBody Meta meta){
        log.info("cadastrando as metas: " + meta);
        meta.setId(metas.size() + 1l);
        metas.add(meta);
        return ResponseEntity.status(HttpStatus.CREATED).body(meta);
    }
    
    @GetMapping("/api/metas/{id}")
    public ResponseEntity<Meta> show(@PathVariable Long id){
        log.info("procurando as metas pelo id " + id);
        var metaEncontrada = metas.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (metaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(metaEncontrada.get());
    }

    @DeleteMapping("/api/metas/{id}")
    public ResponseEntity<Meta> destroy(@PathVariable Long id){
        log.info("apagando a meta através do id " + id);
        var metaEncontrada = metas.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (metaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        metas.remove(metaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/api/metas/{id}")
    public ResponseEntity<Meta> update(@PathVariable Long id, @RequestBody Meta meta){
        log.info("alterando a meta com id " + id);
        var metaEncontrada = metas.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (metaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        metas.remove(metaEncontrada.get());
        meta.setId(id);
        metas.add(meta);

        return ResponseEntity.ok(meta);
    }
}

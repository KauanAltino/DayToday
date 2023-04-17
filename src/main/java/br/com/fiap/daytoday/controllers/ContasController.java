package br.com.fiap.daytoday.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.daytoday.exception.RestNotFoundException;
import br.com.fiap.daytoday.models.Conta;
import br.com.fiap.daytoday.models.Despesa;
import br.com.fiap.daytoday.models.RestError;
import br.com.fiap.daytoday.repository.ContasRepository;
import br.com.fiap.daytoday.repository.MetaRepository;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContasController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired // IoD IoC
    ContasRepository repository;

    @GetMapping
    public List<Contas> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Contas> create(@RequestBody @Valid Contas contas){
        log.info("Cadastrando: " + contas);
        repository.save(contas);
        return ResponseEntity.status(HttpStatus.CREATED).body(contas);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Contas> show(@PathVariable Long id){
        log.info("Procurando a conta por um id: " + id);
        return ResponseEntity.ok(getContas(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Contas> destroy(@PathVariable Long id){
        log.info("Retirando a conta com id " + id);
        repository.delete(getContas(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Contas> update(@PathVariable Long id, @RequestBody @Valid Contas contas){
        log.info("Fazendo a alteração da conta com o id " + id);
        getContas(id);
        contas.setId(id);
        repository.save(contas);
        return ResponseEntity.ok(contas);
    }

    private Contas getContas(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não foi encontrada"));
    }
    
}

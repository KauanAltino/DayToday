package br.com.fiap.daytoday.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.daytoday.models.Contas;
import br.com.fiap.daytoday.models.Meta;
import br.com.fiap.daytoday.repository.ContasRepository;
import br.com.fiap.daytoday.repository.MetaRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ContasRepository contasRepository;

    @Autowired
    MetaRepository MetaRepository;

    @Override
    public void run(String... args) throws Exception {
        Dia c1 = new Dia(1L, "Segunda", new Integer(5), "metas");
        Dia c2 = new Dia(2L, "Terça", new Integer(5), "metas");
        Dia c3 = new Dia(3L, "Quarta", new Integer(5), "metas");
        Dia c4 = new Dia(4L, "Quinta", new Integer(5), "metas");
        Dia c5 = new Dia(5L, "Sexta", new Integer(5), "metas");
        Dia c6 = new Dia(6L, "Sabado", new Integer(5), "metas");
        Dia c7 = new Dia(7L, "Domingo", new Integer(5), "metas");
        contasRepository.saveAll(List.of(c1,c2,c3,c4,c5,c6,c7));

        metaRepository.saveAll(List.of(
            Meta.builder().valor(new Integer(5)).descricao("Cinema").data(LocalDate.now()).conta(c1).build(),
            Meta.builder().valor(new Integer(5)).descricao("Corrida").data(LocalDate.now()).conta(c1).build(),
            Meta.builder().valor(new Integer(5)).descricao("Trabalho").data(LocalDate.now()).conta(c1).build(),
            Meta.builder().valor(new Integer(5)).descricao("Tarefas").data(LocalDate.now()).conta(c1).build(),
            Meta.builder().valor(new Integer(5)).descricao("Faculdade").data(LocalDate.now()).conta(c1).build(),
            Meta.builder().valor(new Integer(5)).descricao("Livre").data(LocalDate.now()).conta(c1).build(),
            Meta.builder().valor(new Integer(5)).descricao("Passear com Cachorro").data(LocalDate.now()).conta(c1).build(),
            Meta.builder().valor(new Integer(5)).descricao("Arrumar quarto").data(LocalDate.now()).conta(c1).build()
        ));

        
    }
    
}

package com.github.brunoabdon.daon.daoncore;


import com.github.brunoabdon.daon.daoncore.persistence.entities.Apresentador;
import com.github.brunoabdon.daon.daoncore.persistence.entities.Instituicao;
import com.github.brunoabdon.daon.daoncore.persistence.entities.Pessoa;
import com.github.brunoabdon.daon.daoncore.persistence.repos.ApresentadorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DaonApplicationRunner implements ApplicationRunner {

    @Autowired
    private ApresentadorRepository repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Pessoa annete = new Pessoa("Annete Carla");
        Pessoa igor = new Pessoa("Igor Coutinho");
        Pessoa paloma = new Pessoa("Paloma Sol");
        Instituicao ufpe = new Instituicao("UFPE");

        ufpe = salva(ufpe);
        annete = salva(annete);
        paloma = salva(paloma);
        igor = salva(igor);
        log.debug("Determinando que {} foi apresentado por {}.",paloma,ufpe);

        annete.setApresentador(igor);
        igor.setApresentador(paloma);
        paloma.setApresentador(ufpe);

        salva(igor);
        salva(annete);
        salva(paloma);

        log.debug("Deu tudo certo.");
    }

    private <A extends  Apresentador> A salva(final A apresentador) {
        log.debug("Salvando {}.", apresentador);

        final A apresentadorSalvo = repo.save(apresentador);
        log.debug("Salvo com sucesso o apresentador {}.",apresentadorSalvo);
        return apresentadorSalvo;
    }
}

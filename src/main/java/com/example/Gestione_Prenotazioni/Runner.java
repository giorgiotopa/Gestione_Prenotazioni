package com.example.Gestione_Prenotazioni;

import com.example.Gestione_Prenotazioni.entity.*;
import com.example.Gestione_Prenotazioni.service.EdificioService;
import com.example.Gestione_Prenotazioni.service.PostazioneService;
import com.example.Gestione_Prenotazioni.service.PrenotazioneService;
import com.example.Gestione_Prenotazioni.service.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneService prenotazioneService;

    private Logger logger = LoggerFactory.getLogger("Gestione_Prenotazioni");

    @Override
    public void run(String... args) throws Exception {

        Edificio edificio1 = new Edificio();
        edificio1.setNome("Isola C4");
        edificio1.setCitta("Napoli");
        edificio1.setIndirizzo("Centro Direzionale");

        edificioService.salvaEdificio(edificio1);

        Utente utente1 = new Utente();
        utente1.setNomeCompleto("Marco Mormile");
        utente1.setEmail("elenamormile@mail.com");

        utenteService.salvaUtente(utente1);

        Postazione postazione1 = new Postazione();
        postazione1.setTipo(TipoPostazione.PRIVATO);
        postazione1.setDescrizione("80mq, Idromassaggio e Sauna");
        postazione1.setNumeroMassimoOccupanti(10);
        postazione1.setEdificio(edificio1);



        Prenotazione prenotazione1 = new Prenotazione(postazione1, utente1);


        postazioneService.salvaPostazione(postazione1);
        prenotazioneService.salvaPrenotazione(prenotazione1);

        logger.info(utente1.toString());
    }
}

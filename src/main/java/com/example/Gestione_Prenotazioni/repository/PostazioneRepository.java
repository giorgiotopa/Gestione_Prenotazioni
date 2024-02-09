package com.example.Gestione_Prenotazioni.repository;

import com.example.Gestione_Prenotazioni.entity.Postazione;
import com.example.Gestione_Prenotazioni.entity.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
}

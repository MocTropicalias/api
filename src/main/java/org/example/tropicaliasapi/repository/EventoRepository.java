package org.example.tropicaliasapi.repository;

import jdk.jfr.Event;
import org.example.tropicaliasapi.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}

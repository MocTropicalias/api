package org.example.tropicaliasapi.repository;

import org.example.tropicaliasapi.model.VendaEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaEventoRepository extends JpaRepository<VendaEvento, Long> {
}

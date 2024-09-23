package org.example.tropicaliasapi.repository;

import org.example.tropicaliasapi.model.VendaAnuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaAnuncioRepository extends JpaRepository<VendaAnuncio, Long> {
}

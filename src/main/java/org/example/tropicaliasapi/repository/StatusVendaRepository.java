package org.example.tropicaliasapi.repository;

import org.example.tropicaliasapi.model.StatusVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusVendaRepository extends JpaRepository<StatusVenda, Long> {
}

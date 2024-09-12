package org.example.tropicaliasapi.repository;

import org.example.tropicaliasapi.model.Barraca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarracaRepository extends JpaRepository<Barraca, Long> {
}

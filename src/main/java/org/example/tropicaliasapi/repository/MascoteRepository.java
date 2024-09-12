package org.example.tropicaliasapi.repository;

import org.example.tropicaliasapi.model.Mascote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascoteRepository extends JpaRepository<Mascote, Long> {
}

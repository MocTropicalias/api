package org.example.tropicaliasapi.repository;

import org.example.tropicaliasapi.model.Mascote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MascoteRepository extends JpaRepository<Mascote, Long> {
    Optional<Mascote> getMascoteByUsuarioId(Long id);
}

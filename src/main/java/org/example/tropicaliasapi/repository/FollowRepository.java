package org.example.tropicaliasapi.repository;

import org.example.tropicaliasapi.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Repository
@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    Optional<Follow> getFollowByIdSeguidorAndIdSeguido(Long idSeguidor, Long idSeguido);
    int countFollowsByIdSeguido(Long id);

    int countFollowsByIdSeguidor(Long id);

    void deleteByIdSeguidorAndIdSeguido(Long idSeguidor, Long idSeguido);

    List<Follow> getFollowsByIdSeguidor(Long idSeguidor);
}


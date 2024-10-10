package org.example.tropicaliasapi.repository;

import org.example.tropicaliasapi.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    Optional<Follow> getFollowByIdSeguidoAndIdSeguidor(Long idSeguidor, Long idSeguido);
    int countFollowsByIdSeguido(Long id);

    int countFollowsByIdSeguidor(Long id);

    boolean deleteFollowByIdSeguidoAndIdSeguidor(Long idSeguido, Long idSeguidor);
}

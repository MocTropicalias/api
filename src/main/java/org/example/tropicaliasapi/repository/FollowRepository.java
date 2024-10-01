package org.example.tropicaliasapi.repository;

import org.example.tropicaliasapi.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    int countFollowsByIdSeguido(Long id);

    boolean deleteFollowByIdSeguidoAndIdSeguidor(Long idSeguido, Long idSeguidor);
}

package org.example.tropicaliasapi.repository;

import org.example.tropicaliasapi.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByIdUsuario(Long id);

    Ticket findByUserIdAndEventId(Long userId, Long eventoId);
}

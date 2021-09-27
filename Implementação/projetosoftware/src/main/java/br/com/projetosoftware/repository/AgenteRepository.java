package br.com.projetosoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetosoftware.model.Agente;

public interface AgenteRepository extends JpaRepository<Agente, Long> {
    
}

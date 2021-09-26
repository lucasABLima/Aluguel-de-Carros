package br.com.projetosoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetosoftware.model.Contratante;

public interface ContratanteRepository extends JpaRepository<Contratante, Long> {
    
}

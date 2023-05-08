package br.com.fiap.AbcTechApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.AbcTechApi.entity.Assistance;

@Repository
public interface AssistanceRepository extends JpaRepository<Assistance, Long> {
    
    
}

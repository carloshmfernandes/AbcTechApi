package br.com.fiap.AbcTechApi.repository;
import br.com.fiap.AbcTechApi.entity.Assistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistanceRepository extends JpaRepository<Assistance, Long> {
    Assistance findByName(String name);
}

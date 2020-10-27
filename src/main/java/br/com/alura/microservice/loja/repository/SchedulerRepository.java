package br.com.alura.microservice.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.loja.model.SchedulerJobInfo;

/**
 * @author Chamith
 */
@Repository
public interface SchedulerRepository extends JpaRepository<SchedulerJobInfo, Long> {

}

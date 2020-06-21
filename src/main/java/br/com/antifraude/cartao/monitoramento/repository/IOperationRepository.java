package br.com.antifraude.cartao.monitoramento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.antifraude.cartao.monitoramento.model.Operation;

@Repository
public interface IOperationRepository extends JpaRepository<Operation, Long> {

	Optional<Operation> findByTypeOperation(String typeOperation);
}

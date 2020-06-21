package br.com.antifraude.cartao.monitoramento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.antifraude.cartao.monitoramento.model.Transaction;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {

	Optional<Transaction> findByCodeValidation(Long codeValidation);
}

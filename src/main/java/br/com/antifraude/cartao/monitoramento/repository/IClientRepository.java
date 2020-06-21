package br.com.antifraude.cartao.monitoramento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.antifraude.cartao.monitoramento.model.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByCpf(String cpf);
}

package br.login.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.login.app.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}

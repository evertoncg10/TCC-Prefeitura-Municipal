package br.com.api.coletalixo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.coletalixo.entity.Coleta;

public interface ColetaRepository extends JpaRepository<Coleta, Long> {

}

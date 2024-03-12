package br.com.daniape.AppControleContatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.daniape.AppControleContatos.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
		
	@Query(value="SELECT tipo_contato, id, id_pessoa, contato FROM itau.contato WHERE id_pessoa = :idpessoa", nativeQuery = true)
	List<Contato> findContatosPessoa(Long idpessoa);
}

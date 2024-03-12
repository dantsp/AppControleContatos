package br.com.daniape.AppControleContatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.daniape.AppControleContatos.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	//Os dados de mala direta sao concatenados no mysql utilizando CONCAT()
	@Query(value = "SELECT id, nome, CONCAT(logradouro,' – CEP:',cep,' - ',municipio,'/',uf) AS maladireta FROM itau.pessoa WHERE id = :id"
			, nativeQuery = true)
	List<Object[]> getMalaDireta(Integer id);
}

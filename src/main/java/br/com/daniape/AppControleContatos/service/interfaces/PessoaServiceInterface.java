package br.com.daniape.AppControleContatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.daniape.AppControleContatos.dto.MalaDiretaDTO;
import br.com.daniape.AppControleContatos.model.Pessoa;

public interface PessoaServiceInterface {

	//Salvar o produto
	Pessoa save(Pessoa pessoa);
	//Recuperar 1 produto
	Optional<Pessoa> getById(Long id);
	//Recuperar todos os produtos
	List<Pessoa> getAll();
	//Atualizar o produto
	Pessoa update(Pessoa pessoa);
	//Deletar o produto
	void delete(Long id);
	//Recuperar MalaDireta por ID pessoa
	List<MalaDiretaDTO> getMalaDireta(Integer id);
}

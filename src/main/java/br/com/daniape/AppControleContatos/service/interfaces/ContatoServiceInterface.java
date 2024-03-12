package br.com.daniape.AppControleContatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.daniape.AppControleContatos.model.Contato;

public interface ContatoServiceInterface {

	//Salvar o contato
	Contato save(Contato contato);
	//Recuperar 1 contato
	Optional<Contato> getById(Long id);
	//Recuperar todos os contatos
	List<Contato> getAll();
	//Atualizar o contato
	Contato update(Contato contato);
	//Deletar o contato
	void delete(Long id);
}

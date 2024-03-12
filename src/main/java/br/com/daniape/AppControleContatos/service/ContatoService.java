package br.com.daniape.AppControleContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daniape.AppControleContatos.model.Contato;
import br.com.daniape.AppControleContatos.model.Pessoa;
import br.com.daniape.AppControleContatos.repository.ContatoRepository;
import br.com.daniape.AppControleContatos.repository.PessoaRepository;
import br.com.daniape.AppControleContatos.service.interfaces.ContatoServiceInterface;

@Service
public class ContatoService implements ContatoServiceInterface {
			
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public ContatoService() {
	}

	@Autowired
	public ContatoService(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}
	
	@Override
	public Contato save(Contato contato) {
		
		//verificar se o contato existe, caso não, avisar:
		if(contato.getPessoa().getId() != null) {
			Optional<Pessoa> findPessoa = pessoaRepository.findById(contato.getPessoa().getId());
			if(findPessoa.isEmpty()) {
				System.out.println("Cadastro de Pessoa não encontrado.");
				return null;
			}else {
				contato.setPessoa(findPessoa.get());
				return contatoRepository.save(contato);
			}
		}else {
			System.out.println("Pessoa vazio.");
			return null;
		}
	}
	
	@Override
	public Optional<Contato> getById(Long id) {		
		return contatoRepository.findById(id);
	}

	@Override
	public List<Contato> getAll() {
		return contatoRepository.findAll();
	}
	
	public List<Contato> findContatosPessoa(Long idpessoa)
	{
		return contatoRepository.findContatosPessoa(idpessoa);
	}
	
	@Override
	public Contato update(Contato contato) {
		Optional<Contato> findContato = contatoRepository.findById(contato.getId());
		
		if(findContato.isPresent()) {
			
			Contato updateContato = findContato.get();
			updateContato.setPessoa(findContato.get().getPessoa()); 
			updateContato.setTipoContato(contato.getTipoContato());
			updateContato.setContato(contato.getContato());
			
			return contatoRepository.save(updateContato);
		}
		
		return contato;
	}
	
	@Override
	public void delete(Long id) {
		contatoRepository.deleteById(id);		
	}	
}

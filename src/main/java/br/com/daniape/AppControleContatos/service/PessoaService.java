package br.com.daniape.AppControleContatos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daniape.AppControleContatos.dto.MalaDiretaDTO;
import br.com.daniape.AppControleContatos.model.Pessoa;
import br.com.daniape.AppControleContatos.repository.PessoaRepository;
import br.com.daniape.AppControleContatos.service.interfaces.PessoaServiceInterface;

@Service
public class PessoaService implements PessoaServiceInterface {
		
	private PessoaRepository pessoaRepository;
	
	public PessoaService() {
	}

	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	@Override
	public Pessoa save(Pessoa pessoa) {		
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Optional<Pessoa> getById(Long id) {
		return pessoaRepository.findById(id);
	}
	
	@Override
	public List<Pessoa> getAll() {
		return pessoaRepository.findAll();
	}
	
	@Override
	public Pessoa update(Pessoa pessoa) {
		Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId());
		
		if(findPessoa.isPresent()) {
			Pessoa updatePessoa = findPessoa.get();
			updatePessoa.setNome(pessoa.getNome());
			updatePessoa.setEndereco(pessoa.getEndereco());
			updatePessoa.setCep(pessoa.getCep());
			updatePessoa.setCidade(pessoa.getCidade());
			updatePessoa.setUf(pessoa.getUf());
			return pessoaRepository.save(updatePessoa);
		}
		return pessoa;	
	}
	
	@Override
	public void delete(Long id) {
		pessoaRepository.deleteById(id);	
	}
	
	@Override
	public List<MalaDiretaDTO> getMalaDireta(Integer id) {
		List<Object[]> listResult = pessoaRepository.getMalaDireta(id);
		List<MalaDiretaDTO> listMalaDiretaSimplesDTO = new ArrayList<>();
		
		listResult.forEach(result -> {
			listMalaDiretaSimplesDTO.add(returnMalaDiretaSimples(result));
		});
		
		if(listMalaDiretaSimplesDTO.size() > 0)
			return listMalaDiretaSimplesDTO;
		return null;
	}
	
	private MalaDiretaDTO returnMalaDiretaSimples(Object[] result) {
		MalaDiretaDTO malaDiretaDTO = new MalaDiretaDTO();
		if(result != null) {
			malaDiretaDTO.setId( ((Long)result[0]).longValue() );
			malaDiretaDTO.setNome( (String)result[1] );
			malaDiretaDTO.setMaladireta( ((String)result[2]));
		}
		return malaDiretaDTO;
	}
}


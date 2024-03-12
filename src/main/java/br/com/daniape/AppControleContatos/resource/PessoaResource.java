package br.com.daniape.AppControleContatos.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daniape.AppControleContatos.dto.MalaDiretaDTO;
import br.com.daniape.AppControleContatos.model.Contato;
import br.com.daniape.AppControleContatos.model.Pessoa;
import br.com.daniape.AppControleContatos.service.ContatoService;
import br.com.daniape.AppControleContatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas") //http://localhost:8081/api/pessoas
public class PessoaResource {
	
	private PessoaService pessoaService;
	
	@Autowired
	private ContatoService contatoService;
	
	@Autowired
	public PessoaResource(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	/* POST /api/pessoas */
	@Operation(summary = "Cria uma nova pessoa")
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
		Pessoa newPessoa = pessoaService.save(pessoa);
		if(newPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newPessoa);
	}
	
	/* GET /api/pessoas/{id} */
	@Operation(summary = "Retorna os dados de uma Pessoa por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Long id){
		Optional<Pessoa> pessoa = pessoaService.getById(id);
		if(pessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoa);
	}
		
	/* GET /api/pessoas/maladireta/{id} */ 
	@Operation(summary = "Retorna os dados de uma Pessoa por ID para mala direta")
	@GetMapping("/maladireta/{id}")
	public ResponseEntity<List<MalaDiretaDTO>> getMalaDireta(@PathVariable Integer id)
	{
		List<MalaDiretaDTO> listMalaDiretaDTO = pessoaService.getMalaDireta(id);
		if(listMalaDiretaDTO == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(listMalaDiretaDTO);
	}
		
	/* GET /api/pessoas */
	@Operation(summary = "Busca registros de todas as pessoas cadastradas")
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAllProdutos(){
		List<Pessoa> pessoas = pessoaService.getAll();
		if(pessoas == null)
			return ResponseEntity.notFound().build();
		if(pessoas.size() == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoas);
	}
	
	/* PUT /api/pessoas/{id} */
	@Operation(summary = "Atualiza uma Pessoa existente")
	@PutMapping
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
		Pessoa upPessoa = pessoaService.update(pessoa);
		if(upPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(upPessoa);
	}
	
	/* DELETE /api/pessoas/{id} */
	@Operation(summary = "Remove uma Pessoa por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/* POST /api/pessoas */
	@Operation(summary = "Adiciona um novo Contato a uma Pessoa")
	@PostMapping("/{id}/contatos")
	public ResponseEntity<Contato> save(@PathVariable Long id,@RequestBody Contato contato){
		Optional<Pessoa> pessoa = pessoaService.getById(id);
		if(pessoa == null) 
		{
			return ResponseEntity.notFound().build();
		}
		else 
		{
			contato.getPessoa().setId(id);
			Contato newContato = contatoService.save(contato);
			if(newContato == null)
				return ResponseEntity.notFound().build();
			return ResponseEntity.ok(newContato);
		}		
	}
	
	@Operation(summary = "Lista todos os Contatos de uma Pessoa")
	@GetMapping("/{idpessoa}/contatos")
	public ResponseEntity<List<Contato>> findContatosPessoa(@PathVariable Long idpessoa){
		List<Contato> findContato = contatoService.findContatosPessoa(idpessoa);
		if(findContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(findContato);
	}
}

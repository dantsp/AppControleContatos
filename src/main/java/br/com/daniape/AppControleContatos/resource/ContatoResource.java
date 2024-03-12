package br.com.daniape.AppControleContatos.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daniape.AppControleContatos.model.Contato;
import br.com.daniape.AppControleContatos.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {
	
	private ContatoService contatoService;
	
	@Autowired
	public ContatoResource(ContatoService contatoService) {
		this.contatoService = contatoService;
	}
		
	@Operation(summary = "Retorna os dados de um Contato por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contato>> getById(@PathVariable Long id){
		Optional<Contato> findContato = contatoService.getById(id);
		if(findContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(findContato);
	}
	
	@Operation(summary = "Atualiza um Contato existente")
	@PutMapping
	public ResponseEntity<Contato> update(@RequestBody Contato contato){
		Contato findContato = contatoService.update(contato);
		if(findContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(findContato);
	}
	
	@Operation(summary = "Remove um Contato por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

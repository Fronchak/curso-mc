package com.nelioalves.cursomc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nelioalves.cursomc.entities.Categoria;
import com.nelioalves.cursomc.entities.Cidade;
import com.nelioalves.cursomc.entities.Cliente;
import com.nelioalves.cursomc.entities.Endereco;
import com.nelioalves.cursomc.entities.Estado;
import com.nelioalves.cursomc.entities.Produto;
import com.nelioalves.cursomc.entities.Telefone;
import com.nelioalves.cursomc.entities.enums.TipoCliente;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;
import com.nelioalves.cursomc.repositories.TelefoneRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mause", 80.00);
		
		Estado estado1 = new Estado(null, "Paraná");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Curitiba", estado1);
		Cidade cidade2 = new Cidade(null, "Osasco", estado2);
		Cidade cidade3 = new Cidade(null, "Colombo", estado1);
		Cidade cidade4 = new Cidade(null, "São Paulo", estado2);
		
		Cliente cliente1 = new Cliente(null, "Gabriel Fronchak Gmack", "gabrielgmack@gmail.com", "10719522935", TipoCliente.PESSOA_FISICA);
		Cliente cliente2 = new Cliente(null, "Alice Fronchak", "alicefronchak@gmail.com", "63802082915", TipoCliente.PESSOA_FISICA);
		
		Telefone tel1 = new Telefone("995259513", cliente1);
		Telefone tel2 = new Telefone("996359844", cliente2);
		Telefone tel3 = new Telefone("211516515", cliente1);
		
		Endereco end1 = new Endereco(null, "São Jose", "51616516", cliente1, cidade1);
		Endereco end2 = new Endereco(null, "Osasco", "1516515", cliente2, cidade2);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3, cidade4));
		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
		telefoneRepository.saveAll(Arrays.asList(tel1, tel2, tel3));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat2);
		p3.getCategorias().add(cat1);
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}

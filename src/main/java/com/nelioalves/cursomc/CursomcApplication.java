package com.nelioalves.cursomc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.domain.enuns.TipoCliente;
import com.nelioalves.cursomc.repository.CategoriaRepository;
import com.nelioalves.cursomc.repository.CidadeRepository;
import com.nelioalves.cursomc.repository.ClienteRepository;
import com.nelioalves.cursomc.repository.EnderecoRepository;
import com.nelioalves.cursomc.repository.EstadoRepository;
import com.nelioalves.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria("Informatica");
		Categoria cat2 = new Categoria("Desenvolvimento");
		
		Produto pro1 = new Produto("Computador", 2000.00);
		Produto pro2 = new Produto("Impressora", 800.00);
		Produto pro3 = new Produto("Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(pro1, pro2, pro3));
		cat2.getProdutos().addAll(Arrays.asList(pro2));
		
		pro1.getCategorias().addAll(Arrays.asList(cat1));
		pro2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		pro3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(pro1, pro2, pro3));
		
		
		Estado est1 = new Estado("Minas Gerais");
		Estado est2 = new Estado("São Paulo");
		
		Cidade c1 = new Cidade("Uberlândia", est1);
		Cidade c2 = new Cidade("São Paulo", est2);
		Cidade c3 = new Cidade("Campinas", est2);
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cl1 = new Cliente("Walber", "wjjunho@hotmail.com", "66489377349", TipoCliente.PESSOAFISICA);
		cl1.setTelefones(new HashSet<String>(Arrays.asList("62982597679", "62982544333")));
		Cliente cl2 = new Cliente("Marciel", "walberjunior22@gmail.com", "12345678901234", TipoCliente.PESSOAJURIDICA);
		cl2.setTelefones(new HashSet<String>(Arrays.asList("62983456434", "62982456677")));
		
		clienteRepository.saveAll(Arrays.asList(cl1, cl2));
		
		Endereco end1 = new Endereco("Rua Vm4D", "1", "Qd:101 Lt:06", "Setor Novo Planalto", "74480400", cl1, c1);
		Endereco end2 = new Endereco("Rua Joaquim Medeiros", "4", "Qd:03 Lt:4", "Estrela Dalva", "74456904", cl1, c1);
		Endereco end3 = new Endereco("Av. 12A", "12", "Qd:04 Lt:3", "Centro", "74480400", cl2, c2);
		
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		
	}
	

}

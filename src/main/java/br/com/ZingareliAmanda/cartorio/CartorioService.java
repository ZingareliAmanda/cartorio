package br.com.ZingareliAmanda.cartorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartorioService {
	
	private final CartorioDAO dao;
	
	@Autowired
	CartorioService(CartorioDAO dao) {
		this.dao = dao;
	}

	public long contarTodos() {
		return this.dao.count();
	}

	public List<Cartorio> getTodos() {
		return this.dao.findAll();
	}

	public Optional<Cartorio> getPorId(Long id) {
		return this.dao.findById(id);
	}

	public void salvar(Cartorio objeto) {
		this.dao.saveAndFlush(objeto);
	}

	public void atualizar(Cartorio objeto) {
		this.dao.saveAndFlush(objeto);
	}

	public void remover(Cartorio objeto) {
		this.dao.delete(objeto);
	}

	public void removerPorId(Long id) {
		this.getPorId(id).ifPresent(objeto -> this.dao.delete(objeto));
	}
}

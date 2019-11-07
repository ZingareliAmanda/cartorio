package br.com.ZingareliAmanda.cartorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface CartorioDAO  extends JpaRepository<Cartorio, Long>{
	
	@Query("SELECT c FROM Cartorio c ORDER BY c.id")
	public List<Cartorio> findAllOrderByIdAscss();
}

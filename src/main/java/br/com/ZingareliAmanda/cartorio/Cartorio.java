package br.com.ZingareliAmanda.cartorio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cartorio {
	
	private String nome;
	
	@Id
	@GeneratedValue
	private long id;
	
}

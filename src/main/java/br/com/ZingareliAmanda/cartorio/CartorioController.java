package br.com.ZingareliAmanda.cartorio;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class CartorioController {
	
	private final CartorioService cartorioService;
	CartorioController(CartorioService cartorioService){
		this.cartorioService = cartorioService;
	}
	
	@GetMapping("/cartorios")
	public ModelAndView listagem() {
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("cartorios", cartorioService.getTodos());
		return mv;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		return new ModelAndView("new");
	}
	
	@GetMapping("/editar")
	public @ResponseBody String editar(Cartorio cartorio) {
		System.out.println(cartorio.getNome());
		return"aaa";
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarNovo(Cartorio cartorio) {
		cartorioService.salvar(cartorio);
		return new ModelAndView("redirect:/novo", HttpStatus.CREATED);
	}
	
	@PutMapping("/salvar")
	public @ResponseBody String salvarEdicao() {
		return"edit";
	}
	
	@DeleteMapping("/deletar")
	public @ResponseBody String remover(String id) {
		return"remove";
	}
}

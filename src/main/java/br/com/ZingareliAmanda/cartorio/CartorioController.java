package br.com.ZingareliAmanda.cartorio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class CartorioController {

	private final CartorioService cartorioService;

	CartorioController(CartorioService cartorioService) {
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

	@PostMapping("/salvar")
	public ResponseEntity<?> salvarNovo(@RequestParam("nome") String nome, @RequestParam("id") Long id) {
		Cartorio cartorio = new Cartorio();
		cartorio.setNome(nome);
		cartorioService.salvar(cartorio);
		return ResponseEntity.status(HttpStatus.CREATED).body("criado");
	}

	@PutMapping("/salvar")
	public ResponseEntity<?> salvarEdicao(@RequestParam("nome") String nome, @RequestParam("id") Long id) {
		Cartorio cartorio = new Cartorio();
		cartorio.setNome(nome);
		cartorio.setId(id);
		cartorioService.salvar(cartorio);
		return ResponseEntity.status(HttpStatus.OK).body("atualizado");
	}

	@DeleteMapping("/deletar")
	public ResponseEntity<?> remover(String id) {
		try {
			cartorioService.removerPorId(Long.parseLong(id));
			return ResponseEntity.status(HttpStatus.OK).body("sucesso");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erro");
		}
	}
}

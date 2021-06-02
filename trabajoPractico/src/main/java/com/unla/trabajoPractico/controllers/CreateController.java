package com.unla.trabajoPractico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.trabajoPractico.helpers.ViewRouteHelper;
import com.unla.trabajoPractico.models.PerfilModel;
import com.unla.trabajoPractico.models.RodadoModel;
import com.unla.trabajoPractico.services.Implementation.PerfilService;
import com.unla.trabajoPractico.services.Implementation.RodadoService;

@Controller
@RequestMapping("/create")
public class CreateController {
	
	@Autowired
	@Qualifier("perfilService")
	private PerfilService perfilService;
	
	@Autowired
	@Qualifier("rodadoService")
	private RodadoService rodadoService;
	
	//Crear Perfil
	@GetMapping("/profile")
	public ModelAndView createPerfil() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.PERFIL_CREATE);
		mAV.addObject("perfil", new PerfilModel());
		return mAV;
	}
	
	@PostMapping("/profile")
	public RedirectView savePerfil(@ModelAttribute("perfil") PerfilModel perfilModel) {
		perfilService.insertOrUpdate(perfilModel);
		return new RedirectView(ViewRouteHelper.PERFIL_REFRESH);
	}
	
	@GetMapping("/rodado")
	public ModelAndView createRodado() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ROD_CREATE);
		mAV .addObject("rodado", new RodadoModel());
		return mAV;
	}
	
	@PostMapping("/rodado")
	public RedirectView saveRodado(@ModelAttribute("rodado") RodadoModel rodadoModel) {
		rodadoService.insertOrUpdate(rodadoModel);
		return new RedirectView(ViewRouteHelper.ROD_REFRESH);
	}

}

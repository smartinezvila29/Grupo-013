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
import com.unla.trabajoPractico.models.UsuarioModel;
import com.unla.trabajoPractico.services.Implementation.UsuarioService;

@Controller
@RequestMapping("/signup/user")
public class CreateUserController {
	
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.PERFIL_INDEX);
		mAV.addObject("perfil", new PerfilModel());
		return mAV;
	}
	
	@PostMapping("")
	public RedirectView create(@ModelAttribute("usuario") UsuarioModel usuarioModel) {
		usuarioService.insertOrUpdate(usuarioModel);
		return new RedirectView(ViewRouteHelper.HOME);
	}
	
	

}

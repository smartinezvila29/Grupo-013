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
import com.unla.trabajoPractico.services.Implementation.PerfilService;

@Controller
@RequestMapping("/signup/profile")
public class CreatePerfilController {
	
	@Autowired
	@Qualifier("perfilService")
	private PerfilService perfilService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.PERFIL_INDEX);
		mAV.addObject("perfil", new PerfilModel());
		return mAV;
	}
	
	@PostMapping("")
	public RedirectView create(@ModelAttribute("perfil") PerfilModel perfilModel) {
		perfilService.insertOrUpdate(perfilModel);
		return new RedirectView(ViewRouteHelper.CREATE_USER);
	}

}

package com.unla.trabajoPractico.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.trabajoPractico.helpers.SessionManager;
import com.unla.trabajoPractico.helpers.ViewRouteHelper;
import com.unla.trabajoPractico.models.PerfilModel;
import com.unla.trabajoPractico.models.RodadoModel;
import com.unla.trabajoPractico.models.UsuarioModel;
import com.unla.trabajoPractico.services.Implementation.PerfilService;
import com.unla.trabajoPractico.services.Implementation.RodadoService;
import com.unla.trabajoPractico.services.Implementation.UsuarioService;

@Controller
@RequestMapping("/create")
public class CreateController {
	
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@Autowired
	@Qualifier("perfilService")
	private PerfilService perfilService;
	
	@Autowired
	@Qualifier("rodadoService")
	private RodadoService rodadoService;

	private void SigninSession(HttpServletRequest req, UsuarioModel user) {
		SessionManager.setSession(req.getSession());
		SessionManager.setUsername(user.getNombre());
		SessionManager.setOnline(true);
	}
	
	//Usuario
	@GetMapping("/user")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USER_CREATE);
		mAV.addObject("usuario", new UsuarioModel());
		return mAV;
	}
	
	@PostMapping("/user")
	public RedirectView create(HttpServletRequest req, @ModelAttribute("usuario") UsuarioModel usuarioModel) {
		if(!SessionManager.isOnline())
		{
		UsuarioModel user = usuarioModel;
		UsuarioModel _user = usuarioService.getUser(user.getNombre());
		//if (SessionHelper.getNombre() == null) {
			//SessionHelper.setNombre(user.getNombre());
			if (_user!=null && user.getNombre().equals(_user.getNombre())) {
				if (!user.getContraseña().equals(_user.getContraseña())) {
					return new RedirectView(ViewRouteHelper.SHARED_ERROR);
				}
				else
				{
					SigninSession(req, user);
					return new RedirectView(ViewRouteHelper.HOME);
				}
			} else {
				SigninSession(req, user);
				user.setActive(true);
				usuarioService.insertOrUpdate(user);
				return new RedirectView(ViewRouteHelper.HOME);
			}
		}else {
			return new RedirectView(ViewRouteHelper.SHARED_ERROR);
		}
	}
	
	//Perfil
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
	
	//Rodado
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

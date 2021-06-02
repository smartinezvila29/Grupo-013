package com.unla.trabajoPractico.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.trabajoPractico.helpers.SessionManager;
import com.unla.trabajoPractico.helpers.ViewRouteHelper;
import com.unla.trabajoPractico.models.PerfilModel;
import com.unla.trabajoPractico.models.UsuarioModel;
import com.unla.trabajoPractico.services.Implementation.UsuarioService;

@Controller
@RequestMapping("")
public class CreateUserController {
	
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;

	private void SigninSession(HttpServletRequest req, UsuarioModel user) {
		SessionManager.setSession(req.getSession());
		SessionManager.setUsername(user.getNombre());
		SessionManager.setOnline(true);
	}
	
	@GetMapping("/user/list")
	public ModelAndView view() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.USER_LIST);
		mAV.addObject("lstUser", usuarioService.getAll());
		mAV.addObject("usuario", new UsuarioModel());
		return mAV;
	}
	
	@GetMapping("/delete/{nombre}")
	@PostMapping("/delete/{nombre}")
	public RedirectView remove(@PathVariable("nombre") String nombre) {
		UsuarioModel _user = usuarioService.getUser(nombre);
		int id = _user.getIdUsuario();
		usuarioService.delete(id);
		return new RedirectView(ViewRouteHelper.HOME);
	}
	
	//Editar Perfil
		@GetMapping("/edit/{nombre}")
		public ModelAndView edit(@PathVariable("nombre") String nombre) {
			ModelAndView mAV= new ModelAndView(ViewRouteHelper.USER_EDIT);
			UsuarioModel _user = usuarioService.getUser(nombre);
			mAV.addObject("usuario", usuarioService.getUser(nombre));
			mAV.addObject("contraseña", null);
			mAV.addObject("idPerfil", _user.getIdUsuario());
			return mAV;
		}
		
		@PostMapping("user/update")
		public RedirectView update(@ModelAttribute("usuario") UsuarioModel usuarioModel) {
			usuarioService.update(usuarioModel);
			return new RedirectView(ViewRouteHelper.HOME);
		}

		@GetMapping("/user/logout")
		@PostMapping("/user/logout")
		public RedirectView logout() {
			SessionManager.setOnline(false);
			SessionManager.setUsername(null);
			SessionManager.setRol("administrador");
			return new RedirectView(ViewRouteHelper.HOME);
		}
}

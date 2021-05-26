package com.unla.trabajoPractico.controllers;


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

import com.unla.trabajoPractico.helpers.SessionHelper;
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
	
	@GetMapping("/login")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USER_LOGIN);
		mAV.addObject("usuario", new UsuarioModel());
		return mAV;
	}
	
	@PostMapping("/login")
	public RedirectView create(@ModelAttribute("usuario") UsuarioModel usuarioModel) {
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
					return new RedirectView(ViewRouteHelper.HOME);
				}
			} else {
				user.setActive(true);
				usuarioService.insertOrUpdate(user);
				return new RedirectView(ViewRouteHelper.HOME);
			}
		//} else {
			//return new RedirectView(ViewRouteHelper.SHARED_ERROR);
		//}
	}
	
	@GetMapping("/user/list")
	public ModelAndView view() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.USER_LIST);
		mAV.addObject("lstUser", usuarioService.getAll());
		mAV.addObject("usuario", new UsuarioModel());
		return mAV;
	}
	
	@PostMapping("/delete/{nombre}")
	public RedirectView delete(@PathVariable("nombre") String nombre) {
		UsuarioModel _user = usuarioService.getUser(nombre);
		int id = _user.getIdUsuario();
		usuarioService.delete(id);
		return new RedirectView(ViewRouteHelper.HOME);
	}
	
	//Editar Perfil
		@GetMapping("/edit/{nombre}")
		public ModelAndView edit(@PathVariable("nombre") String nombre) {
			ModelAndView mAV= new ModelAndView(ViewRouteHelper.USER_EDIT);
			mAV.addObject("usuario", usuarioService.getUser(nombre));
			return mAV;
		}
		
		@PostMapping("user/update")
		public RedirectView update(@ModelAttribute("usuario") UsuarioModel usuarioModel) {
			usuarioService.update(usuarioModel);
			return new RedirectView(ViewRouteHelper.PERFIL_REFRESHLIST);
		}
}

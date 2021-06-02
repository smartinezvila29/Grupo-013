package com.unla.trabajoPractico.helpers;

public class ViewRouteHelper {
	
	//HOME
	public final static String INDEX = "home/index";
	
	//PERFIL
	public final static String PERFIL_CREATE = "create/createperfil";
	public final static String PERFIL_LIST = "list/listperfiles";
	public final static String PERFIL_EDIT = "edit/editperfil";
	
	//USER
	public final static String USER_CREATE = "create/createusuario";
	public final static String USER_EDIT = "user/edit";
	public final static String USER_LIST = "user/list";
	public final static String USER_LOGOUT = "user/logout";
	
	//RODADO
	public final static String ROD_CREATE = "create/createrodado";
	
	/**** Redirects ****/
	public final static String HOME = "/";
	public final static String PERFIL_REFRESH = "/create/profile";
	public final static String PERFIL_REFRESHLIST= "/profile/list";
	public final static String ROD_REFRESH = "/create/rodado";
	
	//ERROR
	public final static String SHARED_ERROR = "shared/error";
	public final static String SHARED_LAYOUT = "shared/layout";
}

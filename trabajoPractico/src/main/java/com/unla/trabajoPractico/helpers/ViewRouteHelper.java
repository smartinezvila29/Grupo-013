package com.unla.trabajoPractico.helpers;

public class ViewRouteHelper {
	
	//HOME
	public final static String INDEX = "home/index";
	
	//PERFIL
	public final static String PERFIL_INDEX = "create/perfil";
	public final static String PERFIL_LIST = "create/verperfiles";
	public final static String PERFIL_EDIT = "create/edit";
	public final static String NEWDPERFIL = "create/newperfil";
	
	//USER
	public final static String USER_LOGIN = "user/create";
	public final static String USER_EDIT = "user/edit";
	public final static String USER_LIST = "user/list";
	public final static String USER_LOGOUT = "user/logout";
	
	/**** Redirects ****/
	public final static String ROUTE = "/index";
	public final static String PERFIL_REFRESH = "/profile/signup";
	public final static String PERFIL_REFRESHLIST= "/profile/list";
	public final static String HOME = "/";
	
	//ERROR
	public final static String SHARED_ERROR = "shared/error";
	public final static String SHARED_LAYOUT = "shared/layout";
}

package com.unla.trabajoPractico.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.trabajoPractico.models.UsuarioModel;

public class SessionManager {
	
	private static String username;
	private static boolean online = false;
	private static String rol;
	private static HttpSession session;
	
	public SessionManager() {
		super();
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		SessionManager.username = username;
	}

	public static boolean isOnline() {
		return online;
	}

	public static void setOnline(boolean online) {
		SessionManager.online = online;
	}

	public static HttpSession getSession() {
		return session;
	}

	public static void setSession(HttpSession session) {
		SessionManager.session = session;
	}

	public static String getRol() {
		return rol;
	}

	public static void setRol(String rol) {
		SessionManager.rol = rol;
	}
	
	

}

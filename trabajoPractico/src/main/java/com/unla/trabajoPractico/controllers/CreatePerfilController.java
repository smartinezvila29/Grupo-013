package com.unla.trabajoPractico.controllers;


import java.awt.Color;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.unla.trabajoPractico.entities.Perfil;
import com.unla.trabajoPractico.helpers.ViewRouteHelper;
import com.unla.trabajoPractico.models.PerfilModel;
import com.unla.trabajoPractico.services.Implementation.PerfilService;

@Controller
@RequestMapping("/profile")
public class CreatePerfilController {
	
	@Autowired
	@Qualifier("perfilService")
	private PerfilService perfilService;
    
	//Crear Perfil
	@GetMapping("/signup")
	public ModelAndView index() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.PERFIL_INDEX);
		mAV.addObject("perfil", new PerfilModel());
		return mAV;
	}
	
	@PostMapping("/signup")
	public RedirectView create(@ModelAttribute("perfil") PerfilModel perfilModel) {
		perfilService.insertOrUpdate(perfilModel);
		return new RedirectView(ViewRouteHelper.PERFIL_REFRESH);
	}
	
	//Lista de Perfiles
	@GetMapping("/list")
	public ModelAndView view() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.PERFIL_LIST);
		mAV.addObject("perfiles", perfilService.getAll());
		mAV.addObject("perfil", new PerfilModel());
		return mAV;
	}
	
	//Editar Perfil
	@GetMapping("/edit{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.PERFIL_EDIT);
		mAV.addObject("perfil", perfilService.findById(id));
		return mAV;
		
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("perfil") PerfilModel perfilModel) {
		perfilService.insertOrUpdate(perfilModel);
		return new RedirectView(ViewRouteHelper.PERFIL_REFRESHLIST);
	}
	
	//Eliminar Perfil
	@GetMapping("/remove{id}")
	public RedirectView remove(@PathVariable("id") int id) {
		perfilService.remove(id);
		return new RedirectView(ViewRouteHelper.PERFIL_REFRESHLIST);
	}
	
	// Descargar PDF
	 @RequestMapping("/download")
	 public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {

		 response.setHeader("content-Type", "application/pdf");
		 
		 response.setHeader("Content-Disposition", "attachment;filename=Perfiles-Grupo13.pdf");
	 
		 Document pdf = new Document();
		 PdfWriter.getInstance(pdf, response.getOutputStream());
		 pdf.open();
		 
		 Paragraph titulo = new Paragraph("Lista de Perfiles \n\n", FontFactory.getFont("Times", 20, 1, Color.BLACK));
		 pdf.add(titulo);
		 
		 PdfPTable atributos = new PdfPTable(5);
		 atributos.setWidthPercentage(100);
		 atributos.setWidths(new float[] {1.5f, 1.5f, 3.0f, 2.0f, 3.0f});
		 atributos.setSpacingAfter(10);
		 atributos.addCell("Nombre");
		 atributos.addCell("Apellido");
		 atributos.addCell("Tipo de Documento");
		 atributos.addCell("N° de Documento");
		 atributos.addCell("Email");
		 pdf.add(atributos);
				 
		 
		 List<Perfil> list = perfilService.getAll();
		 for (Perfil perfil : list) {
			 PdfPTable tabla = new PdfPTable(5);
			 tabla.setWidthPercentage(100);
			 tabla.setWidths(new float[] {1.5f, 1.5f, 3.0f, 2.0f, 3.0f});
			 PdfPCell celda = new PdfPCell();
	 
			 celda = new PdfPCell();
			 celda.setPhrase(new Paragraph(perfil.getNombre()));
			 tabla.addCell(celda);
			 pdf.add(tabla);
	 
			 celda = new PdfPCell();
			 celda.setPhrase(new Paragraph(perfil.getApellido()));
			 tabla.addCell(celda);
			 pdf.add(tabla);
			 
			 celda.setPhrase(new Paragraph(perfil.getTipoDocumento()));
			 tabla.addCell(celda);
			 pdf.add(tabla);
			 
			 celda.setPhrase(new Paragraph(String.valueOf(perfil.getNroDocumento())));
			 tabla.addCell(celda);
			 pdf.add(tabla);
			 
			 celda.setPhrase(new Paragraph(perfil.getEmail()));
			 tabla.addCell(celda);
			 pdf.add(tabla);
			 }
		 
		 		
	    pdf.close();
	  }
	

}

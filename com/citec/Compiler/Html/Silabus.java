package com.citec.Compiler.Html;

import java.util.ArrayList;
import java.util.List;

public class Silabus {
	static public List<Unidad> unidades;
	
	static public void initSilabus(){
		unidades = new ArrayList<Unidad>();
		List<Modulo> listModulos = new ArrayList<Modulo>();
		
		
		List<Leccion> l1= new  ArrayList<Leccion>();
		l1.add(new Leccion(1,"Configuración ambiente"));
		l1.add(new Leccion(2,"Introducción HTML y CSS"));
		l1.add(new Leccion(3,"Git , Github básico , Comando Git"));
		l1.add(new Leccion(4,"Estructura HTML"));
		l1.add(new Leccion(5,"Intro a CSS"));
		l1.add(new Leccion(6,"CSS Selectores"));
		l1.add(new Leccion(7,"DOM Model"));
		l1.add(new Leccion(8,"Modelo de la caja"));
		listModulos.add(new Modulo(1,"PRINCIPIOS BÁSICOS Y SETUP",l1));
		
		
		List<Leccion> l2= new  ArrayList<Leccion>();
		l2.add(new Leccion(1,"Display Types"));
		l2.add(new Leccion(2,"CSS Floatings"));
		l2.add(new Leccion(3,"CSS Positioning"));
		l2.add(new Leccion(4,"Práctica con ejercicios"));
		l2.add(new Leccion(5,"Intro a CSS"));
		l2.add(new Leccion(6,"Repaso"));
		l2.add(new Leccion(7,"Grid system"));
		
		listModulos.add(new Modulo(2,"INTRO A CSS",l2));

		List<Leccion> l3= new  ArrayList<Leccion>();
		l3.add(new Leccion(1,"Proyectos de maquetado"));
		l3.add(new Leccion(2,"Hackathon"));
		l3.add(new Leccion(3,"Examen de la unidad"));
		l3.add(new Leccion(4,"Práctica con ejercicios"));
		l3.add(new Leccion(5,"Intro a CSS"));
		l3.add(new Leccion(6,"Repaso"));
		l3.add(new Leccion(7,"Grid system"));
		
		listModulos.add(new Modulo(3,"LANDING PAGE",l3));
		
		Unidad unidad1= new Unidad(1, "HTML y CSS", listModulos);
		
		unidades.add(unidad1);
		
		
		
	}



}

package service;

import java.util.ArrayList;

import model.Pais;
import dao.PaisDAO;

public class CatalogoService {
	PaisDAO dao;
	
	public CatalogoService(){
		dao = new PaisDAO();
	}
	public ArrayList<Pais> listarPaises(){
		return dao.listarPaises();
	}
	public ArrayList<Pais> listarPaises(String chave){
		return dao.listarPaises(chave);
	}

}
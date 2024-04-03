package test;

import java.util.List;

import dao.ParfumDaoImpl;
import metier.entities.Parfum;

public class TestDao {

	public static void main(String[] args) {
		ParfumDaoImpl pdao= new ParfumDaoImpl();
		Parfum par= pdao.save(new Parfum("Yves Saint Laurent",3000));
		System.out.println(par);
		List<Parfum> pars =pdao.parfumsParMC("You");
		for (Parfum p : pars)
		System.out.println(p);
		}


	}
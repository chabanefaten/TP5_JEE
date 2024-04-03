package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IParfumDao;
import dao.ParfumDaoImpl;
import metier.entities.Parfum;

@SuppressWarnings("serial")
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
	public class ControleurServlet extends HttpServlet {
	IParfumDao metier;
	@Override
	public void init() throws ServletException {
	metier = new ParfumDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	 throws ServletException, IOException {
	String path=request.getServletPath();
	if (path.equals("/index.do"))
	{
	request.getRequestDispatcher("parfums.jsp").forward(request,response);
	}
	
	else if (path.equals("/chercher.do"))
	{
	String motCle=request.getParameter("motCle");
	ParfumModele model= new ParfumModele();
	model.setMotCle(motCle);
	List<Parfum> pars = metier.parfumsParMC(motCle);
	model.setParfums(pars);
	request.setAttribute("model", model);
	request.getRequestDispatcher("parfums.jsp").forward(request,response);
	}
	else if (path.equals("/saisie.do") )
	{
	request.getRequestDispatcher("saisieParfum.jsp").forward(request,response);
	}
	else if (path.equals("/save.do") && request.getMethod().equals("POST"))
	{
	 String nom=request.getParameter("nom");
	double prix = Double.parseDouble(request.getParameter("prix"));
	Parfum p = metier.save(new Parfum(nom,prix));
	request.setAttribute("parfum", p);
	request.getRequestDispatcher("confirmation.jsp").forward(request,response);
	}
	else if (path.equals("/supprimer.do"))
	{
	 Long id= Long.parseLong(request.getParameter("id"));
	 metier.deleteParfum(id);
	 response.sendRedirect("chercher.do?motCle=");
	}
	else if (path.equals("/saisie.do") )
	{
	request.getRequestDispatcher("saisieParfum.jsp").forward(request,response);
	}
	else if (path.equals("/save.do") && 
	request.getMethod().equals("POST"))
	{
	 String nom=request.getParameter("nom");
	double prix = Double.parseDouble(request.getParameter("prix"));
	Parfum p = metier.save(new Parfum(nom,prix));
	request.setAttribute("parfum", p);
	request.getRequestDispatcher("confirmation.jsp").forward(request,response);
	}
		else if (path.equals("/editer.do") )
		{
		Long id= Long.parseLong(request.getParameter("id"));
		 Parfum p = metier.getParfum(id);
		 request.setAttribute("parfum", p);
		request.getRequestDispatcher("editerParfum.jsp").forward(request,response);
		}
		else if (path.equals("/update.do") )
		{
		Long id = Long.parseLong(request.getParameter("id"));
		String nom=request.getParameter("nom");
		double prix = 
		Double.parseDouble(request.getParameter("prix"));
		Parfum p = new Parfum();
		p.setIdParfum(id);
		p.setNomParfum(nom);
		p.setPrix(prix);
		metier.updateParfum(p);
		request.setAttribute("parfum", p);
		request.getRequestDispatcher("confirmation.jsp").forward(request,response);
	{
	response.sendError(Response.SC_NOT_FOUND);
	}}
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws 
	ServletException, IOException {
	doGet(request,response);
	}
	
	}
	

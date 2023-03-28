package br.edu.ifgoiano.entidade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastrarUsuario")
public class CadastroUsuarioServlet extends HttpServlet {

	//Simulando banco de dados
	private List<usuario> lstDeUsuario;
	
	@Override
	public void init() throws ServletException {
		this.lstDeUsuario = new ArrayList<usuario>();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String senha1 = req.getParameter("senha1");
		String senha2 = req.getParameter("senha2");
		
		//verificar se as senhas s�o iguais
		if (senha1.equals(senha2)) {
			usuario usu = new usuario();
			usu.setNome(req.getParameter("nome"));
			usu.setEmail(req.getParameter("email"));
			usu.setSenha(senha1);
			
			lstDeUsuario.add(usu);
			
			//redirecionar o usu�rio para a p�gina de login
				resp.sendRedirect("index.html");
		}else {
			//redirecionar o usu�rio para a mesma p�gina de cad�tro de usu�rio
				req.getRequestDispatcher("frontCadastroUsuario.html").forward(req, resp);
		}
		
		
	}
	
	@Override
	public void destroy() {
		this.lstDeUsuario.clear();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		for (usuario usuario : lstDeUsuario) {
			System.out.println(usuario.getNome().concat("-").concat(usuario.getEmail()));
		}
	}
	
	
	
	
	
}

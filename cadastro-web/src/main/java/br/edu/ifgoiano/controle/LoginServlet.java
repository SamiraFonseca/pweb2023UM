package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7036815389008473423L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("email"));
		System.out.println(req.getParameter("senha"));

		if (req.getParameter("senha").equals("123456")) {
			String html = new String();
			html = "<html><body><h1> Senha Válida!!! ---------- Login realizado com sucesso!</h1></body></html>";
			PrintWriter writer = resp.getWriter();
			writer.println(html);
		} else {
			String html2 = new String();
			html2 = "<html><body><h1> Falha no login: email e/ou senha inválido(s)! </h1></body></html>";
			PrintWriter writer = resp.getWriter();
			writer.println(html2);
		}

	}
}

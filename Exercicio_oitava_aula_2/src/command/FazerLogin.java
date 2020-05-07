package command;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;
import utils.Log;
import java.util.Date;
public class FazerLogin implements Command {

	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("username");
		String senha = request.getParameter("passwd");
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(timestamp.getTime());
		
		
		Log log = new Log(); //acesso aos logs de entrada usuario
		/*String Texto = "rastreamento.txt";
		log.abrir(Texto);
		log.escrever(date);
		log.fechar(); */
		
		Usuario usuario = new Usuario();
		usuario.setUsername(nome);
		usuario.setPassword(senha);
		UsuarioService service = new UsuarioService();
		
		if(service.validar(usuario)){
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			System.out.println("Logou "+usuario);
			
			String Texto = "rastreamento.txt";
			log.abrir(Texto);
			String str = "Logou:"+usuario+"data:"+date;
			log.escrever(str);
			log.fechar();
			
		} else {
			System.out.println("Não Logou "+usuario);
			// throw new ServletException("UsuárioeSenhainválidos");
			String Texto = "rastreamento.txt";
			log.abrir(Texto);
			String str = "Não Logou:"+usuario+"data:"+date;
			log.escrever(str);
			log.fechar();
			
			
		}
		response.sendRedirect("index.jsp");
	}

}
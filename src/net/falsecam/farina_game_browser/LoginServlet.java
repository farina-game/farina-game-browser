package net.falsecam.farina_game_browser;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doPost(req, resp);
		String name = (String) req.getParameter("name");
		String host = (String) req.getParameter("host");
		String port = (String) req.getParameter("port");
		
		Game game = new Game(name, host, port);
		
		resp.setContentType("text/plain");
		resp.getWriter().println("key="+game.store());
	}
}

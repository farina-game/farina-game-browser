package net.falsecam.farina_game_browser;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Farina_Game_BrowserServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}

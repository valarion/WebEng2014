package valarionch.lab0.webapp.todo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "*.ToDo" })
public class ToDoHandler extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String s = req.getParameter("s");
		boolean small = (s != null && s.equals("1"));
		PrintWriter out = resp.getWriter();
		
		if (!small) {
			req.getRequestDispatcher("/head1.html").include(req, resp);
			out.print(req.getRequestURI());
			req.getRequestDispatcher("/head2.html").include(req, resp);
		}
		
		InputStream input = getServletContext().getResourceAsStream(req.getRequestURI());
		ToDoFormatter.parse(input, out, req.getParameter("q"));

		if (!small) {
			out.println("</div></body></html>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}

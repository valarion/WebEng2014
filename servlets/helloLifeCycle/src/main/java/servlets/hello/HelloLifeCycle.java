package servlets.hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/hi" })
public class HelloLifeCycle extends HttpServlet {

	private class Tock implements Runnable {
		private int tocks = 0;
		private boolean exit = false;

		@Override
		public void run() {
			while (!exit) {
				tocks++;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	private Tock tock;

	@Override
	public void init() throws ServletException {
		tock = new Tock();
		Thread t = new Thread(tock);
		t.setPriority(1);
		t.start();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String name = req.getParameter("name");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>Hello " + name + "!</title></head>"
				+ "<body><h1>Hello " + name + " (" + tock.tocks
				+ " tocks)!</h1></body></html>");
	}

	@Override
	public void destroy() {
		tock.exit = true;
	}
}

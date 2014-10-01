# Hello World!
This project contains a demonstration of a [HttpServlet](http://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServlet.html) annotated with [@WebServlet](http://docs.oracle.com/javaee/6/api/javax/servlet/annotation/WebServlet.html). 

Deploy your code to a [Jetty](http://www.eclipse.org/jetty/) server with ```gradle jettyEclipseRun```. Then, open the page at [http://localhost:8080/](http://localhost:8080/).

The code is quite easy:
```java
@WebServlet(urlPatterns = { "/" })
public class HelloWorld extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>Hello World!</title></head>"
				+ "<body><h1>Hello World!</h1></body></html>");
	}
}
```

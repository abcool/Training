package com.abcool.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

/**
 * Servlet implementation class CatalogServlet
 */
@WebServlet(urlPatterns="/CatalogServlet",asyncSupported = true)
public class CatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(CatalogServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Name entered: "+request.getParameter("name"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Thread 1
		AsyncContext asyncContext = request.startAsync();
		//Thread 2
		asyncContext.start(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					logger.info("Inside runnable, current Thread: "+ Thread.currentThread().getName());
					processRequest(request, response);
					asyncContext.complete();
				} catch (InterruptedException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		logger.info("Outside Runnable, current Thread: "+ Thread.currentThread().getName());
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String manufacturer = request.getParameter("manufacturer");
		String sku = request.getParameter("sku");
		Catalog.addItem(new CatalogItem(name, manufacturer, sku));
		response.setHeader("Catalog Response Header", "Catalog Item is "+name);
		response.addCookie(new Cookie("CatalogCookie","CatalogCookie"));
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body><table border='solid'>");
		out.println("<tr>"
				+ "<th>Name:</th>"
				+"<th>Manufacturer</th>"
				+"<th>SKU</th>"
				+ "</tr>");
		for(CatalogItem item : Catalog.getItems()) {
			out.println("<tr>"
					+"<td>"
					+item.getName()
					+ "</td>"
					+"<td>"
					+item.getManufacturer()
					+ "</td>"
					+"<td>"
					+item.getSku()
					+ "</td>"
					+ "</tr>");
		}
		out.println("</table></body></html>");
	}

}

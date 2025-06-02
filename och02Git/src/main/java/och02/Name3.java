package och02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Name3
 */
@WebServlet("/Name3")
public class Name3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Name3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		System.out.println("doGet name->"+name);
		System.out.println("doGet addr->"+addr);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>" + name + "님은 "+ addr +"에 사시는 군요</h1><p>");
		//out.printf("이름 : %s<br>", name);
		//out.printf("주소 : %s<br>", addr);
		out.println("</body></html>");
		out.close();
	}
}

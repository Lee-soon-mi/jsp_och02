package och02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GuGu
 */
@WebServlet("/GuGu")
public class GuGu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuGu() {
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
        int num   = Integer.parseInt(request.getParameter("num"));
        
        System.out.println("doPost 구구단  ->" + num);
        
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.printf("<h1>구구단  %s단</h1>", num);
        
        for(int i = 1; i<=9; i++) 
        {
        	// 선생님 버젼
        	out.printf("%d * %d = %d <p>", num, i, (num * i));
        	
        	// 내 버젼
        	//out.printf("%d " + " * " + i + " = " + (num * i) + "<p>", num);
        }
        
		out.println("</body></html>");
		out.close();
	}

}

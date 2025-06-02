package och02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Num
 */
@WebServlet("/Num")
public class Num extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Num() {
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
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		System.out.println("doPost num1->"+num1);
		System.out.println("doPost num2->"+num2);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>연산결과</h1><p>");
		out.printf("덧셈 : %d + %d = %d <p>", num1, num2, (num1+num2));
		out.printf("뺄셈 : %d - %d = %d <p>", num1, num2, (num1-num2));
		out.printf("곱셈 : %d * %d = %d <p>", num1, num2, (num1*num2));
		out.printf("나눗셈 : %d / %d = %d <p>", num1, num2, (num1/num2));
		out.println("</body></html>");
		out.close();
		
		/*
		HW01
		연산결과
		덧셈 : 100 + 2 = 102
		뺄셈 : 100 - 2 = 98
		곱셈 : 100 * 2 = 200
		나눗셈 : 100 / 2 = 50
		*/
	}

}

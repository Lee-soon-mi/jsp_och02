package och02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Movie
 */
@WebServlet("/Movie")
public class Movie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Movie() {
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
        
		// 복수 배열로 request 정보 받을때
        String[] movie = request.getParameterValues("movie");
        
        System.out.println("doPost movie  ->" + movie);
        
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<h1>당신이 좋아하는 영화는?</h1>");
        
        // 체크박스(checkbox) 선택된 배열을 화면에 출력한다.
        for(int i = 0; i<=movie.length; i++) 
        {
        	out.println(movie[i]+"<br>");
        }
        
		out.println("</body></html>");
		out.close();
	}

}

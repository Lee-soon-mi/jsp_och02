package och02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Person
 */
@WebServlet("/Person")
public class Person extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Person() {
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
		
		// 1. POST 요청 파라미터 인코딩 설정 (가장 먼저!)
		request.setCharacterEncoding("UTF-8");
		
		// 2. 응답 컨텐츠 타입 및 문자 인코딩 설정
		response.setContentType("text/html;charset=UTF-8");
		
		/*
		 * HW02
		 */
		// 3. 파라미터 가져오기 및 null 처리
		String name   	= request.getParameter("name");
		String id   	= request.getParameter("id");
		String password = request.getParameter("password");
		String gender   = request.getParameter("gender");
		//String notice   = request.getParameter("notice");
		String job   	= request.getParameter("job");
		
		// 복수 배열로 request 정보 받을때
        String[] notice = request.getParameterValues("notice");
        
        System.out.println("doPost name	  ->" + name);
        System.out.println("doPost id  ->" + id);
        System.out.println("doPost password  ->" + password);
        System.out.println("doPost gender  ->" + gender);
        System.out.println("doPost notice  ->" + notice);
        System.out.println("doPost job  ->" + job);
        
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<h1>개인정보</h1><p>");
        
        out.println("이름 : " + name + " <br>");
        out.println("아이디 : " + id + " <br>");
        out.println("암호 : " + password + " <br>");
        out.println("성별 : " + gender + " <br>");
        out.print("수신메일 : ");
        
        // 체크박스(checkbox) 선택된 배열을 화면에 출력한다.
	    if(notice != null) {
        	for(int i = 0; i< notice.length; i++) //주의: ArrayIndexOutOfBoundsException
	        {
	        	out.print(notice[i]+" ");
	        } 
	    } else out.print("없음");
        
        out.println("<br>");
        
        //out.println("수신메일 : " + notice + " <br>");
        out.println("직업 : " + job + " <br>");
		out.println("</body></html>");
		out.close();
		
		/*
		개인정보
		이름 : 김유신3
		아이디 : bb
		암호 : 1
		성별 : 남자
		수신메일 : 공지 배송
		직업 : 장군
		*/
	}

}

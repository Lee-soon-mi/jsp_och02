package och02;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Board
 */
@WebServlet("/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
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
		// 1. 응답 컨텐츠 타입 및 문자 인코딩 설정 (매우 중요!)
        //    PrintWriter를 얻기 전에 호출해야 합니다.
        response.setContentType("text/html;charset=UTF-8");
        
        String title   = request.getParameter("title");
        String writer  = request.getParameter("writer");
        String content = request.getParameter("content");
        
        /*
        // 1. 원하는 시간대(TimeZone)를 설정합니다. 예: 한국 표준시(KST)
        ZoneId kstZoneId = ZoneId.of("Asia/Seoul");

        // 2. 현재 시간을 해당 시간대 기준으로 가져옵니다.
        ZonedDateTime nowInKst = ZonedDateTime.now(kstZoneId);
        
        // 3. 출력하고자 하는 날짜 형식을 정의합니다.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

        // 4. 현재 시간을 정의된 형식으로 변환합니다.
        String formattedDateTime = nowInKst.format(formatter);
        */
        
        // 기존 4단계를 한 줄의 코드로 압축 (가독성을 위해 여러 줄로 표시 가능)
        String formattedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"))
                .format(DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH));
        
        // 한국 표준시(KST, Asia/Seoul)를 기준으로 현재 시간을 가져와 요청하신 형식으로 변환합니다.
        String krformattedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"))
                                             .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // 유효성 검사
        /*
		 * if (numStr == null || numStr.trim().isEmpty()) {
		 * System.err.println("'num' 파라미터가 누락되었거나 비어있습니다.");
		 * out.println("<html><body><h1>오류</h1><p>'num' 파라미터가 필요합니다.</p></body></html>"
		 * ); out.close(); return; // 처리를 중단합니다. }
		 */
        
        System.out.println("doPost title  ->"+title);
		System.out.println("doPost writer ->"+writer);
		System.out.println("doPost content->"+content);
		
		// browser에 Display 하기 위한 방법
		// browser에 상세내용을 보여줌
		PrintWriter out = response.getWriter();
		
		// browser html 적용
		// 선생님 버젼 : printf -> println으로 사용했음.
		out.println("<html><body>");
		out.println("<h1>게시판</h1>");
		out.printf("<h1>제목  : %s</h1>", title);
		out.printf("<h1>작성자 : %s</h1>", writer);
		
		// ChatGPT 버전
		out.printf("<h1>작성일 : %s</h1>", formattedDateTime
				  +"<p>("+krformattedDateTime+")");
		// 선생님 버젼
		// out.printf("<h1>작성일 : %s</h1>", new Date());
		
		// <pre> 바뀐 text 내용을 그대로 보여주기 위한 태그, 줄바꿈도 그대로 적용된다.
		out.printf("<h1>내용  : <pre> %s", content+"</pre></h1>");
		out.printf("<h1>잘 합시다</h1>");
		out.println("</body></html>");
		out.close();
		
		/*----------------------------------------------
		 결과
		----------------------------------------------
		게시판
		제목 : 투표
		작성자 : 국민
		작성일 : Mon May 19 16:37:56 KST 2025
		내용
		잘 합시다
		----------------------------------------------*/
	}
}

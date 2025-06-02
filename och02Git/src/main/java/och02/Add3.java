package och02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * servlet Java 파일 클래스 생성 방법
 * och02>Java Resources>src/main/java 오른쪽 클릭>New>Servlet 선택
 * - Java package : och02
 * - Class Name : 예) Add3
 * Next>Next>Finish 클릭
 */

/**
 * Servlet implementation class Add3
 */
//annotation:어노테이션(주소값) 
@WebServlet("/Add3")	// servlet와 serlet-mapping 대체
public class Add3 extends HttpServlet {	// extends HttpServlet (상속)
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {	// 생성자
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // method="get" 방식이면 doGet을 사용하여 request, response를 통해 데이터 전송
    // 톰캣을 통해 port(8181) 프로그램을 찾는다.
    // request에 parameter정보를 담아서 정보를 사용한다.(key:value 형태) ==>(문자를 parsing하여 숫자 변환
	protected void doGet(HttpServletRequest request, 
						  HttpServletResponse response // javax.serlvet.http.HttpServletResponse 인터페이스 타입
			) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet Start....");
		
		// 1. 응답 컨텐츠 타입 및 문자 인코딩 설정 (매우 중요!)
        //    PrintWriter를 얻기 전에 호출해야 합니다.
        response.setContentType("text/html;charset=UTF-8");
		
		//num은 문자열 get방식 String->형변환 Integer로 parsing한다.
		int num    = Integer.parseInt(request.getParameter("num"));
		String han = request.getParameter("han");
		
		// 유효성 검사
		/*
		 * if (numStr == null || numStr.trim().isEmpty()) {
		 * System.err.println("'num' 파라미터가 누락되었거나 비어있습니다.");
		 * out.println("<html><body><h1>오류</h1><p>'num' 파라미터가 필요합니다.</p></body></html>"
		 * ); out.close(); return; // 처리를 중단합니다. }
		 */
		
		System.out.println("doGet num->"+num);
		System.out.println("doGet han->"+han);
		
		// num의 누적분을 return 목표
		int sum = 0;
		for(int i=1; i <= num; i++) {
			sum += i;
		}
		
		// browser에 Display 하기 위한 방법
		// browser에 상세내용을 보여줌
		// getWriter라는 메서드를 호출해서 PrintWriter 객체를 구한다
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		//out.println("<h1>1부터 "+num+"까지 합계</h1>");
		out.printf("<h1>han Test : %s</h1>", han);
		out.printf("<h1>1부터 %d까지 합계</h1>", num);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub doGet(request, response); }
	 */
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    // method="get" 방식이면 doGet을 사용하여 request, response를 통해 데이터 전송
    // 톰캣을 통해 port(8181) 프로그램을 찾는다.
    // request에 parameter정보를 담아서 정보를 사용한다.(key:value 형태) ==>(문자를 parsing하여 숫자 변환
	
	
	// 1. parameter들이 request 담아 온다.
	// 2. 서블릿에서 parameter를 받아올 수 있게 request.getParameter 제공한다.
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doPost Start....");
		
		// 1. 응답 컨텐츠 타입 및 문자 인코딩 설정 (매우 중요!)
        //    PrintWriter를 얻기 전에 호출해야 합니다.
		//    HTML을 출력하는 print, println, printf 메서드 호출문보다 앞에 와야 할 뿐만 아니라, 
		//    response.getWriter 메서드 호출문보다도 먼저 와야 함
		// 설명 : html 문법으로 작성된 text이고, UTF-8 문자셋으로 인코딩 되어있음.
        response.setContentType("text/html;charset=UTF-8");
		
		//num은 문자열 get방식 String->형변환 Integer로 parsing한다.
		int num = Integer.parseInt(request.getParameter("num"));
		String han = request.getParameter("han");
		
		// 1-1. 유효성 검사
		/*
		 * if (numStr == null || numStr.trim().isEmpty()) {
		 * System.err.println("'num' 파라미터가 누락되었거나 비어있습니다.");
		 * out.println("<html><body><h1>오류</h1><p>'num' 파라미터가 필요합니다.</p></body></html>"
		 * ); out.close(); return; // 처리를 중단합니다. }
		 */
		
		// 2. request getParameter 결과 출력
		System.out.println("doPost num->"+num);
		System.out.println("doPost han->"+han);
		
		// 3. 합계(sum) for문 통한 누적분을 return 할 결과 작성
		// - num의 누적분을 return 목표
		int sum = 0;
		for(int i=1; i <= num; i++) {
			sum += i;
		}
		
		// 4. browser에 Display 하기 위한 방법
		// - browser에 상세내용을 보여줌
		
		/*
		 * Java Servlet 환경에서 서버가 클라이언트(주로 웹 브라우저)에게 
		 * 텍스트 기반의 응답 데이터를 전송하기 위한 핵심적인 구문 
		 * 1. response 객체 : 서블릿이 클라이언트의 HTTP 요청에 대한 응답을 생성하고 전송하는 데 
		 *                사용되는 모든 기능을 캡슐화합니다. (화면에 보여주기 위한 객체)
		 *                (응답 상태 코드, 응답 헤더, 응답 본문(body)을 설정하는 데 사용)
		 * 2. .getWriter() 메소드 : HttpServletResponse 객체의 이 메소드는 
		 *                클라이언트에게 문자 데이터를 전송할 수 있는 java.io.PrintWriter 객체를 반환합니다.
		 *                이 메소드를 호출하면, 서블릿 컨테이너는 응답 본문을 문자 스트림으로 처리할 준비를 합니다.
		 * 3. PrintWriter out 객체: PrintWriter는 다양한 print(), println(), printf() 메소드를 제공하여 
		 *                Java의 기본 데이터 타입(int, float, boolean 등) 및 객체를 편리하게 문자열 형태로 변환하여
		 *                출력 스트림으로 보낼 수 있게 해주는 클래스입니다.      
		 *                개발자는 이 out 객체를 사용하여 동적으로 생성된 HTML, XML, JSON, 일반 텍스트 등의 
		 *                문자열 데이터를 클라이언트에게 전송할 응답 본문에 기록합니다. 
		 *                예를 들어, out.println("<html><body><h1>안녕하세요!</h1></body></html>"); 와
		 *                같이 HTML 코드를 작성하여 클라이언트 브라우저가 렌더링할 수 있도록 합니다.  
		 *                (PrintWriter를 통해 브라우저 화면에 보여주기 위한 객체가 된다.) 
		 *                
		 * 4. 요약 
		 * 	PrintWriter out = response.getWriter();는 java 웹 애플리케이션(서블릿/JSP)에서 서버가 
		 *  클라이언트에게 동적인 텍스트 콘텐츠(주로 HTML)를 HTTP 응답 본문으로 전송하기 위한 표준적이고 필수적인 방법입니다. 개발자는 이 out 객체를 사용하여 클라이언트가 보게 될 최종 화면을 프로그래밍 방식으로 구성하게 됩니다.              
		 */
		
		// getWriter()라는 메서드를 호출해서 PrintWriter 객체를 구한다.
		// Response.getWriter메서드가 리턴하는 PrintWriter 객체는 파일이 아니라 웹 브라우저로 데이터를 출력한다. 
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		//out.println("<h1>1부터 "+num+"까지 합계</h1>");
		out.printf("<h1>han Test : %s</h1>", han);	
		out.printf("<h1>1부터 %d까지 합계</h1>", num);
		out.println(sum);
		out.println("</body></html>");
		
		/*
		 * 일반적인 서블릿의 doGet() 또는 doPost() 메소드 내에서 response.getWriter()로 얻은 PrintWriter에 대해 
		 * out.close();를 명시적으로 호출하는 것이 항상 필수는 아닙니다. 
		 * 하지만 여전히 많은 개발자들이 호출하며, 그 이유와 장단점이 있습니다.
		 * 
		 * 1. 서블릿 컨테이너의 역할 (명시적 호출이 필수가 아닌 이유):
		 * 1-1. 자동 리소스 관리: 서블릿 컨테이너(예: Tomcat, Jetty 등)는 서블릿의 생명주기를 관리하며, 
		 *      HTTP 요청 처리가 완료된 후 응답(response) 객체와 관련된 리소스를 정리할 책임이 있습니다.
		 * 1-2. 스트림 자동 닫기: Jakarta Servlet 스펙에 따르면, 서블릿의 service 메소드(또는 doGet/doPost)가
		 *      실행을 마치면 서블릿 컨테이너는 응답 객체의 Writer (또는 OutputStream)에 대해 close() 메소드를 호출하도록
		 *      되어 있습니다. 즉, 개발자가 명시적으로 out.close()를 호출하지 않아도 컨테이너가 알아서 스트림을 닫아줍니다.
		 * 
		 * > 포인트 : 명시적 close하지 않아도 컨테이너가 알아서 스트림을 닫아준다.
		 * 
		 * 2. out.close();를 호출하는 이유 (권장되는 경우 또는 습관):
		 * 2-1. 데이터 플러시(Flush) 보장: close() 메소드는 내부적으로 flush()를 호출합니다. 
		 * 		PrintWriter는 버퍼링 기능을 사용하므로, out.print()나 out.println()으로 작성한 내용이 즉시 클라이언트로 
		 * 		전송되지 않고 버퍼에 쌓일 수 있습니다. close() (또는 flush())를 호출하면 버퍼에 남아있는 
		 *      모든 데이터가 강제로 클라이언트에 전송됨을 보장할 수 있습니다.
		 * 		(물론, 컨테이너가 닫을 때도 플러시는 이루어집니다.)
		 * 2-2. 명시적인 리소스 관리: 일반적인 Java I/O 프로그래밍에서는 사용한 스트림을 명시적으로 닫는 것이 좋은 습관으로 간주됩니다. 
		 * 		이는 리소스 누수를 방지하고 코드의 의도를 명확하게 합니다. 
		 *      이러한 관점에서 out.close()를 호출하는 것은 일관성을 유지하는 데 도움이 됩니다.
		 * 2-3. 일부 오래된 관행 또는 특정 상황: 과거에는 컨테이너의 동작을 전적으로 신뢰하기보다 명시적으로 닫는 것을 
		 *      선호하는 경향이 있었을 수 있습니다. 또는 PrintWriter가 다른 리소스를 래핑(wrapping)하고 있고, 
		 *      그 내부 리소스의 즉각적인 해제가 필요한 매우 특수한 경우에는 close() 호출이 중요할 수 있습니다 
		 *      (단, response.getWriter()의 경우는 일반적이지 않음).
		 * 
		 * > 포인트 : 리소스 누수를 방지하고 코드의 의도를 명확하게 하거나 리소스의 즉각적인 해제가 필요한 경우 필요하겠어요.
		 *      
		 * 3. out.close();를 호출할 때 주의할 점 (호출하지 않는 것이 더 나을 수 있는 경우):
		 * 3-1. 필터(Filter) 체인과의 상호작용: 서블릿 이후에 응답을 추가적으로 가공하거나 로깅하는 필터가 있다면, 
		 *      서블릿에서 out.close()를 호출하여 스트림을 닫아버리면 해당 필터가 더 이상 응답에 쓸 수 없게 됩니다. 
		 *      이런 경우, 스트림의 최종적인 닫기는 필터 체인의 마지막 단계나 서블릿 컨테이너에 맡기는 것이 더 적절합니다. 
		 *      (단, 대부분의 경우 서블릿은 응답을 최종적으로 생성하는 주체입니다.)
		 * 3-2. 서블릿 컨테이너에 위임: 이미 컨테이너가 잘 처리해주는 부분에 대해 중복으로 코드를 작성하는 것으로 볼 수도 있습니다.
		 *
		 * > 포인트 : 업무의 복잡도에 의해 연계되어 있는 경우라면 경우에 따라서는 명시적 호출이 권장되지 않는다는 것에
		 *          논리적인 설득력이 있는 내용입니다. 업무의 특성을 고려할 부분이 있을 것으로 판단됩니다.
		 * */
		out.close();
	}

}

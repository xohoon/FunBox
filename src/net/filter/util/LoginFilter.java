package net.filter.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//자식객체로 형변환 한다음
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		//세션 객체를 얻어온다.
		HttpSession session=httpRequest.getSession();
		//로그인 했는지 아닌지에 대한 여부
		boolean isLogin=false;
		
		if(session!=null){
			//세션에서 id 라는 키값을 읽어와 본다.
			String id=(String)session.getAttribute("id");
			//만일 id 값이 null 이 아니라면 로그인한 상태이다.
			if(id!=null)
				isLogin=true;
		}
		if(isLogin){
			//로그인 된 경우에는 요청된 작업을 계속한다.
			chain.doFilter(request, response);
		}else{
			//로그인 하지 않은 경우
			//ServletResponse 객체를 자식 객체로 형변환 한다음
			//안내페이지 혹은 login 페이지로 강제 이동시킨다.
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인이 필요한 서비스 입니다.'); location.href='./LoginPage.mb';</script>");
			out.flush();
			//httpResponse.sendRedirect("./LoginPage.mb");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}

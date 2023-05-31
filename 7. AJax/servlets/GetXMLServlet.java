package com.zerock.myweb.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;



@Log4j
@NoArgsConstructor
@WebServlet("/GetXML")
public class GetXMLServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	private ServletContext context;
	


	public void init(ServletConfig config) throws ServletException {
		log.info("init(config) invoked.");

		this.context = config.getServletContext();
		
		log.info("\t+ config:" + config);
		log.info("\t+ context:" + context);
	} // init

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log.info("service(req, res) invoked.");
		
		res.setCharacterEncoding("utf8");		// 다국어 문자가 포함되어 있다면 반드시 넣어줘야 함 (*중요*)
		res.setContentType("application/xml");
		res.setHeader("Accept-Ranges", "bytes");
		
		// 이 헤더는, AJax의 동일출처원칙(CORS) 위배를 허용사이트 사이트 주소를 기재해주는 역할을 함
		// 이 헤더는 오직 하나의 값만 허용
//		res.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");	// OK only for this site, http://127.0.0.1:5500
		res.setHeader("Access-Control-Allow-Origin", "*");			// OK for all sites
//		res.setHeader("Access-Control-Allow-Origin", "http://localhost:5500");	// XX : Not allowed, only once allowed
		
		res.setHeader("Access-Control-Allow-Methods", "*");
		
		PrintWriter out = res.getWriter();
		
		try (
			InputStream is = this.context.getResourceAsStream("/WEB-INF/persons.xml");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		) {
			// 이 헤더는 넣지 않아야 함. 넣으면, 클라이언트 브라우저가 20초동안 기다린 후 끊어짐
//			int contentLength = is.available();
//			res.setHeader("Content-Length", String.valueOf(contentLength));		// XX : Side Effect
			
			String line;
			
			while((line = br.readLine()) != null) {
				out.print(line);
			} // while
		} // try-with-resources
		
		out.flush();
		out.close();
	} // service

} // end class

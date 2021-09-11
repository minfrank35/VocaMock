package com.tvtcenter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestControl
 */
@WebServlet("/test.do/*")
public class TestControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int numberOfTest = 0;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
request.setCharacterEncoding("utf-8");
		
		LoginDAO ldao = (LoginDAO) getServletContext().getAttribute("ldao");
		
		HttpSession session = null;
		String viewname = null;
		ArrayList<QuestionDO> questions = null;
		int qid = 0;
		
		String pathInfo = request.getPathInfo();
		int reqPage = 0;
		if(pathInfo != null) {
				switch(pathInfo) {
					case "/1":
						numberOfTest = Integer.parseInt(request.getParameter("numberOfTest"));
						session = request.getSession(false);
						if (session == null) {
							viewname = "redirect:/Home.jsp";
							break;
						
						}
						session.setAttribute(
								"test_store", new HashMap<String, Integer>());		
						questions = new ArrayList<QuestionDO>();
						qid = 1 * 3 - 2;
					try {
						questions.add(ldao.getQuestion(qid,numberOfTest));
						questions.add(ldao.getQuestion(qid+1,numberOfTest));
						questions.add(ldao.getQuestion(qid+2,numberOfTest));
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
						
						request.setAttribute("questions", questions);
						request.setAttribute("reqpage", 1);
						request.setAttribute("id", session.getAttribute("id"));
						
						viewname = "/test_page.jsp";

						break;
					case "/2":
					case "/3":
					case "/4":
					case "/5": 
					case "/6":
						session = request.getSession(false);
						if (session == null) {
							viewname = "redirect:/Home.jsp";
							break;
						
						}
						if(pathInfo.equals("/2")) reqPage = 2;
						else if(pathInfo.equals("/3")) reqPage = 3;
						else if(pathInfo.equals("/4")) reqPage = 4;
						else if(pathInfo.equals("/5")) reqPage = 5;
						else if(pathInfo.equals("/6")) reqPage = 6;

						int qnum = (reqPage-1) * 3 - 2;
						String q1Str = "q" + (qnum);
						String q2Str = "q" + (qnum+1);
						String q3Str = "q" + (qnum+2);

						System.out.println(q1Str);
						int q1 = Integer.parseInt(request.getParameter(q1Str));
						int q2 = Integer.parseInt(request.getParameter(q2Str));
						int q3 = Integer.parseInt(request.getParameter(q3Str));
						
						Map<String,Integer> testStore = 
								(Map<String,Integer>)session.getAttribute("test_store");
							if (testStore == null) {
								viewname = "redirect:/Home.jsp";
								break;
							}
							testStore.put(q1Str, q1);
							testStore.put(q2Str, q2);
							testStore.put(q3Str, q3);
						
						if (reqPage == 6) {		// request result page
							TestEvaluationService service = new TestEvaluationService();
							TestResultDO result = service.evaluate(testStore);
							result.setId((String)session.getAttribute("id"));
							result.setNumber(numberOfTest);

							try {
								ldao.insertScore(result);
							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							request.setAttribute("result", result);
							
							viewname="/score_result.jsp";
							
							session.invalidate();
						}
						else {
							questions = new ArrayList<QuestionDO>();
							qid = reqPage * 3 - 2;
							try {
								questions.add(ldao.getQuestion(qid,numberOfTest));
								questions.add(ldao.getQuestion(qid+1,numberOfTest));
								questions.add(ldao.getQuestion(qid+2,numberOfTest));

							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							request.setAttribute("questions", questions);
							request.setAttribute("reqpage", reqPage);
							request.setAttribute("id", session.getAttribute("id"));
							
							viewname = "/test_page.jsp";
						}
						break;

					}
			}
		
			
		if(viewname != null) {
			if(viewname.contains("redirect:")) {
				String location = viewname.split(":")[1];
				response.sendRedirect(request.getContextPath() + location);
			}
			else{
			RequestDispatcher view = request.getRequestDispatcher(viewname);
			view.forward(request, response);
			}
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}

package com.tvtcenter;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/login.do/*")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String pathInfo = request.getPathInfo();
		LoginDAO ldao = (LoginDAO) getServletContext().getAttribute("ldao");
		LoginDO ldo = null;
		
		HttpSession session = null;
		String viewname = null;
		List<TestResultDO> scorelist = null;

		TestResultDO rdo = null;

		
		if(pathInfo != null && pathInfo.length() > 1) {
			switch(pathInfo) {
			
				case "/login" :
				{
					ldo = new LoginDO();
					String vocaId = request.getParameter("vocaId");
					String vocaPw = request.getParameter("vocaPw");
					
					try {
						ldo = ldao.getLoginData(vocaId);
							
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(vocaId.equals(ldo.getId()) && vocaPw.equals(ldo.getPassword())) {
						System.out.println("아이디 비번 일치");
						session = request.getSession();
						
						if(session.isNew()) {
							viewname="/Home.jsp";
							session.setAttribute("id", vocaId);
						}
						else {
							String sid = (String)session.getAttribute("id");
							if (sid != null && sid.equals(vocaId)) {
								viewname="/Home.jsp";
							}
							else {
								System.out.println("invalidate");
								session.invalidate();
								viewname = "redirect:/start_login.jsp";
							}
						}
						
					}
					break;
				}
			
			
				case "/join" :{

					String joinId = request.getParameter("joinId");
					String joinPw = request.getParameter("joinPw");
					String joinPwCheck = request.getParameter("joinPwCheck");
					String joinName = request.getParameter("joinName");
					String joinBirth = request.getParameter("joinBirth");
					String joinEmail = request.getParameter("joinEmail");
					String joinRole = "회원";
					
					if(joinPw.equals(joinPwCheck))
					ldo = new LoginDO(joinId,joinPw,joinName,joinBirth,joinEmail,joinRole);
					
					try {
						int result = ldao.insertLoginData(ldo);
						if(result == 1) {
							viewname = "redirect:/Home.jsp";
						}else {
							viewname= "redirect:/join.html";
						}
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				
				case "/mypage" :
				{
					session = request.getSession(false);
					if (session == null) {
						viewname = "redirect:/Home.jsp";
						break;
						
					}
					
					String id = (String) session.getAttribute("id");
					if(id != null) {
						try {
							scorelist = ldao.getScoreDatas(id);
							request.setAttribute("scorelist", scorelist);
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						viewname="/mypage.jsp";

					}
					else {
						viewname="redirect:/Home.jsp";
					}
					
					break;
				}
			}
		}
		//Output
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

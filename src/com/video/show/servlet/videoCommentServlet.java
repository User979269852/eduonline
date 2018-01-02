package com.video.show.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.show.service.showVideoService;
import com.video.show.service.impl.showVideoServiceImpl;

/**
 * Servlet implementation class videoCommentServlet
 */
@WebServlet("/tijiao")
public class videoCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public videoCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//��ȡ�û���
		Object tempObj =  request.getSession().getAttribute("name");
		String name=(String)tempObj;
	
		showVideoService service=new showVideoServiceImpl();
		
		//ͨ���û����ҵ��û�id
		int id=service.findIdByName(name);
		String str1= request.getParameter("pid");
		
		//����shibian
		int shibian=Integer.parseInt(str1);
		
		if(tempObj==null||tempObj==""){
			try {
				response.sendRedirect("Login.jsp");
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				response.sendRedirect("playvideo?shibian="+shibian);
			}
			
		}else{
		
		//�������۵�����
		String text= request.getParameter("text");
		
        //ִ��insert�����
		int result=service.insertComment(id,shibian,text);
		
		//��ִ�н�������жϣ���Ϊ0��insert�ɹ�
		if(result!=0){
			response.sendRedirect("playvideo?shibian="+shibian);
		}else{
			
			System.out.println("���۳ɰ�");
			
		}
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

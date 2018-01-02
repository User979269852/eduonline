package com.video.play.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.tb_shiping;
import com.untils.pingjia;
import com.video.play.service.showPlayService;
import com.video.play.service.impl.showPlayServiceImpl;


/**
 * Servlet implementation class showVideoByidServlet
 */
@WebServlet("/playvideo")
public class showVideoByidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public showVideoByidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String shibian=request.getParameter("shibian");
		int id=Integer.parseInt(shibian);
		// ��ȡ��½�û���Ϣ
				Object tempObj =  request.getSession().getAttribute("name");
				if(tempObj == null){
					response.sendRedirect("Login.jsp");
					return;
				}
				String userinfo = (String)tempObj;
				
				
		showPlayService service=new showPlayServiceImpl();
		
		//�ж��Ƿ��Ѿ��ղ�
		int isboolean=service.isShoucang(userinfo,shibian);
	  //	List<tb_shiping> list=service.findAllVodeoByid(id);
		
		//���Ҫ���ŵ���Ƶ������
		List<tb_shiping> videolist=service.findVodeoByid(id);
		System.out.println(videolist.get(0).getVideo());
		  request.setAttribute("videolist", videolist.get(0));
		
		//��ø���Ƶ�ĸ���������Ϣ
		  List<pingjia> pingjialist=null;
		  try {
			   pingjialist=service.findPingJiaByid(id);
			} catch (IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				request.setAttribute("pingjialist", null);
			}
		
		
		
		
		//request.getSession().setAttribute("list", list);
		//response.sendRedirect("main.jsp");
		
		  request.setAttribute("pingjialist", pingjialist);
		  request.setAttribute("isboolean", isboolean);
		  
		  System.out.println("--------------------------------------"+isboolean+"------------------------------------------");
          request.getRequestDispatcher("video.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
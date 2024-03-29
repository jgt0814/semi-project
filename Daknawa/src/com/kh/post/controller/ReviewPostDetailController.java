package com.kh.post.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.Attachment;
import com.kh.post.model.service.PostService;
import com.kh.post.model.vo.Post;

/**
 * Servlet implementation class ReviewBoardDetailController
 */
@WebServlet("/rdetail.bo")
public class ReviewPostDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewPostDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int postNo = Integer.parseInt(request.getParameter("pno"));

		PostService pService = new PostService();

		// 조회수 증가
		int result = pService.increaseCount(postNo);

		System.out.println("조회수 증가 결과 : " + result);
		// 게시글 상세 조회
		if(result > 0) {

			Post p = pService.selectPost(postNo);

			ArrayList<Attachment> atList = new PostService().selectAttachmentList(postNo);

			System.out.println("게시글 상세 조회 결과 : " + p);
			System.out.println("게시글 상세 조회 결과 : " + atList);

			request.setAttribute("p", p);
			request.setAttribute("at", atList);
			request.getRequestDispatcher("views/post/reviewPostDetailView.jsp").forward(request, response);

		} else {
			request.setAttribute("errorMsg", "게시글 상세 조회에 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}



		request.getRequestDispatcher("views/post/reviewPostDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

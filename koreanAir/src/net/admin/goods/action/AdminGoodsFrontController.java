package net.admin.goods.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminGoodsFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// 관리자
		// 상품등록화면  http://localhost/Model2/GoodsAdd.ag
		// 상품목록     http://localhost/Model2/GoodsList.ag
		
		// 가상주소 가져오기
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		// 가상주소 비교하기
		Action action = null;
		ActionForward forward = null;
		if (command.equals("GoodsAdd.ag")) {
			// ./admingoods/admin_goods_write.jsp
			forward = new ActionForward();
			forward.setPath("./admingoods/admin_goods_write.jsp");
			forward.setRedirect(false);
		} else if (command.equals("GoodsAddAction.ag")) {
			action = new GoodsAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("GoodsList.ag")) {
			action = new AdminGoodsListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  else if (command.equals("GoodsModify.ag")) {
			action = new AdminGoodsModifyForm();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("GoodsModifyAction.ag")) {
			action = new GoodsModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("GoodsDelete.ag")) {
			action = new GoodsDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		// 이동
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher
					= request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		} // 이동 끝
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
}

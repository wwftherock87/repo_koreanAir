package net.admin.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.goods.db.AdminGoodsDao;


public class GoodsDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminGoodsDeleteAction");
		
		// int num 가져오기
		int num = Integer.parseInt((request.getParameter("num")));
		// db객체 생성 agdao
		AdminGoodsDao agdao = new AdminGoodsDao();
		// 메소드 호출 deleteGoods(num)
		agdao.deleteGoods(num);
		
		
		// 이동 ./GoodsList.ag
		ActionForward forward = new ActionForward();
		forward.setPath("./GoodsList.ag");
		forward.setRedirect(true);
		return forward;
	}
}
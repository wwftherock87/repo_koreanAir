package net.admin.goods.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.goods.db.AdminGoodsDao;
import net.admin.goods.db.GoodsBean;

public class AdminGoodsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminGoodsListAction");
		
		// DB객체 생성  agdao
		AdminGoodsDao agdao = new AdminGoodsDao();
		// List goodsList = 메소드호출  getGoodsList
		List<GoodsBean> goodsList = agdao.getGoodsList();
		// 저장  goodsList
		request.setAttribute("goodsList", goodsList);
		// 이동   ./admingoods/admin_goods_list.jsp
		ActionForward forward = new ActionForward();
		forward.setPath("./admingoods/admin_goods_list.jsp");
		forward.setRedirect(false);
		return forward;
	}

}

package net.admin.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.admin.goods.db.AdminGoodsDao;
import net.admin.goods.db.GoodsBean;

public class GoodsAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GoodsAddAction");
		
		// request   upload   5*1024*1024  "utf-8"
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println("업로드 실제 주소: " + realPath);
		
		int maxSize = 5 * 1024 * 1024;
		// DefaultFileRenamePolicy
		
		// 파일업로드   MultipartRequest multi
		MultipartRequest multi = new MultipartRequest(
				request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		// 자바빈 파일 만들기   net.admin.goods.db.GoodsBean
		// 자바빈 객체 생성
		GoodsBean goodsbean = new GoodsBean();
		// multi => 자바빈 멤버변수 저장
		goodsbean.setAmount(Integer.parseInt(multi.getParameter("amount")));
		goodsbean.setBest(0); // 처음 상품등록 시 인기상품 아님 0
		goodsbean.setCategory(multi.getParameter("category"));
		goodsbean.setContent(multi.getParameter("content"));
		goodsbean.setColor(multi.getParameter("color"));
		goodsbean.setName(multi.getParameter("name"));
		goodsbean.setPrice(Integer.parseInt(multi.getParameter("price")));
		goodsbean.setSize(multi.getParameter("size"));
		String image = multi.getFilesystemName("file1") + ","
				+ multi.getFilesystemName("file2") + ","
				+ multi.getFilesystemName("file3") + ","
				+ multi.getFilesystemName("file4");
		System.out.println("파일이름: " + image);
		goodsbean.setImage(image);
		
		// DB파일 만들기  net.admin.goods.db.AdminGoodsDao
		// 객체생성  agdao
		AdminGoodsDao agdao = new AdminGoodsDao();
		// 메소드 호출   insertGoods(goodsbean)
		agdao.insertGoods(goodsbean);
		// 이동  ./GoodsList.ag
		ActionForward forward = new ActionForward();
		forward.setPath("./GoodsList.ag");
		forward.setRedirect(true);
		return forward;
	}

}





package net.admin.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// 추상메소드 정의
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
}

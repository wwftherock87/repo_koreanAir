package net.admin.goods.action;

public class ActionForward {
	// false: forward방식 이동.  true: redirect방식 이동.
	private boolean isRedirect;  // 이동방식
	private String path;        // 이동할 주소
	
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}

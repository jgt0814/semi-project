package com.kh.common.model.vo;
public class PageInfo {
    private int listCount;      // 총 게시글 갯수
    private int currentPage;    // 현재 페이지
    private int pageLimit;          // 한 페이지에 보여질 게시글 갯수
    private int postLimit;     // 한 페이지에 보여질 게시글 갯수
    private int maxPage;        // 전체 페이지에서 가장 마지막 페이지
    private int startPage;      // 한 번에 표시될 페이지가 시작할 페이지
    private int endPage;        // 한 번에 표시될 페이지가 끝나는 페이지
    public PageInfo() {
    }
	public PageInfo(int listCount, int currentPage, int pageLimit, int postLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.postLimit = postLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageLimit() {
		return pageLimit;
	}
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
	public int getPostLimit() {
		return postLimit;
	}
	public void setPostLimit(int postLimit) {
		this.postLimit = postLimit;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "PageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", postLimit=" + postLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
}








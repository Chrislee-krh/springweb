package org.zerock.board.command;

public class PageVO {
	// 1. total: 게시판 글 전체 수
	// 2. realend 게시판의 실제 마지막 페이지 번호
	// 3. endPage: 게시판 화면에 보여질 마지막 페이지 번호
	// 4. startPage:게시판 화면에 보여질 첫 페이지 번호
	// 5. prev: 이전 페이지 버튼 활성화 여부
	// 6. next: 이후 페이지 버튼 활성화 여부
	
	private int startPage;
	private int endPage;
	private boolean prev, next;	
	private int total;
	private Criteria cri;
	
	//필드 생성자, 기본 생성자 x
	public PageVO(Criteria cri, int total) {
		this.total = total;
		this.cri = cri;
		
		//endPage
		//공식: (int)Math.ceil(페이지번호/(double)한 번에 보여질 페이지 수)* 한번에 보여질 페이지 수
		this.endPage = (int)Math.ceil((cri.getPageNum()/(double)10)*10);
		//startPage
		//공식: endPage - 한 번에 보여질 페이지 개수 +1
		this.startPage = endPage-10+1;
		//realEnd: endPage보다 실제 페이지의 끝 번호가 큰 경우, 작은 경우(endPage = realEnd)
		int realEnd = (int)Math.ceil(total/(double)cri.getCount());
		
		if(this.endPage>realEnd) {
			this.endPage=realEnd;
		}
		
		//이전 버튼
		this.prev = this.startPage >1; //활성화 조건
		//다음 버튼
		this.next = realEnd>this.endPage; //활성화 조건
		
		System.out.println("[endPage]: "+endPage);
		System.out.println("[startPage]: "+startPage);
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

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
}

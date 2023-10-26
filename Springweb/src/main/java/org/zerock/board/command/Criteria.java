package org.zerock.board.command;

public class Criteria {
	// 페이지당 게시글 수의 기준
	// mysql, mariadb: select * from tbl_board by num desc limit ?, ?; - ?:시작점, ?:개수
	
	private int pageNum;
	private int count;
	
	public Criteria() {
		//최초 게시판에 진입 시 기본 값 설정. 1번 페이지:10개 게시물
		this.pageNum = 1; //페이지 번호
		this.count = 10;
	}
	
	public Criteria(int pageNum, int count) {
		// 전달된 매개변수를 이용한 페이지 값 출력
		this.pageNum = pageNum;
		this.count = count;
	}

	// 페이지 내 시작 게시글 인덱스(첫 ?에 넣기 위함)
	public int getPageStart() {
		// 1이 들어가면 0부터 2가 들어가면 10부터 시작하는데, db의 rownum은 1부터 시작하니 +1한다.
		return ((pageNum-1)*count)+1; //mysql, mariaDB에서 사용: limit을 사용할 경우
		//오라클에서 두번째 시작 위치를 사용하는 값으로 사용
	}
	
	public int getPageEnd() { //오라클을 위해서 생성
		return pageNum * count;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}

package vo;

public class PageVO {
	
	
	private int blockSize;		// 이전/다음 사이에 몇 페이지를 출력할 것인지 정의하는 변수
	private int perList;		// 한 페이지에 몇 개의 리스트 출력할 것인지 정의하는 변수
	
	private int blockCount;		// 총 블럭 수
	private int currentBlock;	// 현재 블럭
	
	private int totalPage;		// 총 페이지 수
	private int totalList;		// select한 결과값의 총 레코드 수
	private int startIndex;		// 해당 페이지의 첫번째 레코드 순서
	private int endIndex;		// 해당 페이지의 마지막 레코드 순서
	private int startPage;		// 첫 페이지 번호
	private int endPage;		// 끝 페이지 번호
	
	public PageVO() {}
	
	public PageVO(int totalList, int perList) {
		this.perList = perList;
		this.totalList = totalList;
		this.totalPage = (int)(Math.ceil(totalList*1.0/perList));
		this.blockCount = (int)(Math.ceil(totalPage*1.0/blockSize));
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getPerList() {
		return perList;
	}

	public void setPerList(int perList) {
		this.perList = perList;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(int currentBlock) {
		this.currentBlock = currentBlock;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalList() {
		return totalList;
	}

	public void setTotalList(int totalList) {
		this.totalList = totalList;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
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
	
	
}

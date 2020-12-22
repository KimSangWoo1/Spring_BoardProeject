package com.test.myapp.board.util;

public class Pagination {
	// �� �������� �Խñ� �� 
    private int pageSize = 5;
	// �� ��(range)�� ������ �� 
    private int rangeSize = 5;  
    // ���� ������ 
    private int curPage = 1;   
    // ���� ��(range) 
    private int curRange = 1; 
    // �� �Խñ� �� 
    private int listCnt; 
    // �� ������ �� 
    private int pageCnt;
    // �� ��(range) �� 
    private int rangeCnt; 
    // ���� ������ 
    private int startPage = 1;
    // �� ������ 
    private int endPage = 1;
    /// ���� index 
    private int startIndex = 0;

	/// ���� ������ 
    private int prevPage;
    // ���� ������ 
    private int nextPage;
    
    public Pagination () {}
	public Pagination (int listCnt,  int curPage){
    
    	//���� ������
    	this.curPage=curPage;
    	//�� �Խù� ��
    	this.listCnt=listCnt;
    	
    	//1. ��ü ������ ��   ex) ��ü �Խñ� ��/ �������� ������ �Խñ� �� = ��ü ������ ��  
    	this.pageCnt = (int)Math.ceil(listCnt*1.0/pageSize);
    	//2. ��ü �� ��  ex)  ��ü ������ ��/ ������ ������ ����  = ��ü ��� �� 
    	this.rangeCnt  = (int)Math.ceil(pageCnt*1.0/rangeSize);
    //3.��� ���� (range Setting)    		
    	//���� ���  ex)  ((4-1)/5) +1 = 1  
    	this.curRange = (int)((curPage-1)/rangeSize) + 1;
    	//����  ������ = (���� ���-1) * ��� ���� + 1
    	this.startPage = (curRange-1)*rangeSize+1;
    	//�� ������ = ���������� + ��� ���� -1
    	this.endPage = startPage + rangeSize-1;
    	
    	//�� ������ �ȳѵ��� ����
    	if(endPage>pageCnt) {
    		this.endPage =pageCnt;
    	}
    	
    	this.prevPage = curPage -1;
    	this.nextPage = curPage +1;
    	
    	//startIndex����
    	this.startIndex = (curPage-1) * pageSize;

    }
	
	
	   public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getRangeSize() {
			return rangeSize;
		}

		public void setRangeSize(int rangeSize) {
			this.rangeSize = rangeSize;
		}

		public int getCurPage() {
			return curPage;
		}

		public void setCurPage(int curPage) {
			this.curPage = curPage;
		}

		public int getCurRange() {
			return curRange;
		}

		public void setCurRange(int curRange) {
			this.curRange = curRange;
		}

		public int getListCnt() {
			return listCnt;
		}

		public void setListCnt(int listCnt) {
			this.listCnt = listCnt;
		}

		public int getPageCnt() {
			return pageCnt;
		}

		public void setPageCnt(int pageCnt) {
			this.pageCnt = pageCnt;
		}

		public int getRangeCnt() {
			return rangeCnt;
		}

		public void setRangeCnt(int rangeCnt) {
			this.rangeCnt = rangeCnt;
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

		public int getPrevPage() {
			return prevPage;
		}

		public void setPrevPage(int prevPage) {
			this.prevPage = prevPage;
		}

		public int getNextPage() {
			return nextPage;
		}

		public void setNextPage(int nextPage) {
			this.nextPage = nextPage;
		}
	    public int getStartIndex() {
			return startIndex;
		}
		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}
}

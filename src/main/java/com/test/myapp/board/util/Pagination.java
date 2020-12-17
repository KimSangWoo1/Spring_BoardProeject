package com.test.myapp.board.util;

public class Pagination {
	// �� �������� �Խñ� �� 
    private int pageSize = 10;
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
    //  private int startIndex = 0;
    /// ���� ������ 
    private int prevPage;
    // ���� ������ 
    private int nextPage;
    
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
    	//this.startIndex = (curPage-1) * pageSize;
    }


	private void rangeSetting(int curPage) {
		// TODO Auto-generated method stub
		
	}


}

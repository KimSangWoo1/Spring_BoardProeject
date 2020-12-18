package com.test.myapp.board.util;

public class Pagination {
	// 한 페이지당 게시글 수 
    private int pageSize = 10;
    // 한 블럭(range)당 페이지 수 
    private int rangeSize = 5;  
    // 현재 페이지 
    private int curPage = 1;   
    // 현재 블럭(range) 
    private int curRange = 1; 
    // 총 게시글 수 
    private int listCnt; 
    // 총 페이지 수 
    private int pageCnt;
    // 총 블럭(range) 수 
    private int rangeCnt; 
    // 시작 페이지 
    private int startPage = 1;
    // 끝 페이지 
    private int endPage = 1;
    /// 시작 index 
    //  private int startIndex = 0;
    /// 이전 페이지 
    private int prevPage;
    // 다음 페이지 
    private int nextPage;
    
	public Pagination (int listCnt,  int curPage){
    
    	//현재 페이지
    	this.curPage=curPage;
    	//총 게시물 수
    	this.listCnt=listCnt;
    	
    	//1. 전체 페이지 수   ex) 전체 게시글 수/ 페이지에 보여질 게시글 수 = 전체 페이지 수  
    	this.pageCnt = (int)Math.ceil(listCnt*1.0/pageSize);
    	//2. 전체 블럭 수  ex)  전체 페이지 수/ 보여질 페이지 범위  = 전체 블록 수 
    	this.rangeCnt  = (int)Math.ceil(pageCnt*1.0/rangeSize);
    //3.블록 설정 (range Setting)    		
    	//현재 블록  ex)  ((4-1)/5) +1 = 1  
    	this.curRange = (int)((curPage-1)/rangeSize) + 1;
    	//시작  페이지 = (현재 블록-1) * 블록 범위 + 1
    	this.startPage = (curRange-1)*rangeSize+1;
    	//끝 페이지 = 시작페이지 + 블록 범위 -1
    	this.endPage = startPage + rangeSize-1;
    	
    	//끝 페이지 안넘도록 설정
    	if(endPage>pageCnt) {
    		this.endPage =pageCnt;
    	}
    	
    	this.prevPage = curPage -1;
    	this.nextPage = curPage +1;
    	
    	//startIndex설정
    	//this.startIndex = (curPage-1) * pageSize;
    }


	private void rangeSetting(int curPage) {
		// TODO Auto-generated method stub
		
	}


}

package com.test.myapp.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.myapp.board.dao.BoardDAO;
import com.test.myapp.board.util.Pagination;
import com.test.myapp.board.vo.BoardVO;


@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	//1.�Խñ� ����Ʈ ����
	@Override
	public List<Map<String, Object>> selectBoardListService(Map<String, Object> map) {
		return boardDAO.selectBoardList(map);
	}

	//2. �Խñ� �ۼ�
	@Override
	public void boardInsertService(Map<String, Object> map) throws Exception {
		 boardDAO.boardInsert(map);
	}

	//3. �Խñ� �󼼺���
	@Override
	public BoardVO boardUpateViewService(int idx) {
		 //�Խñ� ���� �������� 
		 BoardVO boardVO = boardDAO.boardUpdateView(idx);

		//DB���� ������ �Խñ� ���� ��Ʈ�ѷ��� ������
		return boardVO;
	}
	
	//4. ��ȸ�� �ø���
	@Override
	public void boardAddHitCountService(BoardVO boardVO) {
	
		//��ȸ�� ��������
		int hit_count = boardVO.getHit_count();
		//��ȸ�� +1 ������Ʈ �ϱ�
		boardVO.setHit_count(hit_count+1);
		boardDAO.boardAddHitCount(boardVO);
	}
	
	//5. �Խñ� �� ���� ��������
	@Override
	public int boardListCnt() {
		return boardDAO.boardAllListCnt();
	}

	//6. �Խñ� ����¡���� ��������
	@Override
	public List<BoardVO> boardPagingService(Pagination pagination) {

		return boardDAO.boardPaging(pagination);
	}
	//7. �Խ��� ����
	@Override
	public void boardDeleteService(int idx) {
		boardDAO.boardDelete(idx);
	}	
	//8.�Խñ� ����
	@Override
	public void boardUpdateService(BoardVO boardVO) {
		boardDAO.boardUpdate(boardVO);
	}
	
	
}

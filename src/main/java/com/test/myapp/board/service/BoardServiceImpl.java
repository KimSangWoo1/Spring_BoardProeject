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
	public Map<String, Object> boardUpateViewService(Map<String, Object> map) {

		//�Խñ� ���� �������� 
		 Map<String, Object> resultMap = boardDAO.boardUpdateView(map);
		 //��ȸ�� �ø���
		 boardAddHitCountService(resultMap);

		//DB���� ������ �Խñ� ���� ��Ʈ�ѷ��� ������
		return resultMap;
	}
	
	//4. ��ȸ�� �ø���
	@Override
	public void boardAddHitCountService(Map<String, Object> map) {
	
		//��ȸ�� ��������
		int hit_count = (int) map.get("hit_count");
		//��ȸ�� +1 ������Ʈ �ϱ�
		map.put("hit_count", hit_count+1);
		boardDAO.boardAddHitCount(map);
	}
	
	//5. �Խñ� �� ���� ��������
	@Override
	public int boardListCnt() {
		return boardDAO.boardAllListCnt();
	}

	//6. �Խñ� ����¡���� ��������
	@Override
	public List<BoardVO> BoardPagingService(Pagination pagination) {

		return boardDAO.boardPaging(pagination);
	}
	
	//6. �Խñ� ����¡���� ��������
	

	

	/*
	//5.�Խñ� ����
	@Override
	public List<Map<String, Object>> boardUpdateService(Map<String, Object> map) {
		return (List<Map<String, Object>>) boardDAO.boardUpdateView(map);
	}
	*/
	
}

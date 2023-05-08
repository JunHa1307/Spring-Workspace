package com.kh.spring.board.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.BoardImg;
import com.kh.spring.board.model.vo.BoardType;
import com.kh.spring.common.model.vo.PageInfo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public ArrayList<BoardType> selectBoardTypeList(){
		return (ArrayList) sqlSession.selectList("boardMapper.selectBoardTypeList");
	}
	
	public int selectBoardListCount(String boardCode) {
		return sqlSession.selectOne("boardMapper.selectBoardListCount",boardCode);
	}
	
	public ArrayList<Board> selectBoardList(PageInfo pi, String boardCode) {
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset,limit);
		return (ArrayList) sqlSession.selectList("boardMapper.selectBoardList", boardCode, rowBounds);
	}
	
	public Board selectBoardDetail(int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoardDetail",boardNo);
	}
	
	public int updateReadCount(int boardNo) {
		return sqlSession.update("boardMapper.updateReadCount",boardNo);
	}

	public int selectBoardSearchCount(Map<String, Object> paramMap) {
		return sqlSession.selectOne("boardMapper.selectBoardSearchCount",paramMap);
	}
	
	public ArrayList<Board> selectBoardSearch(PageInfo pi, Map<String, Object> paramMap) {
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset,limit);
		return (ArrayList) sqlSession.selectList("boardMapper.selectBoardSearch", paramMap, rowBounds);
	}
	
	public int insertBoard(Board b) {
		int result = sqlSession.insert("boardMapper.insertBoard",b);
		
		if(result > 0) {
			return b.getBoardNo();
			// 게시글 삽입 성공시 selectKey 태그를 이용해서 세팅한 boardNo값을 b객체 안에 담아서 반환시켜줌(일치하는 필드명이 있기 때문에)
		}
		
		return result;
	}
	
	public int insertBoardImgList(List<BoardImg> boardImageList) {
		
		return sqlSession.insert("boardMapper.insertBoardImgList", boardImageList);
		
	}
	
	public int updateBoard(Board b) {
		return sqlSession.update("boardMapper.updateBoard",b);
	}
	
	public int updateBoardImg(BoardImg img) {
		return sqlSession.update("boardMapper.updateBoardImg",img);
	}
	
	public int insertBoardImg(BoardImg img) {
		return sqlSession.insert("boardMapper.insertBoardImg",img);
	}
	
	public int deleteBoardImage(Map<String, Object> map) {
		return sqlSession.delete("boardMapper.deleteBoardImage",map);
	}
	
	public List<String> selectBoardImgList(){
		return sqlSession.selectList("boardMapper.selectBoardImgList");
	}
}

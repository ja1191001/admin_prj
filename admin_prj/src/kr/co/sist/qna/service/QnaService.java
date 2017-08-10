package kr.co.sist.qna.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.qna.dao.QnaDAO;
import kr.co.sist.qna.domain.QnaCntData;
import kr.co.sist.qna.domain.QnaData;
import kr.co.sist.qna.domain.QnaDetailData;
import kr.co.sist.qna.domain.QnaPageData;
import kr.co.sist.qna.vo.InsertQnaVO;
import kr.co.sist.qna.vo.QnaSearchVO;
import kr.co.sist.qna.vo.QnaValueVO;
import kr.co.sist.qna.vo.UpdateQnaVO;
@Component("qna_service")
public class QnaService {
	@Autowired
	private QnaDAO md;

	
	public List<QnaData> searchQna(QnaValueVO qvVO) {
		QnaDAO md= new QnaDAO();
		List<QnaData> list = null;
		try {
			list=md.selectQna(qvVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return list;
	}//searchQna
	
	public boolean Insert(InsertQnaVO iq){
		boolean flag=false;
		
		try {
			if(md.insertQna(iq)==1){
				flag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return flag;
	}//Insert
	
	public boolean updateq(UpdateQnaVO uq){
		boolean flag=false;
		
		try {
			if(md.updateQna(uq)==1){
				flag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return flag;
	}//updateq
	
	public boolean delete(String qnum){
		boolean flag=false;
		
		try {
			if(md.deleteQna(qnum)==1){
				flag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		System.out.println("MainService"+qnum);
		return flag;
	}
	

	
	public QnaDetailData searchQnaDetail(String qnum){
		QnaDetailData qd =null;
		try {
			qd=md.selectQnaDetail(qnum);
			System.out.println("QnaService-----------"+qnum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qd;
	}//searchQna
	
	public QnaPageData searchQnaPage(int currentPage, QnaCntData qcd){
		QnaPageData qpd=new QnaPageData();
		//전체 글 수
		int totalCount=qcd.getNum();
		//한 페이지에 나올 글 수
		int pageScale=15;
		//전체 페이지 수
		int totalPage=0;
		
		totalPage=totalCount/pageScale;
		if(totalCount%pageScale!=0){totalPage++;}//나머지가 존재하는 경우 페이지 추가
		
		int firstPage=(currentPage-1)/10;
		firstPage=firstPage*10+1;
		int lastPage=firstPage+9;
		
		if(totalPage<lastPage){lastPage=totalPage;}//마지막 페이지가 10페이지가 안될 경우
		
		qpd.setTatalPage(totalPage);
		qpd.setFirstPage(firstPage);
		qpd.setLastPage(lastPage);
		qpd.setCurrentPage(currentPage);
		return qpd;
	}//searchQnaPage
	
	public QnaSearchVO inputSearchValue( String columnName, String keyword){
		QnaSearchVO qsVO=new QnaSearchVO();
		
		qsVO.setColumnName(columnName);
		qsVO.setKeyword(keyword);
		
		return qsVO;
	}//inputSearchValue
	
	public QnaCntData searchQnaCnt(QnaSearchVO qsVO){
		
		QnaCntData qcd=null;
		
		try {
			qcd=md.selectqnaCnt(qsVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return qcd;
	}//searchQnaCnt

	public QnaValueVO inputValue(QnaCntData qcd, int currentPage, String columnName, String keyword){
		QnaValueVO qvv=new QnaValueVO();
		int pageScale=15;
		
		int endNum=qcd.getNum()-(currentPage-1)*pageScale; 
		int startNum=endNum-14;
		
		if(endNum<=15){startNum=1;}//해당목록 최고 번호가 15 밑이라면 시작번호는 무조건 1번
		
		
		qvv.setStartNum(startNum);
		qvv.setEndNum(endNum);
		qvv.setColumName(columnName);
		qvv.setKeyword(keyword);
		
		return qvv;
	}

}//class

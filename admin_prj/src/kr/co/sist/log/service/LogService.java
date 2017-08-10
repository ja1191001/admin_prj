package kr.co.sist.log.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.log.dao.LogDAO;
import kr.co.sist.log.vo.ChangeVO;
import kr.co.sist.log.vo.EmpVO;
import kr.co.sist.log.vo.FindIdVO;
import kr.co.sist.log.vo.FindPassVO;
import kr.co.sist.log.vo.LogVO;

@Component("login_admin")
public class LogService {
	
	@Autowired(required=false)
	private LogDAO ld;
	
	public String loginAdmin(LogVO lv){
		String id=null;
		
		try {
			id=ld.selectAdminLogin(lv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	public boolean signInAdmin(EmpVO ev){
		boolean flag=false;
		
		try {
			if(ld.insertAdmin(ev)==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public String findAdminId(FindIdVO fiv){
		String id=null;
		
		try {
			id=ld.selectAdminId(fiv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	public String findAdminPass(FindPassVO fpv){
		String id=null;
		
		try {
			id=ld.selectAdminPass(fpv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}

	public boolean changePass(ChangeVO cv){
		boolean flag=false;
		
		try {
			if(ld.updateAdminPass(cv)==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}

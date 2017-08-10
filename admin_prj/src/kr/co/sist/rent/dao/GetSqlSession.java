package kr.co.sist.rent.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetSqlSession {
	private static GetSqlSession gss;
	private static SqlSessionFactoryBuilder ssfb;
	
	private GetSqlSession(){
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//GetSqlSession
	
	public static GetSqlSession getInstance(){
		if(gss==null){
			gss=new GetSqlSession();
		}//end if
		
		return gss;
	}//getInstance
	
	private static SqlSessionFactory ssf=null;
	
	private SqlSessionFactory getFactoryBuilder(){
		if(ssf==null){
			ssfb=new SqlSessionFactoryBuilder();
			try {
				Reader reader=Resources.getResourceAsReader("kr/co/sist/rent/dao/config/mybatis_config.xml");
				ssf=ssfb.build(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}//end try
		}//end if
		
		return ssf;
	}//getFactoryBuilder
	
	public SqlSession getSqlSession(){
		SqlSession ss=getFactoryBuilder().openSession();
		return ss;
	}
}

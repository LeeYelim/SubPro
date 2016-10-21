package kosta.model.service;


import java.sql.SQLException;
import java.util.List;

import kosta.model.dao.ElecDaoImpl;
import kosta.model.dto.Electronics;

public class ElecService {
	private static ElecDaoImpl  electronicsDao = new ElecDaoImpl();
	
	/**
	 * ElectronicsDAOImpl의 모든레코드 검색하는 메소드 호출
	 * */
	public static List<Electronics> selectAll() throws SQLException{
		  return electronicsDao.selectAll();
	  }
	  
	  /**
	   * ElectronicsDAOImpl의 레코드 삽입하는 메소드 호출
	   * */
	  public static int insert(Electronics electronics) throws SQLException{
		  return electronicsDao.insert(electronics);
	  }
	  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
	   * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	   * */
	  public static Electronics selectByModelNum(String model_num, boolean flag) throws SQLException{
		  return electronicsDao.selectByModelNum(model_num , flag);
	  }
	  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	   * */
	  public static int delete(String model_num, String password) throws SQLException{
		  return electronicsDao.delete(model_num,password);
	  }
	  
	  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
	   * */
	  public static int update(Electronics electronics) throws SQLException{
		  return electronicsDao.update(electronics);
	  }
	  
	  
}




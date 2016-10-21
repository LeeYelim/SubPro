package kosta.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElecService;

public class UpdateElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//넘어오는 값들 받기
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("modelName");
		String price =  request.getParameter("price");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		
		//유효성 검사
		try{
		  if(modelNum==null || modelName==null || price==null
				  || description==null ||password==null ){
			
			  throw new Exception("입력값이 충분하지 않습니다.");
		  }
		
		//비밀번호를 검사해서 일치하면 update 안하면
		//예외발생.
		  
		 Electronics dbElec=
				 ElecService.selectByModelNum(modelNum, false);
		 
		 if(dbElec.getPassword().equals(password.trim())){
			 Electronics elec= 
					 new Electronics(modelNum, modelName, Integer.parseInt(price), description, password);
				int result = ElecService.update(elec);
				
				if(result==0){//실패
					throw new Exception("수정되지 않았습니다.");
				}
				
				response.sendRedirect("elec?flag=1&command=detailView&modelNum="+URLEncoder.encode(modelNum,"UTF-8"));
			    return;
		 }else{
			 throw new Exception("비밀번호가 오류입니다.");
		 }
		  
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher("errorView/error.jsp")
		.forward(request, response);

	}

}

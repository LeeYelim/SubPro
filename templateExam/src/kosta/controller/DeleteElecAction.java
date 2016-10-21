package kosta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElecService;

public class DeleteElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		try{
		
			Electronics dbElec= ElecService.selectByModelNum(modelNum, false);
				
			if(dbElec.getPassword().equals(password.trim())){
				if(ElecService.delete(modelNum, password) > 0){
					 response.sendRedirect("elec?command=list");
					 return;
				 }else{
					 throw new Exception("삭제 되지 않았습니다.");
				 }
				
			}else{
				throw new Exception("비밀번호 오류입니다.");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher("errorView/error.jsp")
		.forward(request, response);
		

	}

}

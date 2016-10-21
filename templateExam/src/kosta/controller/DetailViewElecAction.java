package kosta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElecService;

public class DetailViewElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelNum = request.getParameter("modelNum");
		String flag = request.getParameter("flag");
		boolean state= true;//조회수증가
		if(flag!=null)state=false;
		
		String url="errorView/error.jsp";
		try{
			if(modelNum==null){
				throw new Exception("상품번호가 없습니다.");
			}
			
			Electronics elec = ElecService.selectByModelNum(modelNum, state);//true - 조회수증가!
			if(elec==null){
				throw new Exception("상품이 존재하지 않습니다.");
			}else{
				request.setAttribute("elec", elec);
				url="elecView/read.jsp";
			}

		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
		}

		request.getRequestDispatcher(url).forward(request, response);

	}

}

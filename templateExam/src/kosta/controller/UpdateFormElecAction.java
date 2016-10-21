package kosta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElecService;

public class UpdateFormElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelNum = request.getParameter("modelNum");
		String url="errorView/error.jsp";
		try{
			if(modelNum==null){
				throw new Exception("modelNum이 없습니다.");
			}
			Electronics elec=ElecService.selectByModelNum(modelNum, false);//조회수증가안함.
			if(elec==null){
				throw new Exception("해당하는 상품이 없습니다.");
			}else{
				request.setAttribute("elec", elec);
				url="elecView/update.jsp";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}

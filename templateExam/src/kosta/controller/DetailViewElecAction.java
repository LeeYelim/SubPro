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
		boolean state= true;//��ȸ������
		if(flag!=null)state=false;
		
		String url="errorView/error.jsp";
		try{
			if(modelNum==null){
				throw new Exception("��ǰ��ȣ�� �����ϴ�.");
			}
			
			Electronics elec = ElecService.selectByModelNum(modelNum, state);//true - ��ȸ������!
			if(elec==null){
				throw new Exception("��ǰ�� �������� �ʽ��ϴ�.");
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

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
		//�Ѿ���� ���� �ޱ�
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("modelName");
		String price =  request.getParameter("price");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		
		//��ȿ�� �˻�
		try{
		  if(modelNum==null || modelName==null || price==null
				  || description==null ||password==null ){
			
			  throw new Exception("�Է°��� ������� �ʽ��ϴ�.");
		  }
		
		//��й�ȣ�� �˻��ؼ� ��ġ�ϸ� update ���ϸ�
		//���ܹ߻�.
		  
		 Electronics dbElec=
				 ElecService.selectByModelNum(modelNum, false);
		 
		 if(dbElec.getPassword().equals(password.trim())){
			 Electronics elec= 
					 new Electronics(modelNum, modelName, Integer.parseInt(price), description, password);
				int result = ElecService.update(elec);
				
				if(result==0){//����
					throw new Exception("�������� �ʾҽ��ϴ�.");
				}
				
				response.sendRedirect("elec?flag=1&command=detailView&modelNum="+URLEncoder.encode(modelNum,"UTF-8"));
			    return;
		 }else{
			 throw new Exception("��й�ȣ�� �����Դϴ�.");
		 }
		  
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher("errorView/error.jsp")
		.forward(request, response);

	}

}

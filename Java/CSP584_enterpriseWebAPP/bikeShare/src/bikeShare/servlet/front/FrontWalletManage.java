package bikeShare.servlet.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bikeShare.common.RespondTool;
import bikeShare.dao.UserDaoImpl;
import bikeShare.model.User;

/**
 * Servlet implementation class FrontWalletManage
 */
@WebServlet(description = "用于管理钱包", urlPatterns = { "/FrontWalletManage" })
public class FrontWalletManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontWalletManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		 UserDaoImpl udi=new UserDaoImpl();
		if(flag.equals("wallet")){
			 HttpSession session=request.getSession();
		     User user=(User) session.getAttribute("user");
		        if (user==null)
		        {
		        	 request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		        	 return;
		        }
		        Integer  userId=user.getUserid();
		        System.out.println("session中的"+userId);
		        user=udi.queryUserByPramryKey(userId+"");
		        request.setAttribute("user", user);
		        request.getRequestDispatcher("/WEB-INF/views/wallet.jsp").forward(request, response);	
		}	
		if(flag.equals("payCash")){
			 int payCash=Integer.parseInt(request.getParameter("payCash"));
			
			String  userId=request.getParameter("userId");
		    User user=udi.queryUserByPramryKey(userId+"");
		    //String sql="update user set wallet=?,securityCash=?,payTime=? where userId=?";
		    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		String time= sf.format(new Date());

		    	if(user.getSecuritycash()!=300){
			    	int wallet=(payCash-300);
			    	String paras[]={wallet+"",300+"",time ,userId};
			      if(udi.payCash(paras)!=0){
			    	 RespondTool.getNewsString(request, response, "其中300是押金，还有"+wallet+"充值到余额", 100); 
			    	  
			      }else{
			    	  RespondTool.getNewsString(request, response, "充值失败", 200); 
			      }
			      
			    	
			    }else{
			    	
			    	payCash= (int) (user.getWallet()+payCash);
			    	String paras[]={payCash+"",300+"",time ,userId};
			    	 if(udi.payCash(paras)!=0){
				    	 RespondTool.getNewsString(request, response, "充值"+payCash+"到余额成功", 100); 
				    	  
				      }else{
				    	  RespondTool.getNewsString(request, response, "充值失败", 200); 
				      } 
			    }
			}
		    
			
			
		}
				
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

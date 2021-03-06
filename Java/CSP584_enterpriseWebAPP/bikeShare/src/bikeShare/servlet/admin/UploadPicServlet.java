package bikeShare.servlet.admin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bikeShare.dao.ActivityDaoImpl;
import bikeShare.dao.GoodDaoImpl;
import bikeShare.dao.ImagePathDaoimpl;





import com.jspsmart.upload.SmartUpload;

/**
 * Servlet implementation class UploadPicServlet
 */
@WebServlet("/UploadPicServlet")
public class UploadPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletConfig config;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
    	super.init(config);
    	this.config=config;
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	 final public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GoodDaoImpl gdi=new GoodDaoImpl();
	
		ImagePathDaoimpl imagepathDao=new ImagePathDaoimpl();
		
		response.setCharacterEncoding("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		SmartUpload su=new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		su.setCharset("UTF-8");
		su.setAllowedFilesList("jpg");
		try {
			su.upload();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		String goodsname = su.getRequest().getParameter("goodsname");
		String activity = su.getRequest().getParameter("activity");
		String price = su.getRequest().getParameter("price");
		String num = su.getRequest().getParameter("num");
		String description = su.getRequest().getParameter("description");
		String category = su.getRequest().getParameter("category");
		String address = su.getRequest().getParameter("address");
	    com.jspsmart.upload.File file=su.getFiles().getFile(0);
	    try {
			file.saveAs("/shopimage/"+file.getFileName(), SmartUpload.SAVE_VIRTUAL);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sf.format(new Date());
		String paras[]={ goodsname,time,category,description,activity,price,num,address};
		int lastId=0;
		if(gdi.insertGoodsInfo(paras)==1){
			 lastId=gdi.queryLastGoodsId();
		}				
	    
	    String fileName=file.getFileName();
	    
		String paras2[]={lastId+"",fileName};
	    if(imagepathDao.insertImagePath(paras2)==1){
	    	request.setAttribute("msg", "success");
			request.getRequestDispatcher("/WEB-INF/views/addGoods.jsp").forward(request, response);	
				
			}else{
				request.setAttribute("msg", "fail");
				request.getRequestDispatcher("/WEB-INF/views/addGoods.jsp").forward(request, response);	
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

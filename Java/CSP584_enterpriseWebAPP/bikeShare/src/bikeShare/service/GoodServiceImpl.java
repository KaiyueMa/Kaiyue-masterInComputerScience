package bikeShare.service;

import java.util.List;

import bikeShare.common.PageUtil;
import bikeShare.dao.GoodDaoImpl;
import bikeShare.dao.ImagePathDaoimpl;
import bikeShare.model.Goods;
import bikeShare.model.ImagePath;

public class GoodServiceImpl {
	
	public Goods getNews(int newsId){
		
		GoodDaoImpl gdi=new GoodDaoImpl();
	   ImagePathDaoimpl ipdi=new ImagePathDaoimpl();
     
	   Goods good=gdi.queryGoodByPrimaryKey(newsId+"");
	  if(good!=null){	  
		  ImagePath imgepath=ipdi.queryByImageId(good.getGoodsid().toString());
		  good.setImgepath(imgepath.getPath());
		  if (good.getDescription().length() > 55) {
			  good.setDescription(good.getDescription().substring(0, 50)+"...");
			}
	  }
	
		
		return good;
		
	}


	
	

}

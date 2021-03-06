package bikeShare.model;

import java.util.Date;
import java.util.List;

public class Goods {
    private Integer goodsid;

    private String goodsname;

    private Integer price;

    private Integer num;

    private Date uptime;

    private Integer categoryId;
    
    private Category category;

    private Integer statue;

    private Integer activityid;

    private String description;
    
    private String imgepath;

    private List<ImagePath> imagePaths;

    private Activity activity;

    private String activitydesc;
    
    private Float newPrice;
    
    private Integer address;

    public String getImgepath() {
		return imgepath;
	}

	public void setImgepath(String imgepath) {
		this.imgepath = imgepath;
	}

	

    
    public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
	}

	
    
    
    public Integer getStatue() {
		return statue;
	}

	public void setStatue(Integer statue) {
		this.statue = statue;
	}

	
	public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    
  

   

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public List<ImagePath> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<ImagePath> imagePaths) {
        this.imagePaths = imagePaths;
    }


 
    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Float getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Float newPrice) {
        this.newPrice = newPrice;
    }

	public String getActivitydesc() {
		return activitydesc;
	}

	public void setActivitydesc(String activitydesc) {
		this.activitydesc = activitydesc;
	}
    
}
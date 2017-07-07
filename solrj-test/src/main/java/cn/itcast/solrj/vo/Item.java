package cn.itcast.solrj.vo;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 商品
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年4月14日 下午10:52:14
 * @version 1.0
 */
public class Item{
	/** 商品id，同时也是商品编号 */
	@Field("id")
    private Long id;
	/** 商品标题 */
	@Field("title")
    private String title;
    /** 商品卖点 */
	@Field("sellPoint")
    private String sellPoint;
    /** 商品价格，单位为：分 */
	@Field("price")
    private Long price;
    /** 商品图片 */
	@Field("image")
    private String image;
	/** 商品状态，1-正常，2-下架，3-删除 */
	@Field("status")
    private Integer status;
    
    /** setter and getter method */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
package cn.itcast.solrj;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.solrj.vo.Item;

/**
 * SolrJCloudLinuxTest
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年7月1日 上午11:00:16
 * @version 1.0
 */
public class SolrJCloudLinuxTest {
	
	/** 定义CloudSolrServer服务对象操作Solr集群 */
	private CloudSolrServer cloudSolrServer;
	
	@Before
	public void before(){
		/** 定义zkHost的服务地址 ip:port,ip:port */
		String zkHost = "192.168.12.128:3181,192.168.12.128:3182,192.168.12.128:3183";
		/** 创建CloudSolrServer */
		this.cloudSolrServer = new CloudSolrServer(zkHost);
		/** 设置默认的Collection索引库 */
		cloudSolrServer.setDefaultCollection("taotao_collection");
	}
	
	
	/** 添加或修改  */
	@Test
	public void test2() throws Exception{
		/** 创建Item */
		Item item = new Item();
		item.setId(1L);
		item.setTitle("华为7");
		item.setSellPoint("华为7好用！");
		item.setPrice(239900L);
		item.setImage("http://image.taotao.com/2.jpg");
		item.setStatus(1);
		/** 添加文档 ，得到修改响应对象 */
		UpdateResponse response = cloudSolrServer.addBean(item);
		/** 判断响应状态码：status 0:成功 */
		System.out.println("状态码：" + response.getStatus());
		if (response.getStatus() == 0){
			cloudSolrServer.commit();
		}else{
			cloudSolrServer.rollback();
		}
	}
	
	/** 删除相关 */
	@Test
	public void test3() throws Exception{
		
		/** 删除文档 ，得到修改响应对象 (根据主键id删除) */
		UpdateResponse response = cloudSolrServer.deleteById("1");
		
		/** 判断响应状态码：status 0:成功 */
		System.out.println("状态码：" + response.getStatus());
		if (response.getStatus() == 0){
			cloudSolrServer.commit();
		}else{
			cloudSolrServer.rollback();
		}
	}
	
	/** 搜索相关 */
	@Test
	public void test4() throws Exception{
		/** 创建SolrQuery查询对象(封装请求参数) */
		SolrQuery solrQuery = new SolrQuery();
		/** 设置查询字符串 q */
		solrQuery.setQuery("title:华为");
		/** 设置过滤条件 fq */
		solrQuery.setFilterQueries("price:[200000 TO 500000]");
		/** 设置排序 sort */
		solrQuery.setSort("id", ORDER.desc);
		/** 设置分页的起始数 start */
		solrQuery.setStart(0);
		/** 设置分页的显示记录数 rows */
		solrQuery.setRows(5);
		/** 设置返回的字段列表 fl */
		solrQuery.setFields("id,title,price");
		
		/** 设置高亮显示 hl */
		solrQuery.setHighlight(true);
		/** 设置高亮字段列表 hl.fl */
		solrQuery.addHighlightField("title");
		/** 设置文本截断  hl.fragsize*/
		solrQuery.setHighlightFragsize(50);
		/** 设置高亮格式器前缀  hl.simple.pre*/
		solrQuery.setHighlightSimplePre("<font color='red'>");
		/** 设置高亮格式器后缀  hl.simple.post*/
		solrQuery.setHighlightSimplePost("</font>");
		
		/** 搜索，得到查询响应对象 */
		QueryResponse response = cloudSolrServer.query(solrQuery);
		/** 判断响应状态码：status 0:成功 */
		System.out.println("状态码：" + response.getStatus());
		if (response.getStatus() == 0){
			/** 获取总记录数 */
			System.out.println("总命中的记录数：" + response.getResults().getNumFound());
			/** 获取检索的结果 */
			List<Item> items =  response.getBeans(Item.class);
			
			/** 获取高亮内容Map集合 */
			Map<String, Map<String, List<String>>> hMaps = response.getHighlighting();
			
			/** 迭代集合 */
			for (Item item : items){
				System.out.println(item.getId() + "\t" 
						+ item.getTitle() + "\t" + item.getPrice());
				
				Map<String, List<String>> map = hMaps.get(item.getId().toString());
				System.out.println("title高亮内容：" + map.get("title").get(0));
			}
		}
	}
}
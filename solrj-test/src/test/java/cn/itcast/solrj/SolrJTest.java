package cn.itcast.solrj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.solrj.vo.Item;

/**
 * SolrJTest
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年7月1日 上午11:00:16
 * @version 1.0
 */
public class SolrJTest {
	
	/** 定义SolrServer服务对象 */
	private SolrServer solrServer;
	
	@Before
	public void before(){
		/** 定义BaseURL：格式：solr服务器请求地址 + solrCore的名称 */
		String baseURL = "http://localhost:8080/solr/collection1";
		/** 创建SolrServer */
		this.solrServer = new HttpSolrServer(baseURL);
	}
	
	/** 添加或修改 (第一种方式) */
	@Test
	public void test1() throws Exception{
		/** 创建SolrInputDocument */
		SolrInputDocument doc = new SolrInputDocument();
		/** 添加字段 */
		doc.addField("id", 1L);
		doc.setField("title", "苹果7");
		doc.addField("sellPoint", "苹果7好用！");
		doc.setField("price", 539900);
		doc.addField("image","http://image.taotao.com/1.jpg");
		doc.addField("status", 1);
		/** 添加文档 ，得到修改响应对象 */
		UpdateResponse response = solrServer.add(doc);
		/** 判断响应状态码：status 0:成功 */
		System.out.println("状态码：" + response.getStatus());
		if (response.getStatus() == 0){
			solrServer.commit();
		}else{
			solrServer.rollback();
		}
	}
	
	/** 添加或修改 (第二种方式) */
	@Test
	public void test2() throws Exception{
		/** 创建Item */
		Item item = new Item();
		item.setId(2L);
		item.setTitle("华为7");
		item.setSellPoint("华为7好用！");
		item.setPrice(239900L);
		item.setImage("http://image.taotao.com/2.jpg");
		item.setStatus(1);
		/** 添加文档 ，得到修改响应对象 */
		UpdateResponse response = solrServer.addBean(item);
		/** 判断响应状态码：status 0:成功 */
		System.out.println("状态码：" + response.getStatus());
		if (response.getStatus() == 0){
			solrServer.commit();
		}else{
			solrServer.rollback();
		}
	}
	
	/** 删除相关 */
	@Test
	public void test3() throws Exception{
		
		/** 删除文档 ，得到修改响应对象 (根据主键id删除) */
		//UpdateResponse response = solrServer.deleteById("1");
		
		/** 删除文档 ，得到修改响应对象 (根据主键id批量删除) */
		List<String> idLists = new ArrayList<>();
		idLists.add("1");
		idLists.add("2");
		//UpdateResponse response = solrServer.deleteById(idLists);
		
		/** 删除文档 ，得到修改响应对象 (根据Query查询条件删除)  title:7 */
		UpdateResponse response = solrServer.deleteByQuery("*:*");
		
		/** 判断响应状态码：status 0:成功 */
		System.out.println("状态码：" + response.getStatus());
		if (response.getStatus() == 0){
			solrServer.commit();
		}else{
			solrServer.rollback();
		}
	}
	
	/** 搜索相关(第一种方式) */
	@Test
	public void test4() throws Exception{
		/** 创建SolrQuery查询对象(封装请求参数) */
		SolrQuery solrQuery = new SolrQuery();
		/** 设置查询字符串 q */
		solrQuery.setQuery("title:手机");
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
		QueryResponse response = solrServer.query(solrQuery);
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
	
	
	/** 搜索相关(第二种方式) */
	@Test
	public void test5() throws Exception{
		/** 创建Map集合封装请求参数 */
		Map<String, String> map = new HashMap<>();
		/** 设置查询字符串 q */
		map.put("q", "title:手机");
		/** 设置过滤条件 fq */
		map.put("fq", "price:[200000 TO 500000]");
		/** 设置排序 sort */
		map.put("sort", "id desc");
		/** 设置分页的起始数 start */
		map.put("start", "0");
		/** 设置分页的显示记录数 rows */
		map.put("rows", "5");
		/** 设置返回的字段列表 fl */
		map.put("fl", "id,title,price");
		
		/** 设置高亮显示 hl */
		map.put("hl", "true");
		/** 设置高亮字段列表 hl.fl */
		map.put("hl.fl", "title");
		/** 设置文本截断  hl.fragsize*/
		map.put("hl.fragsize", "20");
		/** 设置高亮格式器前缀  hl.simple.pre*/
		map.put("hl.simple.pre", "<font color='red'>");
		/** 设置高亮格式器后缀  hl.simple.post*/
		map.put("hl.simple.post", "</font>");
		
		
		/** 定义SolrParams */
		SolrParams solrParams = new MapSolrParams(map);
		/** 搜索，得到查询响应对象 */
		QueryResponse response = solrServer.query(solrParams);
		/** 判断响应状态码：status 0:成功 */
		System.out.println("状态码：" + response.getStatus());
		if (response.getStatus() == 0){
			/** 获取总记录数 */
			System.out.println("总命中的记录数：" + response.getResults().getNumFound());
			/** 获取检索的结果 */
			SolrDocumentList sList = response.getResults();
			/** 获取高亮内容Map集合 */
			Map<String, Map<String, List<String>>> hMaps = response.getHighlighting();
			
			/** 迭代集合 */
			for (SolrDocument doc : sList){
				
				System.out.println(doc.get("id") + "\t" + doc.get("title") 
						+ "\t" + doc.getFieldValue("price"));
				
				Map<String, List<String>> m = hMaps.get(doc.get("id").toString());
				System.out.println("title高亮内容：" + m.get("title").get(0));
			}
		}
	}
}
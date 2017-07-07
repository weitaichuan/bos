package cn.itcast.httpclient;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * HttpClientTest
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年6月25日 上午10:54:37
 * @version 1.0
 */
public class HttpClientTest {
	
	/** 创建可关闭的HttpClient客户端对象 */
	private CloseableHttpClient httpClient = HttpClients.createDefault();
	
	/** get请求 */
	@Test
	public void getTest() throws Exception{
		
		/** 构建请求URI */
		URI uri = new URIBuilder("http://admin.taotao.com/item/restful/41").build();
		URI uri2 = new URIBuilder("http://search.jd.com/Search")
			.setParameter("keyword", "apple")
			.build();
		/** 创建HttpGet请求对象 */
		HttpGet httpGet = new HttpGet("http://admin.taotao.com/item/restful/41");
		/** 执行请求，得到响应对象 */
		CloseableHttpResponse response = httpClient.execute(httpGet);
		/** 判断响应的状态码 */
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
			/** 获取响应实体 */
			HttpEntity entity = response.getEntity();
			/** 把响应实体转化成字符串 */
			String content = EntityUtils.toString(entity, Consts.UTF_8);
			System.out.println(content);
		}
		/** 关闭 */
		response.close();
	}
	
	/** post请求 */
	@Test
	public void postTest() throws Exception{
		/** 构建请求URI */
		URI uri = new URIBuilder("http://search.jd.com/Search").build();
		/** 创建HttpPost请求对象 */
		HttpPost httpPost = new HttpPost(uri);
		/** 创建List集合封装表单中的请求参数 */
		List<NameValuePair> nvpLists = new ArrayList<>();
		nvpLists.add(new BasicNameValuePair("keyword", "apple"));
		nvpLists.add(new BasicNameValuePair("age", "20"));
		/** 
		 * 创建请求参数对象 
		 * UrlEncodedFormEntity: 表单提交
		 * */
		HttpEntity entity = new UrlEncodedFormEntity(nvpLists, Consts.UTF_8);
		/** 设置请求参数 */
		httpPost.setEntity(entity);
		/** 执行请求，得到响应对象 */
		CloseableHttpResponse response = httpClient.execute(httpPost);
		
		/** 判断响应的状态码 */
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
			/** 获取响应实体 */
			entity = response.getEntity();
			/** 把响应实体转化成字符串 */
			String content = EntityUtils.toString(entity, Consts.UTF_8);
			System.out.println(content);
		}
		/** 关闭 */
		response.close();
	}
}

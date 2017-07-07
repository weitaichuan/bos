package cn.itcast.httpclient;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * HttpClientServiceTest
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年6月25日 下午12:01:13
 * @version 1.0
 */
public class HttpClientServiceTest {
	/** 创建 HttpClientService */
	private HttpClientService httpClientService = new HttpClientService();
	/** 定义签名密钥 32长度(用MD5加密) */
	private static final String SIGN_KEY = "b071eab0c3a8f0a043cb49835e571f12";
	private ObjectMapper objectMapper = new ObjectMapper();
	
	/** get请求 */
	@Test
	public void get(){
		Map<String,String> params = new HashMap<>();
		/** 对接口中的请求参数签名 */
		params.put("sign", DigestUtils.md5Hex(SIGN_KEY + 41));
		HttpResponseEntity responseEntity = httpClientService.sendGet("http://admin.taotao.com/item/restful/41", params);
		System.out.println("状态码：" + responseEntity.getStatusCode());
		System.out.println("响应数据：" + responseEntity.getContent());
	}
	
	/** post请求 */
	@Test
	public void post() throws Exception{
		/** 定义Map集合封装请求参数 */
		Map<String, String> params = new HashMap<>();
		params.put("title", "华为荣耀7");
		params.put("sellPoint", "国产手机好");
		params.put("barcode", "xxxxxxxxxxx");
		params.put("cid", "200");
		params.put("num", "1000");
		params.put("price", "228000");
		params.put("status", "1");
		/** 对接口中的请求参数签名 */
		params.put("sign", DigestUtils.md5Hex(SIGN_KEY + objectMapper.writeValueAsString(params)));
		HttpResponseEntity responseEntity = httpClientService.sendPost("http://admin.taotao.com/item/restful", params, true);
		System.out.println("状态码：" + responseEntity.getStatusCode());
		System.out.println("响应数据：" + responseEntity.getContent());
	}
	
	/** put请求 */
	@Test
	public void put() throws Exception{
		/** 定义Map集合封装请求参数 */
		Map<String, String> params = new HashMap<>();
		params.put("id", "46");
		params.put("title", "华为荣耀8");
		params.put("sellPoint", "国产手机好");
		params.put("barcode", "xxxxxxxxxxx");
		params.put("cid", "200");
		params.put("num", "1000");
		params.put("price", "228000");
		params.put("status", "1");
		/** 对接口中的请求参数签名 */
		params.put("sign", DigestUtils.md5Hex(SIGN_KEY + objectMapper.writeValueAsString(params)));
		HttpResponseEntity responseEntity = httpClientService.sendPut("http://admin.taotao.com/item/restful", params, true);
		System.out.println("状态码：" + responseEntity.getStatusCode());
		System.out.println("响应数据：" + responseEntity.getContent());
	}
	
	/** delete请求 */
	@Test
	public void delete(){
		/** 定义Map集合封装请求参数 */
		Map<String, String> params = new HashMap<>();
		params.put("id", "46");
		params.put("sign", DigestUtils.md5Hex(SIGN_KEY + 46));
		HttpResponseEntity responseEntity = httpClientService.sendDelete("http://admin.taotao.com/item/restful", params);
		System.out.println("状态码：" + responseEntity.getStatusCode());
		System.out.println("响应数据：" + responseEntity.getContent());
	}
}
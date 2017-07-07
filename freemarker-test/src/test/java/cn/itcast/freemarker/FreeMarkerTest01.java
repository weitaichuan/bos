package cn.itcast.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * FreeMarkerTest01
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年7月5日 上午10:17:02
 * @version 1.0
 */
public class FreeMarkerTest01 {
	
	/** 输出到控制台 */
	@Test
	public void test1()throws Exception{
		/** 创建Configuration配置信息对象 */
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
		/** 设置加载模版文件的基础路径 */
		configuration.setClassForTemplateLoading(FreeMarkerTest01.class, "/ftl");
		
		/** 定义模版需要数据模型(Map集合来封装) */
		Map<String, Object> dataModel = new HashMap<>();
		dataModel.put("msg", "第一个FreeMarker示例！");
		
		/** 获取指定的模版文件，产生模版对象 */
		Template template = configuration.getTemplate("hello.ftl");
		
		/**
		 * 输出文件
		 * 第一个参数：数据模型
		 * 第二个参数：输出流
		 */
		template.process(dataModel, new PrintWriter(System.out));
		
	}
	
	/** 输出到指定的文件 */
	@Test
	public void test2()throws Exception{
		/** 创建Configuration配置信息对象 */
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
		/** 设置加载模版文件的基础路径 */
		configuration.setClassForTemplateLoading(FreeMarkerTest01.class, "/ftl");
		
		/** 定义模版需要数据模型(Map集合来封装) */
		Map<String, Object> dataModel = new HashMap<>();
		dataModel.put("msg", "第一个FreeMarker示例！");
		
		/** 获取指定的模版文件，产生模版对象 */
		Template template = configuration.getTemplate("hello.ftl");
		
		/**
		 * 输出文件
		 * 第一个参数：数据模型
		 * 第二个参数：输出流
		 */
		template.process(dataModel, new FileWriter(
				new File("C:\\Users\\Administrator\\Desktop\\html\\hello.html")));
		
	}
}

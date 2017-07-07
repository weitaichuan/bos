package cn.itcast.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.itcast.freemarker.vo.User;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * FreeMarkerTest02
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年7月5日 上午10:17:02
 * @version 1.0
 */
public class FreeMarkerTest02 {
	
	
	/** 标量类型 */
	@Test
	public void test1()throws Exception{
		/** 创建Configuration配置信息对象 */
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
		/** 设置加载模版文件的基础路径 */
		configuration.setClassForTemplateLoading(FreeMarkerTest02.class, "/ftl");
		
		/** 定义模版需要数据模型(Map集合来封装) */
		Map<String, Object> dataModel = new HashMap<>();
		dataModel.put("id", 1);
		dataModel.put("name", "李小华");
		dataModel.put("age", 18);
		dataModel.put("sex", true);
		dataModel.put("birthday", new Date());
		/** 获取指定的模版文件，产生模版对象 */
		Template template = configuration.getTemplate("1.ftl");
		
		/**
		 * 填充模版，输出文件
		 * 第一个参数：数据模型
		 * 第二个参数：输出流
		 */
		template.process(dataModel, new FileWriter(
				new File("C:\\Users\\Administrator\\Desktop\\html\\1.html")));
	}
	
	/** 对象类型 */
	@Test
	public void test2()throws Exception{
		/** 创建Configuration配置信息对象 */
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
		/** 设置加载模版文件的基础路径 */
		configuration.setClassForTemplateLoading(FreeMarkerTest02.class, "/ftl");
		
		/** 定义模版需要数据模型(Map集合来封装) */
		Map<String, Object> dataModel = new HashMap<>();
		dataModel.put("user", new User(1, "李大华", 22, true, new Date()));
		
		/** 获取指定的模版文件，产生模版对象 */
		Template template = configuration.getTemplate("2.ftl");
		
		/**
		 * 填充模版，输出文件
		 * 第一个参数：数据模型
		 * 第二个参数：输出流
		 */
		template.process(dataModel, new FileWriter(
				new File("C:\\Users\\Administrator\\Desktop\\html\\2.html")));
	}
	
	/** 表达式与运算符 */
	@Test
	public void test3()throws Exception{
		/** 创建Configuration配置信息对象 */
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
		/** 设置加载模版文件的基础路径 */
		configuration.setClassForTemplateLoading(FreeMarkerTest02.class, "/ftl");
		
		/** 定义模版需要数据模型(Map集合来封装) */
		Map<String, Object> dataModel = new HashMap<>();
		/** 获取指定的模版文件，产生模版对象 */
		Template template = configuration.getTemplate("3.ftl");
		
		/**
		 * 填充模版，输出文件
		 * 第一个参数：数据模型
		 * 第二个参数：输出流
		 */
		template.process(dataModel, new FileWriter(
				new File("C:\\Users\\Administrator\\Desktop\\html\\3.html")));
	}
	
	/** 变量指令 */
	@Test
	public void test4()throws Exception{
		/** 创建Configuration配置信息对象 */
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
		/** 设置加载模版文件的基础路径 */
		configuration.setClassForTemplateLoading(FreeMarkerTest02.class, "/ftl");
		
		/** 定义模版需要数据模型(Map集合来封装) */
		Map<String, Object> dataModel = new HashMap<>();
		/** 获取指定的模版文件，产生模版对象 */
		Template template = configuration.getTemplate("4.ftl");
		
		/**
		 * 填充模版，输出文件
		 * 第一个参数：数据模型
		 * 第二个参数：输出流
		 */
		template.process(dataModel, new FileWriter(
				new File("C:\\Users\\Administrator\\Desktop\\html\\4.html")));
	}
	
	/** 条件指令、循环指令、包含指令 */
	@Test
	public void test5()throws Exception{
		/** 创建Configuration配置信息对象 */
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
		/** 设置加载模版文件的基础路径 */
		configuration.setClassForTemplateLoading(FreeMarkerTest02.class, "/ftl");
		
		/** 定义模版需要数据模型(Map集合来封装) */
		Map<String, Object> dataModel = new HashMap<>();
		dataModel.put("users", Arrays.asList(new User(1, "李小一", 20, true, new Date()),
				new User(2, "李小二", 19, true, new Date()),
				new User(3, "李小三", 18, false, new Date())));
		
		/** 获取指定的模版文件，产生模版对象 */
		Template template = configuration.getTemplate("5.ftl");
		/**
		 * 填充模版，输出文件
		 * 第一个参数：数据模型
		 * 第二个参数：输出流
		 */
		template.process(dataModel, new FileWriter(
				new File("C:\\Users\\Administrator\\Desktop\\html\\5.html")));
	}
	
	/** 内置函数 */
	@Test
	public void test6()throws Exception{
		/** 创建Configuration配置信息对象 */
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
		/** 设置加载模版文件的基础路径 */
		configuration.setClassForTemplateLoading(FreeMarkerTest02.class, "/ftl");
		
		/** 定义模版需要数据模型(Map集合来封装) */
		Map<String, Object> dataModel = new HashMap<>();
		/** 获取指定的模版文件，产生模版对象 */
		Template template = configuration.getTemplate("6.ftl");
		/**
		 * 填充模版，输出文件
		 * 第一个参数：数据模型
		 * 第二个参数：输出流
		 */
		template.process(dataModel, new FileWriter(
				new File("C:\\Users\\Administrator\\Desktop\\html\\6.html")));
	}
	
	/** 处理空值、自定义指令 */
	@Test
	public void test7()throws Exception{
		/** 创建Configuration配置信息对象 */
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
		/** 设置加载模版文件的基础路径 */
		configuration.setClassForTemplateLoading(FreeMarkerTest02.class, "/ftl");
		
		/** 定义模版需要数据模型(Map集合来封装) */
		Map<String, Object> dataModel = new HashMap<>();
		/** 获取指定的模版文件，产生模版对象 */
		Template template = configuration.getTemplate("7.ftl");
		/**
		 * 填充模版，输出文件
		 * 第一个参数：数据模型
		 * 第二个参数：输出流
		 */
		template.process(dataModel, new FileWriter(
				new File("C:\\Users\\Administrator\\Desktop\\html\\7.html")));
	}
}

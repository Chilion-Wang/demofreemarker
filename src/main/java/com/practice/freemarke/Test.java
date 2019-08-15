package com.practice.freemarke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Test {
	public static void main(String[] args) throws IOException, TemplateException {
		// 1.配置对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		// 2.模板目录
		configuration.setDirectoryForTemplateLoading(new File("D:\\profession\\java\\JavaProjects\\demofreemaker\\src\\main\\resources"));
		// 3.字符集
		configuration.setDefaultEncoding("utf-8");
		// 4.muban
		Template template = configuration.getTemplate("test.ftt");
		// 5.shujuleixing(map or object)
		Map map = new HashMap();
		map.put("name", "sor");
		map.put("message", "nice to meet you!");
		map.put("success",false);
		
		List goodsList = new ArrayList();
		Map goodsMap1 = new HashMap();
		Map goodsMap2 = new HashMap();
		goodsMap1.put("name", "apple");
		goodsMap2.put("name", "banana");
		goodsList.add(goodsMap1);
		goodsList.add(goodsMap2);
		map.put("goodsList", goodsList);
		
		//日期
		map.put("today", new Date());
		map.put("number", 12345);
		// 6.outputstreamobject
		Writer out = new FileWriter("d:\\test.html"); 
		// 7.output
		template.process(map, out);
		// 8.close out
		out.close();
		
	}
}

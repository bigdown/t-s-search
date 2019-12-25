package com.t.s.dao;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * Desc: mybatis-plus自动生成代码
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月29日
 */
public class CodeGenerator {

	public static void main(String[] args) {
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		String projectPath = "E:/eclipse-workspace/t-s-parent";
		gc.setOutputDir(projectPath + "/t-s-generator/src/main/java");
		gc.setAuthor("CodeGenerator");
		gc.setOpen(false);
		// 覆盖已有文件
		gc.setFileOverride(true);
		gc.setActiveRecord(false);

		// 实体属性 Swagger2 注解
		gc.setSwagger2(true); 
		
		gc.setServiceName("I%sDao");
		gc.setServiceImplName("%sDaoImpl");
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:mysql://127.0.0.1:3306/db_t_s?serverTimezone=Asia/Shanghai&useUnicode=true&useSSL=false&characterEncoding=utf8");
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("1234qwer");
		ITypeConvert typeConvert = new CustomTypeConvert();
		dsc.setTypeConvert(typeConvert);

		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		// 模块名
		pc.setParent("com.t.s");
		pc.setEntity("model");
		pc.setService("dao");
		pc.setServiceImpl("dao.impl");
		pc.setMapper("mapper");
		mpg.setPackageInfo(pc);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};

		// 如果模板引擎是 freemarker
		// String templatePath = "/templates/mapper.xml.ftl";
		// 如果模板引擎是 velocity
		// String templatePath = "/templates/mapper.xml.vm";

		// 自定义输出配置
		List<FileOutConfig> focList = new ArrayList<>();
		// 自定义配置会被优先输出
		// 自定义entity层路径
		focList.add(new FileOutConfig("/templates/entity.java.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + "/t-s-dao/src/main/java/com/t/s/model/" + tableInfo.getEntityName()
						+ StringPool.DOT_JAVA;
			}
		});
		// 自定义mapper层路径
		focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + "/t-s-dao/src/main/java/com/t/s/mapper/" + tableInfo.getEntityName() + "Mapper"
						+ StringPool.DOT_JAVA;
			}
		});
		// 自定义mapper层路径
		focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + "/t-s-dao/src/main/resources/mappers/" + tableInfo.getEntityName() + "Mapper"
					   + StringPool.DOT_XML;
			}
		});

		// 自定义service层路径
		focList.add(new FileOutConfig("/templates/service.java.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + "/t-s-dao/src/main/java/com/t/s/dao/" + "I"
						+ tableInfo.getEntityName() + "Dao" + StringPool.DOT_JAVA;
			}
		});
		// 自定义serviceImpl层路径
		focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + "/t-s-dao/src/main/java/com/t/s/dao/impl/"
						+ tableInfo.getEntityName() + "DaoImpl" + StringPool.DOT_JAVA;
			}
		});

		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 配置模板
		TemplateConfig templateConfig = new TemplateConfig();

		// 配置自定义输出模板
		// 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
		// templateConfig.setEntity("templates/entity2.java");
		// templateConfig.setService("");
		// templateConfig.setController("");

		templateConfig.setXml(null);
		mpg.setTemplate(templateConfig);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		// strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
		strategy.setEntityLombokModel(false);
		strategy.setRestControllerStyle(true);
		// strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
		// 表名，多个英文逗号分割
		String tbNames = "base_goods";
		strategy.setInclude(tbNames.split(","));
		// strategy.setSuperEntityColumns("id");
		strategy.setControllerMappingHyphenStyle(true);
		 strategy.setTablePrefix("");
		mpg.setStrategy(strategy);
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}

}

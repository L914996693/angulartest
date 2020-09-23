package com.angular.angulartest.util;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * mybatis-plus 逆向工程~
 */
public class MybatisGenerator {
    //项目目录
    final static String projectPath = System.getProperty("user.dir");

    //数据库配置
    final static String DBDriver = "oracle.jdbc.driver.OracleDriver";
    final static String DBUrl = "jdbc:oracle:thin:@//192.168.1.107:1521/ORCL";
    final static String DBUsername = "angualrdatabase";
    final static String DBPassword = "angular";

    //程序代码文件
    final static String pageParent = "com.angular.angulartest.dao";
    final static String pageEntity = "entity";
    final static String pageService = "service";
    final static String pageServiceImpl = "service.impl";
    final static String pageMapper = "mapper";
    final static String pageController = "controller";

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("liuwei");
        gc.setOpen(true);
        // service 命名方式
        gc.setServiceName("%sService");
        // service impl 命名方式
        gc.setServiceImplName("%sServiceImpl");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(false);
        mpg.setGlobalConfig(gc);

        // TODO 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DBUrl);
        dsc.setDriverName(DBDriver);
        dsc.setUsername(DBUsername);
        dsc.setPassword(DBPassword);
        mpg.setDataSource(dsc);

        // TODO 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent(pageParent);
        pc.setEntity(pageEntity);
        pc.setService(pageService);
        pc.setServiceImpl(pageServiceImpl);
        pc.setMapper(pageMapper);
        pc.setController(pageController);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setTablePrefix(new String[] { "AN_" });// 此处可以修改为您的表前缀
        // 设置逻辑删除键
        strategy.setLogicDeleteFieldName("is_delete");

        // TODO 指定生成的bean的数据库表名
        strategy.setInclude("AN_RM");//AN_ROLE_MENU AN_ROLE  AN_MENU AN_USER
        //strategy.setSuperEntityColumns("id");
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}

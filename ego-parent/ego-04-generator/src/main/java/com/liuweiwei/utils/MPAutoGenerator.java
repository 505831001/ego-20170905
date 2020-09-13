package com.liuweiwei.utils;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MPAutoGenerator {
    public static void main(String[] args) {
        // 1. 全局配置
        GlobalConfig global = new GlobalConfig();
        global.setActiveRecord(true);  // 是否支持AR模式
        global.setAuthor("liuweiwei"); // 作者
        global.setOutputDir("D:\\workspace-idea\\ego-20170905\\ego-parent\\ego-04-generator\\src\\main\\java"); // 生成路径
        global.setFileOverride(true);  // 文件覆盖
        global.setIdType(IdType.AUTO); // 主键策略
        global.setServiceName("%sService"); // 生成Service首字母是否为"I"
        global.setBaseResultMap(true);  //
        global.setBaseColumnList(true); //
						/*
						// 2. 数据源配置
						DataSourceConfig source = new DataSourceConfig();
						source.setDbType(DbType.ORACLE); // 设置数据库类型
						source.setDriverName("oracle.jdbc.OracleDriver");
						source.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
						source.setUsername("system");
						source.setPassword("oracle123");
						*/
        DataSourceConfig source = new DataSourceConfig();
        source.setDbType(DbType.MYSQL); // 设置数据库类型
        source.setDriverName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://10.58.192.164:3313/bnlecshop");
        source.setUsername("bn_shoppr");
        source.setPassword("qy#sXpN3");
        // 3. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true); // 全局大写
        strategy.setDbColumnUnderline(true); // 指定表名和字段名是否使用下划线
        strategy.setNaming(NamingStrategy.underline_to_camel); // 数据库表名映射到实体的命名策略
        // strategy.setInclude("employees", "departments", "countries"); // 生成的表Oracle
        strategy.setInclude(
                "ls_coupon",
                "ls_sku_marketing",
                "ls_marketing_relevant_coupon"); // 生成的表Mysql
        // 4. 包名策略配置
        PackageConfig packages = new PackageConfig();
        packages.setParent("com.liuweiwei");
        /*
        packages.setEntity("bean");
        packages.setService("service");
        packages.setController("controller");
        packages.setMapper("dao");
        packages.setXml("mapper");
        */
        // 5. 整合配置
        AutoGenerator auto = new AutoGenerator();
        auto.setGlobalConfig(global);
        auto.setDataSource(source);
        auto.setStrategy(strategy);
        auto.setPackageInfo(packages);
        // 6. 执行代码生成器
        auto.execute();
    }
}
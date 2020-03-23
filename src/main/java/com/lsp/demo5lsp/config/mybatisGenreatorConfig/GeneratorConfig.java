package com.lsp.demo5lsp.config.mybatisGenreatorConfig;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author lsp
 * @description TODO
 * @date 2020/3/18 16:48
 **/
public class GeneratorConfig  extends AbstractGeneratorConfig {


    @Override
    public void config() {
        doGlobalConfig();
        doDataSourceConfig();
        doStrategyConfig();
        doPackageConfig();
    }

    protected void doGlobalConfig(){
        //D:\lsp\demo5-lsp\src\main\java\com\lsp\demo5lsp
        globalConfig.setOutputDir("D:\\lsp\\demo5-lsp\\src\\main\\java");//写自己项目（要生成到哪儿一个模块下）的绝对路径,注意具体到java目录
        globalConfig.setFileOverride(true);
        globalConfig.setEnableCache(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setActiveRecord(true);
        globalConfig.setOpen(false);
        globalConfig.setAuthor("lsp");
        globalConfig.setEntityName("%sEntity");
        globalConfig.setIdType(IdType.AUTO);
        globalConfig.setDateType(DateType.TIME_PACK);
    }

    protected void doDataSourceConfig(){
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("newpassword");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/lsp?characterEncoding=utf8&useSSL=true&serverTimezone=UTC");
    }

    protected void doStrategyConfig(){
        //所生成文件忽略的前缀
        // strategyConfig.setTablePrefix(new String[]{"sys_","p_association_"});// 此处可以修改为您的表前缀
        //strategyConfig.setTablePrefix("f_examination_","f_");// 此处可以修改为您的表前缀
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 是否移除实体前缀
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(true);
        //父类的位置路径从java下开始写起 com.lsp.demo5lsp.
        strategyConfig.setSuperEntityClass("com.lsp.demo5lsp.base.entity.BaseEntity");
        strategyConfig.setSuperServiceClass("com.lsp.demo5lsp.base.service.IBaseService");
        strategyConfig.setSuperServiceImplClass("com.lsp.demo5lsp.base.service.impl.BaseServiceImpl");
        strategyConfig.setSuperMapperClass("com.lsp.demo5lsp.base.dao.IBaseMapper");
        strategyConfig.setLogicDeleteFieldName("is_delete");
        //strategyConfig.setEntityLombokModel(true);
        //要生成的表名
        strategyConfig.setInclude("person_info");
        //strategyConfig.setInclude("p_association_starter_union");
    }

    protected void doPackageConfig(){
        packageConfig.setParent(null);
        //设置自动生成的实体,mapper,mapper对应的xml,service的存放路径，从java下开始写起
        packageConfig.setEntity("com.lsp.demo5lsp.base.modular.system.model");
        packageConfig.setMapper("com.lsp.demo5lsp.base.modular.system.dao");
        packageConfig.setXml("com.lsp.demo5lsp.base.modular.system.dao.mapping");
        packageConfig.setService("com.lsp.demo5lsp.base.modular.system.service");
        packageConfig.setServiceImpl("com.lsp.demo5lsp.base.modular.system.service.imp");
    }
}

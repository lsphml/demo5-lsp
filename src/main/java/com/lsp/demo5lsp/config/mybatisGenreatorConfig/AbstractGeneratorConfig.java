package com.lsp.demo5lsp.config.mybatisGenreatorConfig;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import lombok.NoArgsConstructor;


/**
 * @author lsp
 * @description 代码生成器的抽象配置
 * @date 2020/3/18 16:47
 **/
@NoArgsConstructor
public abstract class AbstractGeneratorConfig {

    GlobalConfig globalConfig = new GlobalConfig();

    DataSourceConfig dataSourceConfig = new DataSourceConfig();

    StrategyConfig strategyConfig = new StrategyConfig();

    PackageConfig packageConfig = new PackageConfig();

    public abstract void config();

    public void init(){
        config();
        //controller没用掉,生成之后会手动删掉
        packageConfig.setController("DDDD");
    }

    public void doMpGeneration(){
        init();
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.execute();
    }


}

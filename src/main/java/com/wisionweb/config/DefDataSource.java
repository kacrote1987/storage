package com.wisionweb.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.wisionweb.mapper",sqlSessionTemplateRef ="defSqlSessionTemplate")
public class DefDataSource {
    @Value("${spring.datasource.local.url}")
    private String url;
    @Value("${spring.datasource.local.username}")
    private String username;
    @Value("${spring.datasource.local.password}")
    private String password;
    @Value("${spring.datasource.local.driverClassName}")
    private String driverClassName;
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    /**创建数据源*/
    @Bean(name = "defDS")
    @Primary
    public DataSource getDefDataSource() {
        DataSource build =  DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
        return build;
    }


    /**创建SessionFactory*/
    @Bean(name = "defSqlSessionFactory")
    @Primary
    public SqlSessionFactory defSqlSessionFactory(@Qualifier("defDS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //设置mapper配置文件
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return bean.getObject();
    }

    /**创建事务管理器*/
    @Bean("defTransactionManger")
    @Primary
    public DataSourceTransactionManager firstTransactionManger(@Qualifier("defDS") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**创建SqlSessionTemplate*/
    @Bean(name = "defSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate defSqlSessionTemplate(@Qualifier("defSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
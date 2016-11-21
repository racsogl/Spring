package com.ogl.spring.cache.config;

import com.ogl.spring.cache.aop.CacheTimer;
//import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy
@EnableCaching
@ComponentScan(basePackages = {"com.ogl.spring.cache"})
public class CacheConfig {

//    /**
//     * Cache para desarrollo, pruebas, etc...
//     * Vinculado al ciclo de vida de la aplicación
//     * @return un administrador de cache
//     */
//    @Bean
//    public CacheManager cacheManager() {
//        return new ConcurrentMapCacheManager();
//    }

//    @Bean
//    public EhCacheCacheManager cacheManager(CacheManager cacheManager) {
//        return new EhCacheCacheManager(cacheManager);
//    }
//
//    @Bean
//    public EhCacheManagerFactoryBean ehCache() {
//        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
//        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("/META-INF/cache/ehcache.xml"));
//        return ehCacheManagerFactoryBean;
//    }
//
//    private static final String CLASSPATH = "classpath:/META-INF/cache/db/";
//
//    @Bean(destroyMethod = "shutdown")
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript(CLASSPATH + "schema.sql")
//                .addScript(CLASSPATH + "test-data.sql")
//                .build();
//    }
//
//    @Bean
//    public                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
//
//    @Bean
//    public CacheTimer cacheTimer() {
//        return new CacheTimer();
//    }

}

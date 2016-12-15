package com.ogl.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySources;
import org.springframework.jndi.JndiLocatorDelegate;
import org.springframework.jndi.JndiPropertySource;
import org.springframework.util.FileCopyUtils;

import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.util.Properties;

/**
 * @author Oscar Gonçalves`
 * @version 1.1 2016/10/05
 * @since 1.8
 */
@Configuration
public class DataConfig {

//    private static final String pathSchemaProfileDev = "classpath:/META-INF/MVC_CONCEPTOS/";
//
//    @Bean
//    @Profile("dev")
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript(pathSchemaProfileDev.concat("schema.sql"))
//                .addScript(pathSchemaProfileDev.concat("data.sql"))
//                .build();
//    }


}

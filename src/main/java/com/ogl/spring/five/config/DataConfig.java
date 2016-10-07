package com.ogl.spring.five.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @author Oscar Gonçalves
 * @version 1.1 2016/10/05
 * @since 1.7
 */
@Configuration
public class DataConfig {

    private static final String pathSchemaProfileDev = "classpath:/META-INF/MVC_CONCEPTOS/";

    @Bean
    @Profile("dev")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(pathSchemaProfileDev.concat("schema.sql"))
                .addScript(pathSchemaProfileDev.concat("data.sql"))
                .build();
    }

    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

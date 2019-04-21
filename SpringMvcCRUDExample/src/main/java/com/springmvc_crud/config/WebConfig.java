package com.springmvc_crud.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.springmvc_crud" })
public class WebConfig extends WebMvcConfigurerAdapter {
 
 @Autowired
 DataSource dataSource;
 
 @Bean
 public NamedParameterJdbcTemplate geNamedParameterJdbcTemplate(){
  return new NamedParameterJdbcTemplate(dataSource);
 }
 @Bean
 public DataSource getDataSource(){
  DriverManagerDataSource ds = new DriverManagerDataSource();
  ds.setDriverClassName("com.mysql.jdbc.Driver");
  ds.setUrl("jdbc:mysql://localhost:3306/springcrud");
  ds.setUsername("root");
  ds.setPassword("De@10499");
  
  return ds;
 }
 
 @Override
 public void addResourceHandlers(ResourceHandlerRegistry registry) {
  registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
 }
 
 @Bean
 public InternalResourceViewResolver viewResolver(){
  InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
  viewResolver.setViewClass(JstlView.class);
  viewResolver.setPrefix("/WEB-INF/jsp/");
  viewResolver.setSuffix(".jsp");
  
  return viewResolver;
 }
}
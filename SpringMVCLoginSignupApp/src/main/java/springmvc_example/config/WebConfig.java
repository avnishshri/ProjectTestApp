package springmvc_example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SuppressWarnings("deprecation")
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "springmvc_example" })
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
  ds.setUrl("jdbc:mysql://localhost:3306/springmvc");
  ds.setUsername("root");
  ds.setPassword("De@10499");
  
  return ds;
 }
 
 @Bean
 public InternalResourceViewResolver viewResolver(){
  InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
  viewResolver.setViewClass(JstlView.class);
  viewResolver.setPrefix("/WEB-INF/jsp/");
  viewResolver.setSuffix(".jsp");
  
  return viewResolver;
 }
 
 @Bean
 public ResourceBundleMessageSource messageSource(){
  ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
  rb.setBasenames(new String[]{"validation"});
  
  return rb;
 }
}
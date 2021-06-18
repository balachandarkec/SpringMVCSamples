package in.stack.taskms.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="in.stack.taskms")

public class AppConfig {
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/demo?createDatabaseIfNotExist=true");
		bds.setUsername("root");
		bds.setPassword("root");
		return bds;
	}
	
	
	public Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.hbm2ddl.auto", "create");
		return prop;
		
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(dataSource);
		lsfb.addProperties(getHibernateProperties());
		lsfb.scanPackages("in.stack.taskms");
		return lsfb.buildSessionFactory();
	}
	
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager htm = new HibernateTransactionManager(sessionFactory);
		return htm;
	}
	
	
	
	
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver ivr = new InternalResourceViewResolver();
		ivr.setPrefix("/WEB-INF/views/");
		ivr.setSuffix(".jsp");
		return ivr;
	}

}

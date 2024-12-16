package mx.unam.dgtic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "mx.unam.dgtic")
public class M800Application {

	public static void main(String[] args) {
		SpringApplication.run(M800Application.class, args);
	}

	@Autowired
	private  DataSource dataSource;

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
				new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("mx.unam.dgtic");

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return  entityManagerFactoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				entityManagerFactory(dataSource).getObject()
		);

		return transactionManager;
	}

}

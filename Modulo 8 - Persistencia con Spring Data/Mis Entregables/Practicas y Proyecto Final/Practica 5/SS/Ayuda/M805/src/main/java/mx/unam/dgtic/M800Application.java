package mx.unam.dgtic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
public class M800Application {

	public static void main(String[] args) {
		SpringApplication.run(M800Application.class, args);
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://localhost:3306/modulo8");
		dataSource.setUsername("root");
		dataSource.setPassword("sqlMD3");
		return dataSource;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
				new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("mx.unam.dgtic");

		//Definimos el lenguaje de la base
		Properties jpaProperties = new Properties();
		//jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MariaDB103Dialect");
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}

	//Manipular transacciones
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				entityManagerFactory(dataSource()).getObject()
		);

		return transactionManager;
	}
}

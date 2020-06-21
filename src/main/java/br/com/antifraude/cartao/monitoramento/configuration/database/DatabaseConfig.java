package br.com.antifraude.cartao.monitoramento.configuration.database;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import br.com.antifraude.cartao.monitoramento.common.exceptions.InternalErrorException;

@Configuration
public class DatabaseConfig {

	@Value("${spring.datasource.driver-class-name}")
	private String driver;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${database.user}")
	private String user;

	@Value("${database.pass}")
	private String pass;

	@Value("${spring.jpa.properties.hibernate.default_schema}")
	private String schema;
	
	private DriverManagerDataSource ds;

	@Bean
	@Primary
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DriverManagerDataSource data() {

		try {
			ds = new DriverManagerDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pass);
			ds.setSchema(schema);
			return ds;
		} catch (Exception e) {
			throw new InternalErrorException(e.getLocalizedMessage());
		}
	}	
	
	@Bean(name = "flyway")
	public Flyway flyway() {
		ds = this.data();
		Flyway flyway = Flyway
				.configure()
				.dataSource(ds)
				.schemas(ds.getSchema().toLowerCase())
				.baselineOnMigrate(false)
				.ignoreIgnoredMigrations(true)
				.locations("classpath:db/migration")
				.load();
		flyway.migrate();		
		return flyway;
	}
}

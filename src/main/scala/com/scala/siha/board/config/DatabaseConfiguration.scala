package com.scala.siha.board.config

import java.util.Properties
import javax.persistence.EntityManager
import javax.sql.DataSource

import org.springframework.context.annotation.{Primary, Bean, Configuration}
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.embedded.{EmbeddedDatabaseType, EmbeddedDatabaseBuilder}
import org.springframework.jdbc.datasource.{DriverManagerDataSource}
import org.springframework.orm.jpa.{JpaTransactionManager, LocalContainerEntityManagerFactoryBean}
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (
  entityManagerFactoryRef = "entityManagerFactory",
  transactionManagerRef = "transactionManager",
  basePackages = Array ("com.scala.siha.board")
)
class DatabaseConfiguration() {
  @Bean
  @Primary def dataSource: DataSource = {
    new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build
  }

  @Bean(name = Array("entityManagerFactory"))
  @Primary
  def entityManagerFactory: LocalContainerEntityManagerFactoryBean = {
    val entityManagerFactoryBean: LocalContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean
    entityManagerFactoryBean.setDataSource(dataSource)
    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter)
    entityManagerFactoryBean.setJpaProperties(jpaProperties)
    entityManagerFactoryBean.setPackagesToScan("com.scala.siha.board")
    entityManagerFactoryBean.setPersistenceUnitName("persistenceUnit1")
    entityManagerFactoryBean
  }

  @Bean(name = Array("transactionManager"))
  @Primary
  def transactionManager: JpaTransactionManager = {
    val transactionManager: JpaTransactionManager = new JpaTransactionManager
    transactionManager.setEntityManagerFactory(entityManagerFactory.getObject)
    transactionManager.setDataSource(dataSource)
    transactionManager
  }

  @Bean(name = Array("entityManager"))
  def entityManager: EntityManager = {
    entityManagerFactory.getObject.createEntityManager
  }

  @Bean
  def jpaProperties: Properties = {
    val properties: Properties = new Properties
    properties.setProperty("hibernate.hbm2ddl.auto", "create-drop")
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
    properties.setProperty("hibernate.show_sql", "true")
    properties.setProperty("hibernate.format_sql", "true")
    return properties
  }
}

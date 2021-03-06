name := "scala-board"

version := "1.0"

scalaVersion := "2.10.4"

sbtVersion := "0.13.0"

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "1.0.2.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-data-jpa" % "1.0.2.RELEASE",
  "org.webjars" % "bootstrap" % "3.1.1",
  "org.webjars" % "jquery" % "2.1.0-2",
  "org.thymeleaf" % "thymeleaf-spring4" % "2.1.2.RELEASE",
  "org.hibernate" % "hibernate-validator" % "5.0.2.Final",
  "nz.net.ultraq.thymeleaf" % "thymeleaf-layout-dialect" % "1.2.1",
  "com.h2database" % "h2" % "1.4.182",
  "org.hsqldb" % "hsqldb" % "2.3.1",
  "org.springframework.boot" % "spring-boot-starter-tomcat" % "1.0.2.RELEASE" % "provided",
  "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"
)


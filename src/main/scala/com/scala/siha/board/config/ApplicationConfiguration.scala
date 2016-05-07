package com.scala.siha.board.config

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.{ComponentScan, Configuration}

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = Array("com.scala.siha.board"))
class ApplicationConfiguration
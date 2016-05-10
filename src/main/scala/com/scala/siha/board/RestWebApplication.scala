package com.scala.siha.board

import com.scala.siha.board.config.{DatabaseConfiguration, ApplicationConfiguration}
import org.springframework.boot.SpringApplication

object RestWebApplication extends App{
  override def main(args: Array[String]) {
    val configuration: Array[Object] = Array(classOf[ApplicationConfiguration], classOf[DatabaseConfiguration])
    SpringApplication.run(configuration, args)
  }
}

package com.scala.siha.board.infra

import javax.annotation.PostConstruct

import com.scala.siha.board.core.service.ContentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{ResponseBody, RequestMapping, RequestMethod}

@Controller
class ContentController @Autowired()(private val contentService: ContentService) {
  @PostConstruct
  def init(): Unit = {
    contentService.create("test1", "content-1")
    contentService.create("test2", "content-2")
  }
  @RequestMapping(value = Array("/list"), method = Array(RequestMethod.GET))
  @ResponseBody def requestTestPage(): String = {
    contentService.list().toString()
  }
}

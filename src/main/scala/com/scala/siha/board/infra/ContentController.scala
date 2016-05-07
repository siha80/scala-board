package com.scala.siha.board.infra

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ContentController {

  @RequestMapping(Array("/test"))
  def requestRoot(): String = "redirect:naver.com"
}

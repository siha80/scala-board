package com.scala.siha.board.infra

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{ResponseBody, RequestMapping, RequestMethod}

@Controller
class ContentController {
  @RequestMapping(value = Array("/test-1"), method = Array(RequestMethod.GET))
  @ResponseBody def requestTestPage(): String = {
    "test1111"
  }
}

package com.scala.siha.board.core.service

import org.springframework.stereotype.Service

import scala.collection.JavaConverters._
import com.scala.siha.board.core.domain.ContentInformation
import com.scala.siha.board.core.repository.ContentInformationRepository
import org.springframework.beans.factory.annotation.Autowired

@Service
class ContentService @Autowired()(private val contentInformationRepository: ContentInformationRepository) {
  def list(): String = {
    contentInformationRepository.findAll().asScala.toList.map(c => s"TITLE: ${c.getSubject}, CONTENT: ${c.getContent}").mkString("<BR>")
  }

  def create(subject: String, content: String): ContentInformation = {
    contentInformationRepository.save(ContentInformation(subject, content))
  }
}

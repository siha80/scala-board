package com.scala.siha.board.core.service

import org.springframework.stereotype.Service

import scala.collection.JavaConverters._
import com.scala.siha.board.core.domain.ContentInformation
import com.scala.siha.board.core.repository.ContentInformationRepository
import org.springframework.beans.factory.annotation.Autowired

@Service
class ContentService @Autowired()(private val contentInformationRepository: ContentInformationRepository) {
  def list(subject: Option[String]): String = {
    val result = subject match {
      case Some(subject) => contentInformationRepository.findBySubjectContaining(subject).asScala.map(_.toString).mkString("<BR>")
      case None => contentInformationRepository.findAll().asScala.map(_.toString).mkString("<BR>")
    }
    result
  }

  def create(subject: String, content: String): ContentInformation = {
    contentInformationRepository.save(ContentInformation(subject, content))
  }
}

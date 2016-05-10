package com.scala.siha.board.core.domain

import javax.persistence._

import scala.beans.BeanProperty

@Entity
@Table(name = "TB_CONTENT")
case class ContentInformation(
                               @BeanProperty var subject: String,
                               @BeanProperty var content: String
                               ) {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  @Column(name = "INDEX")
  var id: String = _
  def this() = this(null, null)

  override def toString(): String = s"TITLE: ${getSubject}, CONTENT: ${getContent}"
}

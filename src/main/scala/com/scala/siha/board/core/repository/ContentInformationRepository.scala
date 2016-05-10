package com.scala.siha.board.core.repository

import com.scala.siha.board.core.domain.ContentInformation
import org.springframework.data.jpa.repository.JpaRepository

trait ContentInformationRepository extends JpaRepository[ContentInformation, String] {
}

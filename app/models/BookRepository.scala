package models

import models.Book
import scala.util.Try

trait BookRepository {
  def findAll(): Try[Seq[Book]]
}

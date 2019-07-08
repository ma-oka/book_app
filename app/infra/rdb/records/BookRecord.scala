package infra.rdb.records

import java.time.LocalDate
import models._
import scalikejdbc._

case class BookRecord(id: String,
                      name: String,
                      author: Option[String],
                      publishedDate: Option[LocalDate],
                      description: Option[String])

object BookRecord extends SQLSyntaxSupport[BookRecord] {

  def apply(book: Book): BookRecord = new BookRecord(
    book.id,
    book.name.value,
    book.author.map(_.value),
    book.publishedDate.map(_.value),
    book.description.map(_.value)
  )

  def apply(rn: ResultName[BookRecord])(rs: WrappedResultSet): BookRecord =
    new BookRecord(
      rs.string("id"),
      rs.string("name"),
      rs.stringOpt("author"),
      rs.localDateOpt("published_date"),
      rs.StringOpt("description")
    )
}

package adapters.gateway.repositories.dbaccess

import doobie._
import doobie.implicits._

import scala.concurrent.ExecutionContext
import cats.effect.IO
import entities.domain.account.{Account, Email}
import entities.domain.repositories.AccountRepository

class AccountRepositoryByDbAccess extends AccountRepository {

  implicit val cs = IO.contextShift(ExecutionContext.global)

  val xa = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver",
    "jdbc:postgresql:world",
    "postgres",
    ""
  )

  def findBy(email: Email): IO[Option[Email]] =
    sql"select email from account where email = ${email.value}"
      .query[Email]
      .option
      .transact(xa)

  def store(account: Account): IO[Account] =
    (for {
      _ <-
        sql"insert into account (name, email, password) values ${account.name} ${account.email}, ${account.password}"
          .update
          .run
      email <-
        sql"select email from account where email = ${account.email}"
          .query[Email]
          .unique
      account <- sql"select name, email, password from account where email = $email"
          .query[Account]
          .unique
    } yield account).transact(xa)

}

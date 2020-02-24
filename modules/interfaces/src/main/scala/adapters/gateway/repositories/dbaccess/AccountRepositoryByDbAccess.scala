package adapters.gateway.repositories.dbaccess

import entities.domain.{Account, AccountId, Email}
import repositories.AccountRepository

import cats.effect.IO

class AccountRepositoryByDbAccess extends AccountRepository {

  override def findBy(email: Email): Option[AccountId] = None

  override def store(account: Account): IO[Unit] = IO { println(s"Stored: $account") }

}
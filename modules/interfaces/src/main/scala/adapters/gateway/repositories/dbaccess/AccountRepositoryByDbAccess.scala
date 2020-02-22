package adapters.gateway.repositories.dbaccess

import entities.domain.{Account, AccountId, Email}
import repositories.AccountRepository

class AccountRepositoryByDbAccess extends AccountRepository {

  override def findBy(email: Email): Option[AccountId] = None

  override def store(account: Account): Unit = println(s"Stored: $account")

}
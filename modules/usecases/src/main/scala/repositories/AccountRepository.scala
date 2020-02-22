package repositories

import entities.domain.{Email, AccountId}

trait AccountRepository extends AccountSingleWriter {
  def findBy(email: Email): Option[AccountId]
}
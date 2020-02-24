package repositories

import entities.domain.{Email, AccountId}

trait AccountRepository extends AccountWriter {
  def findBy(email: Email): Option[AccountId]
}
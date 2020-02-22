package repositories

import entities.domain.{Account}

trait AccountSingleWriter {
  def store(account: Account): Unit
}
package repositories

import entities.domain.Account

trait AccountWriter {
  def store(account: Account): Unit
}
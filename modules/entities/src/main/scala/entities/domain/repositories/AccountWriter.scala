package entities.domain.repositories

import cats.effect.IO
import entities.domain.account.Account

trait AccountWriter {
  def store(account: Account): IO[Account]
}
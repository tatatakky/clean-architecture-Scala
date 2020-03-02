package repositories

import entities.domain.Account

import cats.effect.IO

trait AccountWriter {
  def store(account: Account): IO[Account]
}
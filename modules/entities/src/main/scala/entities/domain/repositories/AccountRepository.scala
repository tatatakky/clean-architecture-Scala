package entities.domain.repositories

import cats.effect.IO
import entities.domain.account.Email

trait AccountRepository extends AccountWriter {
  def findBy(email: Email): IO[Option[Email]]
}
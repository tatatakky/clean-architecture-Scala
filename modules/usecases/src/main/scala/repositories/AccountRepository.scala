package repositories

import entities.domain.Email
import cats.effect.IO

trait AccountRepository extends AccountWriter {
  def findBy(email: Email): IO[Option[Email]]
}
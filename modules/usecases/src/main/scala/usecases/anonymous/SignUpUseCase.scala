package usecases.anonymous

import cats.effect.IO
import usecases.{UseCase, UseCaseError}
import usecases.UseCaseError.AlreadyExists
import entities.domain._
import entities.domain.account.{Account, Email, Name, Password}
import entities.domain.repositories.AccountRepository

case class SignUpInput(name: Name, email: Email, password: Password)
case class SignUpOutput(name: Name, email: Email)

/**
  * Here is UseCase Interactor
  * @param accountRepository
  */
class SignUpUseCase(accountRepository: AccountRepository)
    extends UseCase[SignUpInput, SignUpOutput] {
  def execute(inputData: SignUpInput): Either[UseCaseError, SignUpOutput] =
    (for {
      maybe <- accountRepository.findBy(inputData.email)
      result <- maybe.map{_ =>
        IO{AlreadyExists}
      }.getOrElse(
        accountRepository.store(Account(
          inputData.name,
          inputData.email,
          inputData.password)
        )
      )
    } yield {
      result match {
        case ae@AlreadyExists => Left(ae)
        case acc: Account => Right(SignUpOutput(acc.name, acc.email))
      }
    }).unsafeRunSync()
}

package usecases.anonymous

import usecases.{UseCase, UseCaseError}
import usecases.UseCaseError.AlreadyExists
import entities.domain._
import repositories.AccountRepository

case class SignUpInput(name: Name, email: Email, password: Password)
case class SignUpOutput(name: Name, email: Email)

/**
  * Here is UseCase Interactor
  * @param accountRepository
  */
class SignUpUseCase(accountRepository: AccountRepository)
    extends UseCase[SignUpInput, SignUpOutput] {
  def execute(inputData: SignUpInput): Either[UseCaseError, SignUpOutput] =
    accountRepository
      .findBy(inputData.email)
      .unsafeRunSync()
      .map { _ =>
        Left(AlreadyExists)
      }
      .getOrElse {
        val account = (for {
          account <- accountRepository.store(
            Account(inputData.name, inputData.email, inputData.password))
        } yield account).unsafeRunSync()
        Right(SignUpOutput(account.name, account.email))
      }
}

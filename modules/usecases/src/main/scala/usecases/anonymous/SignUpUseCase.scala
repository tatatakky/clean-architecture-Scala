package usecases.anonymous

import usecases.{UseCase, UseCaseError}
import usecases.UseCaseError.AlreadyExists
import entities.domain._
import repositories.AccountRepository

case class SignUpInput(email: Email, password: Password, name: AccountName)
case class SignUpOutput(id: AccountId)

/**
  * Here is UseCase Interactor
  * @param accountRepository
  */
class SignUpUseCase(accountRepository: AccountRepository)
    extends UseCase[SignUpInput, SignUpOutput] {
  def execute(inputData: SignUpInput): Either[UseCaseError, SignUpOutput] =
    accountRepository
      .findBy(inputData.email)
      .map { _ =>
        Left(AlreadyExists)
      }
      .getOrElse {
        accountRepository.store(
          Account(inputData.email, inputData.password, inputData.name))
        Right(SignUpOutput(AccountId(10L)))
      }
}

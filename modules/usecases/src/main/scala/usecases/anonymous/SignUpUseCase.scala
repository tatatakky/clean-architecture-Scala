package usecases.anonymous

import usecases.UseCase
import entities.domain._
import repositories.AccountRepository

case class SignUpInput(email: Email, password: Password, name: AccountName)
case class SignUpOutput(id: AccountId)

/**
 * Here is UseCase Interactor
 * @param accountRepository
 */
class SignUpUseCase(accountRepository: AccountRepository) extends UseCase[SignUpInput, SignUpOutput] {
  def execute(inputData: SignUpInput): SignUpOutput = {
    accountRepository.findBy(inputData.email) match {
      case None => {
        accountRepository.store(Account(inputData.email, inputData.password, inputData.name))
        SignUpOutput(AccountId(10L))
      }
      case Some(_) => {
        SignUpOutput(AccountId(0L))
      }
    }
  }
}
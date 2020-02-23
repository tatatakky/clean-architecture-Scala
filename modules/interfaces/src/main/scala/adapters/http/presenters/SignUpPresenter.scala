package adapters.http.presenters

import entities.domain.AccountId
import usecases.UseCaseError.AlreadyExists
import usecases.UseCaseError
import usecases.anonymous.SignUpOutput

trait SignUpPresenter extends Presenter[Output] {
  def convert(outputData: Either[UseCaseError, SignUpOutput]): Output =
    outputData match {
      case Right(value) => Success(value.id)
      case Left(e) => e match {
        case AlreadyExists => Failure("Already Exists Error")
        case _             => Failure("Something Error")
      }
    }
}

sealed trait Output
case class Success(accountId: AccountId) extends Output
case class Failure(message: String) extends Output
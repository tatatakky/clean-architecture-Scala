package adapters.http.presenters

import usecases.UseCaseError
import usecases.anonymous.SignUpOutput

trait Presenter[OutputData] {

  def responce(outputData: Either[UseCaseError, SignUpOutput]): Output = convert(outputData)

  def convert(outputData: Either[UseCaseError, SignUpOutput]): Output

}
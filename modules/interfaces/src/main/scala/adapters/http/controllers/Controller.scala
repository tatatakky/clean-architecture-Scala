package adapters.http.controllers

import wvlet.airframe._
import usecases.anonymous.{SignUpInput, SignUpOutput, SignUpUseCase}
import adapters.http.presenters._

trait Controller {

  private val signUpUseCase = bind[SignUpUseCase]
  private val signUpPresenter = bind[SignUpPresenter]

  def signUp(input: SignUpInput): Output =
    signUpPresenter.convert(signUpUseCase.execute(input))

}
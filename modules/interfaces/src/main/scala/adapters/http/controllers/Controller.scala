package adapters.http.controllers

import wvlet.airframe._
import usecases.anonymous.{SignUpInput, SignUpOutput, SignUpUseCase}
import adapters.http.presenters._
import entities.domain.Email


trait Controller {

  private val signUpUseCase = bind[SignUpUseCase]
  private val signUpPresenter = bind[SignUpPresenter]

  def signUp(input: SignUpInput): SignUpOutput =
    signUpPresenter.convert(signUpUseCase.execute(input))

}
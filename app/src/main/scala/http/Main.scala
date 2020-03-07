package http

import adapters.DISettings
import adapters.http.controllers.Controller
import entities.domain.account.{Email, Name, Password}
import usecases.anonymous.SignUpInput

object Main extends App {
  private val design  = DISettings.designOfRepositories
  private val session = design.newSession
  session.start
  val controller =
    session.build[Controller]
  val signUpInput: SignUpInput = SignUpInput(Name("Foo"),Email("x@x.com"), Password("password"))
  val res = controller.signUp(signUpInput)
  println(res)
}
package http

import adapters.DISettings
import adapters.http.controllers.Controller
import entities.domain.{AccountName, Email, Password}
import usecases.anonymous.SignUpInput

object Main extends App {
  private val design  = DISettings.designOfRepositories
  private val session = design.newSession
  session.start
  val controller =
    session.build[Controller]
  val res = controller.signUp(SignUpInput(Email("x@x.com"), Password("xxx"), AccountName("Bar")))
  println(res)

}
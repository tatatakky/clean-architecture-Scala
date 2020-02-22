package adapters.http.presenters

import usecases.anonymous.SignUpOutput

trait SignUpPresenter extends Presenter[SignUpOutput] {
  def convert(outputData: SignUpOutput): SignUpOutput = outputData
}
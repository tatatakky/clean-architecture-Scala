package adapters.http.presenters

trait Presenter[OutputData] {

  def responce(outputData: OutputData): OutputData = convert(outputData)

  def convert(outputData: OutputData): OutputData

}
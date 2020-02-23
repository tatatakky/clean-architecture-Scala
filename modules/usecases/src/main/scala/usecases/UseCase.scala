package usecases

trait UseCase[InputData, OutputData] {

  def execute(inputData: InputData): Either[UseCaseError, OutputData]

}
package usecases

sealed trait UseCaseError
object UseCaseError {
  case object AlreadyExists extends UseCaseError
}

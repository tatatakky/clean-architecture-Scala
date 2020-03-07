package adapters

import entities.domain.repositories.AccountRepository
import gateway.repositories.dbaccess.AccountRepositoryByDbAccess
import wvlet.airframe._

trait DISettings {
  def designOfRepositories: Design =
    newDesign
      .bind[AccountRepository].to[AccountRepositoryByDbAccess]
}

object DISettings extends DISettings
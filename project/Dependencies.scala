import sbt._

object Wvlet {
  val version = "20.2.1"
  val airframe = "org.wvlet.airframe" %% "airframe" % version
}

object CatsEffect {
  val version = "2.1.1"
  val effect = "org.typelevel" %% "cats-effect" % version
}

object Cats {
  val version = "2.1.0"
  val core = "org.typelevel" %% "cats-core" % version
}

object Doobie {
  val version = "0.8.8"
  val core = "org.tpolecat" %% "doobie-core" % version
}
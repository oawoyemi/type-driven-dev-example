object TypeTetris {
  import scala.concurrent.Future

  sealed trait Request //agebraic data type

  object Request {
    final case class Unauthorized() extends Request
    final case class Authorized() extends Request
  }

  sealed trait Response

  object Response {
    final case class Unauthorized() extends Response
  }

  def service(request: Request.Unauthorized): Future[Response] = {
    val authorized = authorize(request)
    authorized
      .map(r ⇒ ???)
      .getOrElse(Future.successful(Response.Unauthorized()))
  }

  def authorize(request: Request.Unauthorized): Option[Request.Authorized] = ???
}

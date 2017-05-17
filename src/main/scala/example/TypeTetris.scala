object TypeTetris {
  import scala.concurrent.Future

  sealed trait Request //agebraic data type

  object Request {
    final case class Unauthorized() extends Request
    final case class Authorized() extends Request
  }

  // abstract types
  type Response

  def service(request: Request.Unauthorized): Future[Response] = {
    val authorized = authorize(request)
    ???
  }

  def authorize(request: Request.Unauthorized): Option[Request.Authorized] = ???
}

package example

import scala.concurrent.Future

object TypeTetris {

  sealed trait Request //agebraic data type

  object Request {
    case class Unauthorized(secret: String) extends Request
    case class Authorized() extends Request
  }

  sealed trait Response

  object Response {
    case class Unauthorized() extends Response
    case class Authorized() extends Response
    case class Success(body: String) extends Response
  }

  def service(request: Request.Unauthorized): Future[Response] = {
    val authorized = authorize(request)
    authorized
      .map(doWork)
      .getOrElse(Future.successful(Response.Unauthorized()))
  }

  def authorize(request: Request.Unauthorized): Option[Request.Authorized] =
    if (request.secret == "secret") Some(Request.Authorized()) else None

  def doWork(request: Request.Authorized): Future[Response] =
    Future.successful(Response.Success(body = "well done"))
}

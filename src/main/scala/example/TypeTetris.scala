object TypeTetris {
  import scala.concurrent.Future

  // abstract types
  type Request
  type Response

  def service(request: Request): Future[Response] = ???
}

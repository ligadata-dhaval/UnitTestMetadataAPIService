import dispatch._
import org.scalatest._
import org.scalatest.time._

/**
 * Unit test specification
 *
 * Created by ejunxsh on 4/2/14.
 */
trait UnitSpec extends FunSpec with BeforeAndAfter with Matchers with concurrent.ScalaFutures {
  implicit val config = PatienceConfig(scaled(Span(1500, Millis)), scaled(Span(15, Millis)))
  // you can customize the http client executor here
  lazy val http = new Http
}

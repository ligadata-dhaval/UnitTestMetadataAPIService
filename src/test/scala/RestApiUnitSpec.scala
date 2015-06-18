import dispatch._, Defaults._

/**
 * Unit spec
 *
 * Created by ejunxsh on 4/2/14.
 */
class RestApiUnitSpec extends UnitSpec {
  //val service = moocoo(3000)

  describe("A metadata API service for CRUD operations on messages") {
    //val host = :/("localhost",8081).secure
    val host = :/("demo1319324.mockable.io")

    it("should upload a new message object to the metadata server (C)") {
      val request=host / "api" /"keys"/"message"
      whenReady(http(request)) {
        result => result.getStatusCode should be (200)
      }
    }

    it("should get all the messages in a metadata server (R)") {
      val request=host / "api" /"keys"/"message"
      whenReady(http(request OK dsl.asJson)) {
        json =>
          (json \ "APIResults" \ "Result Description").as[String] should be ("Successfully fetched all object keys")
      }
    }

  }

}

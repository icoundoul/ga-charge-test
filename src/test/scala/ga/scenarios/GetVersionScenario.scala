package ga.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import ga.Constants.V_USERS
import ga.scenarios.HttpProtocol.INSTANCE

class GetVersionScenario extends Simulation {

  private val feeder = csv("search-keywords.csv").random

  val httpProtocol = http
    .baseURL("http://webpage")
    .acceptHeader("text/html,text/xml,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .connection("keep-alive")
  
  private val scn = scenario("Search using keywords")
   .exec(http("Get version")
  .post("/")
   .body(StringBody("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:sch=\"http://www.awl.net/tum/els/ga/schema/\">
   <soapenv:Header>
      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">
         <wsse:UsernameToken wsu:Id=\"UsernameToken-1\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">
            <wsse:Username>x2</wsse:Username>
            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">x2.hulk</wsse:Password>
         </wsse:UsernameToken>
      </wsse:Security>
   </soapenv:Header>
   <soapenv:Body>
      <sch:getVersionRequest/>
   </soapenv:Body>
</soapenv:Envelope>")))

  setUp(scn.inject(atOnceUsers(V_USERS))).protocols(INSTANCE)
}

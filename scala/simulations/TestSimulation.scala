package simulations

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TestSimulation extends Simulation
{
  val httpComf = http.baseUrl(url = "https://dungeon.su/")
    .header("Accept", "application/json")
    .header("content-type", "application/json")

  val sc = scenario (scenarioName = "requests")
    .exec(http(requestName = "get trinkes request")
      .get("loot/random/trinkets/")
      .check(status is 200)
    )
    .exec(http(requestName = "get coins request")
      .get("loot/random/coins/11/")
      .check(status is 200)
    )
    .exec(http(requestName = "get spells request")
      .get("loot/random/coins/11/")
      .check(status is 200)
    )

  setUp(sc.inject(atOnceUsers(200))).protocols(httpComf)
}
import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should return four when number is 2 and 2"
    request{
        method GET()
        url("/calculator/add") {
            queryParameters {
                parameter("a", "2")
                parameter("b", "2")
            }
        }
    }
    response {
        body("4")
        status 200
    }
}
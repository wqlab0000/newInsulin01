package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

// class InsulinPump {
//     static String insulinPump(String status) {
// 	if (status.equals("OFF")) {
// 	    return "basalDose";
// 	}
//     return "noDose";
//     }
// }

public class Stepdefs {
    private String status;
    private String actualDose;

    @Given("^insulin pump \"([^\"]*)\"$")
    public void insulin_pump(String status) {
        this.status = status;
    }

    @When("^insulin pump turns on$")
    public void insulin_pump_turns_on() {
        this.actualDose = InsulinPump.insulinPump(status);
    }

    @Then("^insulin pump delivers \"([^\"]*)\"$")
    public void insulin_pump_delivers(String expectedDose) {
        assertEquals(expectedDose, actualDose);
    }
}

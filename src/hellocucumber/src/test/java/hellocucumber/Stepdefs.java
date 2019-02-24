package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

public class Stepdefs {
     private String status;
     private String actualDose;

@Given("^Insulin Pump is OFF$")
public void insulin_pump_is_off() {
    status = "OFF";
}

@When("^Insulin Pump turns on$")
public void insulin_pump_turns_on() {
    actualDose = InsulinPump.insulinPump("OFF");
}

@Then("^Insulin Pump delivers \"([^\"]*)\"$")
public void i_should_be_told(String expectedDose) {
    assertEquals(expectedDose, actualDose);
}
}

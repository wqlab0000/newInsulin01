package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;



public class Stepdefs {
     private int glucose;
     private String actualDose;

@Given("^Insulin Pump shows current glucose level is \"([^\"]*)\"$")
public void insulin_pump_shows_current_glucose_level_is(int glucose) {
    this.glucose = glucose;
}

@When("^Insulin Pump turns on$")
public void insulin_pump_turns_on() {
    actualDose = InsulinPump.insulinPump(glucose);
}

@Then("^Insulin Pump delivers \"([^\"]*)\"$")
public void insulin_pump_delivers(String expectedDose) {
    assertEquals(expectedDose, actualDose);
}


}

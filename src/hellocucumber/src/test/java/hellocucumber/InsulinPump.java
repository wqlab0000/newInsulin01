package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

class InsulinPump {
    static String insulinPump(String status) {
	if (status.equals("OFF")) {
	    return "basalDose";
	}
    return "noDose";
    }
}

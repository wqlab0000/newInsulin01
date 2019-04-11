package hellocucumber;
class InsulinPump {
  /*@  public normal_behavior
    @ requires glucose >= 250;
    @ ensures \result == "2";
    @ also
    @ requires glucose < 250 && glucose > 120 ;
    @ ensures \result == "0.5";
    @ also
    @ requires glucose <= 120 ;
    @ ensures \result == "0";
    @*/

    static String insulinPump(String glucose) {
	if (glucose >=250) {
	    return "2";
	}
	if (glucose < 250 && glucose > 120){
      return "0.5";
  }
      return "0";
}
}


Feature: Insulin Pump on?
  Insulin pump delivers insulin or not

  Scenario Outline:   Insulin pump delivers basal dose or no dose

    Given insulin pump  "<status>"
    When insulin pump turns on
    Then insulin pump delivers "<dose>"

  Examples:
    | status | dose |
    | OFF | basalDose |
    | Empty | noDose |
    | anything else! | noDose |

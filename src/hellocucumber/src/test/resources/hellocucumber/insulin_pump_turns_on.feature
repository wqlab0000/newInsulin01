Feature: Insulin Pump delivers insulin dose once turned on

Scenario Outline: Insulin Pump delivers insulin dose
Given Insulin Pump shows current glucose level is "<glucose>"
When Insulin Pump turns on
Then Insulin Pump delivers "<dose>"

Examples:
| glucose | dose |
| 250     | 2 |
| 150     | 0.5 |
| 200     | 0.5 |

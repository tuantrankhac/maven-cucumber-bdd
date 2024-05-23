@dataTable
Feature: DataTable feature

  @datatable_step
  Scenario Outline: Scenario have parameter
    Given Open Facebook application
    When Input to Username and Password
    |Username					|Password  |
    |<Username>  			|<Password>|
    And Click to Login button
    And Close application
    
    Examples:
    |Username					| Password |Customer Name|  City |Address|   Phone   |
    |test9909@qa.team | Test123! |   Lio Mio   | Ha Noi|Ha Dong| 0342002011|
    
    
  @datatable_scenario
  Scenario Outline: Data Table in Scenario
  	Given Open Facebook application
  	When Input to Username textbox with "<Username>"
    And Input to Password textbox with "<Password>"
    And Click to Login button
    And Close application
    
   Examples:
    |Username					| Password |
    |test110@qa.team 	| Test123! |
    |test2202@qa.team | Test123! |
    |test3303@qa.team | Test123! |
    
    
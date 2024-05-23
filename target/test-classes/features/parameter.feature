@parameter
Feature: Parameter feature

#Background:
#	Given Open Facebook application

  @no-param
  Scenario: Scenario have no parameter
#    Given Open Facebook application
    When Input to Username textbox
    And Input to Password textbox
    And Click to Login button
#    And Close application

	@param_mark
	Scenario: Scenario have parameter
#    Given Open Facebook application
    When Input to Username textbox with "test9909@qa.team"
    And Input to Password textbox with "Test123!"
    And Click to Login button
#    And Close application

  @multiple_param
	Scenario: Scenario have parameter
#    Given Open Facebook application
    When Input to Username textbox with "test9909@qa.team" and Password with "Test123!"
    And Click to Login button
#    And Close application

  
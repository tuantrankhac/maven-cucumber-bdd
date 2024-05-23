package pageUIs.nopCom;

public class RegisterPageUI {
	public static final String GENDER_MALE_RADIO = "//input[@id='gender-male']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String SUCCSES_MESSAGE_REGISTER = "//div[@class='result' and text()='Your registration completed']";
	
	public static final String CONTINUE_BUTTON = "//a[text()='Continue']";
	public static final String ERROR_MESSAGE_FIRST_NAME = "//span[@id='FirstName-error' and text()='First name is required.']";
	public static final String ERROR_MESSAGE_LAST_NAME = "//span[@id='LastName-error' and text()='Last name is required.']";
	public static final String ERROR_MESSAGE__WRONG_EMAIL = "//span[@id='Email-error' and text()='Wrong email']";
	public static final String ERROR_MESSAGE__EMPTY_EMAIL = "//span[@id='Email-error' and text()='Email is required.']";
	public static final String ERROR_MESSAGE_PASSWORD = "//span[@id='Password-error' and text()='Password is required.']";
	public static final String ERROR_MESSAGE_CF_PASSWORD = "//span[@id='ConfirmPassword-error' and text()='Password is required.']";
	public static final String ERROR_MESSAGE_EXIST_EMAIL = "//div[@class='message-error validation-summary-errors']//li";
	
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
	
	
}
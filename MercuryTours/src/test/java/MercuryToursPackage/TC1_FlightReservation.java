package MercuryToursPackage;

public class TC1_FlightReservation {

	public static void main(String[] args) throws Exception {
		
		LaunchBrowser chromeBrowser=new LaunchBrowser();
		chromeBrowser.LunchBrowser();
		chromeBrowser.TitleCheck();
		
		Login user =new Login();
		user.LoginCredentials("Mercury", "Mercury");
		user.CheckSucessLogin();
		
		FindFlight flight= new FindFlight();
		flight.ClickOnFlightsLinks();
		
		CloseBrowser chrome=new CloseBrowser();
		chrome.CloseBrowser();
	}
}

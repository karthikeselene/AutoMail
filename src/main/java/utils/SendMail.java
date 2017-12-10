package utils;

public class SendMail {

	public static void main(String[] args) {
		System.out.println("Sending...");
		AutomaticSendMail.sendByGmail("karthi89.infotech@gmail.com", "Test Mail");
		System.out.println("Sent.");
	}

}

package technical;

public class EmailService {
    
    int parameter1;
    String parameter2;
    
    public void sendEmail(String p1, String p2, String p3) {
    
        String mail = "Dear Sir/Madam" + "\n" +
        "We would like to order " + p1 + " amount of " + p2 + "\n" +
        "Thank you for your cooperation" + "\n" +
        "Sincerely" + "\n" + p3;
        System.out.println(mail);
        
                
        // sendmail
        
    }
    
}

package lesson18;

public class Definition {
    private void notifyUsers(String[] userEmails){

        for(String email: userEmails){
            //обработка ошибок

            try {
                System.out.println("Email " + email+" was sent ");
                //send email to user - error
            }
            catch (Exception e){
                System.out.println("Email " + email+" was not sent ");
                //how should I handle exception
            }
            finally {

            }
        }


    }
}

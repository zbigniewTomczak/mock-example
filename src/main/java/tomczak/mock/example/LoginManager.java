package tomczak.mock.example;

public class LoginManager 
{
    private ILogger logger;
    public LoginManager(ILogger logger) {this.logger = logger;}
    public boolean login(String username, String password) {
        logger.write("Login attempt"); //we're testing this interaction
        return true;
    }
}

package tomczak.mock.example;

import org.junit.Assert;
import org.junit.Test;

import org.easymock.EasyMock;
import org.mockito.Mockito;

//We're testing the same things 3 times
public class LoginManagerTest {

  class ManualFakeLogger implements ILogger {
    public String text;
    public void write(String s) {
        this.text = s;
    }
  }
  
  @Test
  //Once using manual fake mock
  public void login_WhenCalled_WritesToLog() {
    ManualFakeLogger mockLog = new ManualFakeLogger();
    LoginManager loginManager = new LoginManager(mockLog);
    loginManager.login("","");
    
    Assert.assertEquals("Login attempt", mockLog.text);
  }
  
  @Test
  //Second using EasyMock framework
  public void login_WhenCalled_WritesToLog2() {
    ILogger mockLog = EasyMock.createMock(ILogger.class);
    LoginManager loginManager = new LoginManager(mockLog);
    
    mockLog.write("Login attempt");
    EasyMock.replay(mockLog);
    
    loginManager.login("","");
    EasyMock.verify(mockLog);
  }
  
  @Test
  //And thid using Mockito framework
  public void login_WhenCalled_WritesToLog3() {
    ILogger mockLog = Mockito.mock(ILogger.class);
    LoginManager loginManager = new LoginManager(mockLog);
    loginManager.login("","");
    Mockito.verify(mockLog).write("Login attempt");
  }
}
package ClientMessageBoard;

public class JSONParserRegister
{
    //Attributes
    private String Command;
    private String Username;

    //Methods
    public void setCommand(String Command)
    {
        this.Command = Command;
    }

    public String getCommand()
    {
        return Command;
    }

    public void setUsername(String Username)
    {
        this.Username = Username;
    }

    public String getUsername()
    {
        return Username;
    }

    /*
        "command":"register", "username":"user01",          //registration
            "command":"deregister", "username":"user01",       //deregistration
            "command":"msg", "username":"user02", "message":"This is my message."     //message to post
    */
}

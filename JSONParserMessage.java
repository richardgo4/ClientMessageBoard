package ClientMessageBoard;

public class JSONParserMessage
{
    //Attributes
    private String Command;
    private String Username;
    private String Message;

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

    public void setMessage(String Message)
    {
        this.Message = Message;
    }

    public String getMessage()
    {
        return Message;
    }

}

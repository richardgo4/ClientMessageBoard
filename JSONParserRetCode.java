package ClientMessageBoard;

public class JSONParserRetCode
{
    //Attributes
    private String Command;
    private int code_no;

    //Methods
    public void setCommand(String Command)
    {
        this.Command = Command;
    }

    public String getCommand()
    {
        return Command;
    }

    public void setCode_no(int code_no)
    {
        this.code_no = code_no;
    }

    public int getCode_no()
    {
        return code_no;
    }
}

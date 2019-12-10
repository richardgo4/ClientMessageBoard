/*
*   Authors: John Richard Go
*            John Wilson Chua
*
*   Project: Message Board Client
*
====================================================================================================
*   This program uses several JACKSON JAR files that must be included to the environment PATH or   *
*   manually set to your IDE's Project Structure.                                                  *
*           -- jackson-annotations-2.10.0.jar                                                      *
*           -- jackson-core-2.10.0.jar                                                             *
*           -- jackson-databind-2.10.0.jar                                                         *
*                                                                                                  *
*   JACKSON is a JSON serializer for Java that maps java objects to JSON and JSON to java objects. *
====================================================================================================
*
* */

package ClientMessageBoard;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class ClientMB
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();
        DatagramSocket datagramSocket = new DatagramSocket();       //throws SocketException

        String IPAddress = "", username, JSONregisterString, JSONrcvString;
        int validIP = 0;

        while(validIP != 1)
        {
            System.out.println(validIP);
            //Get the IP Address of server
            System.out.print("Enter IP Address of message board server: ");
            IPAddress = scanner.nextLine();

            //Verify IP Address
            try
            {
                validIP++;
                InetAddress verifyIP = InetAddress.getByName(IPAddress);
            }catch (UnknownHostException e)
            {
                validIP--;
                System.out.println("Please enter a valid IP Address.");
            }
        }

        //Set validated IP Address
        InetAddress IP = InetAddress.getByName(IPAddress);

        //Get the user's username
        System.out.print("Enter preferred username: ");
        username = scanner.nextLine();


        // [REGISTER] JSON command codes to send to server
        JSONParserRegister JSONregisterObj = new JSONParserRegister();
        JSONregisterObj.setCommand("register");
        JSONregisterObj.setUsername(username);

        JSONregisterString = objectMapper.writeValueAsString(JSONregisterObj);

        System.out.println(JSONregisterString);


        //Send the DatagramPacket to the server
        byte buffer[] = JSONregisterString.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, IP, 12345);

        datagramSocket.send(datagramPacket);


        //Receive registration confirmation from server
        buffer = new byte[1024];
        datagramPacket = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(datagramPacket);

        //Convert the packet(JSON Command) to a string
        JSONrcvString = new String(datagramPacket.getData());
        System.out.println(JSONrcvString);

        //read and set the values of the commands replied by the server
        //ADD TRY/CATCH HERE
        JSONParserRetCode receiver = objectMapper.readValue(JSONrcvString,JSONParserRetCode.class);
        System.out.println(receiver.getCommand());
    }
}

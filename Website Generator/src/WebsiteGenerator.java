
/**
 * Virtual High School
 * @author type your full name here
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class WebsiteGenerator
{
  /*Idea: Instead of generating new sting each time, generate a list
   *  of all valid domains. When pulling string from list, only test
   *  that one string to make sure link isn't dead.
   *  If dead, remove from list
   */

  public static void main(String[] args)
  {
    boolean check = false;
    while (!check)
    {
      String site = CreateURL();
      try
      {
        Random rand = new Random();
        String[] suffix =
          {".com", ".net", ".gov", ".org", ".cn", ".uk", ".info", ".nl", ".EU",
              ".RU", ".DE"};
        site = "https://www." + site + suffix[rand.nextInt(10)];
        System.out.println(site);
        URL u = new URL(site);
        check = checkURL(u);
        if (check)
        {
          System.out.println(site + " Is good");
        }
        else
        {
          System.out.println("Bad URL");
        }
      }
      catch (MalformedURLException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
  }

  public static boolean checkURL(URL u)
  {
    HttpURLConnection connection = null;
    try
    {
      connection = (HttpURLConnection) u.openConnection();
      connection.setRequestMethod("HEAD");
      connection.setConnectTimeout(1000);
      connection.setReadTimeout(1000);
      int code = connection.getResponseCode();
      System.out.println("" + code);
      // You can determine on HTTP return code received. 200 is success.
      return(code==200);
    }
    catch (MalformedURLException e)
    {
      // TODO Auto-generated catch block
      // e.printStackTrace();
      System.out.println("error");
    }
    catch (IOException e)
    {
      System.out.println("error2");
      // TODO Auto-generated catch block
      // e.printStackTrace();
    }
    finally
    {
      if (connection != null)
      {
        connection.disconnect();
      }
    }

    return false;
  }


  public static String CreateURL()
  {
    String site = "";
    Random rand = new Random();
    char[] alphabet =
      {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
          'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    for (int i = 0; i < rand.nextInt(18) +2; i++)
    {
      site = site + alphabet[rand.nextInt(25)];

    }
    return site;
  }

}

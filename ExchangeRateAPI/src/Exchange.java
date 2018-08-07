import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Exchange{

    //gets the html code for the html page with data

    public static String getHTML(String fromCountryCode, String toCountryCode) throws IOException{
        Document doc = Jsoup.connect("https://www.google.co.in/search?q=ecxchange+rate+"+fromCountryCode+"to"+toCountryCode).get();
        String html = doc.toString();
        return  html;
    }
    //isolates the exchange value
    public static double getEx(String html){
        html = html.substring(html.indexOf("<div class=\"dDoNo vk_bk\">"));
        html = html.substring(0,html.indexOf("</span>"));
        Document doc = Jsoup.parse(html);
        html = doc.text();
        return Double.parseDouble(html);
    }
    //returns both together
    public static double getRate(String fromCountryCode, String toCountryCode) throws IOException{

        return getEx(getHTML(fromCountryCode,toCountryCode));

    }

    public static void main(String[] args) throws IOException{

        System.out.println(getRate("inr","gbp"));

    }




}

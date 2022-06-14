package Vorlesungen.Serilisation.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {


    public static void main(String[] args) {

        String urlString = "(http|https|ftp)://[/\\w\\.\\-\\+\\?]+";
        Pattern urlPattern = Pattern.compile(urlString);

        String data = "Hier kommt irgendwo eine http://www.url.de/ im String";

        Matcher urlMatcher = urlPattern.matcher(data);

        while (urlMatcher.find()) {
            int startIndex = urlMatcher.start();
            int endIndex = urlMatcher.end();

            String currentMatch = data.substring(startIndex, endIndex);
            System.out.println(currentMatch);
        }
    }
}



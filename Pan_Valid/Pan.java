package Pan_Valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pan {
    public static boolean isValidPanCardNo(String panCardNo)
    {
 
        String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}"; 
       
        Pattern p = Pattern.compile(regex);
 
        if (panCardNo == null)
        {
            return false;
        }

        Matcher m = p.matcher(panCardNo);

        return m.matches();
    }

    public static void main(String args[])
    {
 
     
        String str1 = "BNZAA2318J";
        System.out.println(isValidPanCardNo(str1));
 
       
        String str2 = "23ZAABN18J";
        System.out.println(isValidPanCardNo(str2));

    }
}



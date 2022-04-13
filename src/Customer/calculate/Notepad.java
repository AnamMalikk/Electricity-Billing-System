package Customer.calculate;

import java.io.*;
import java.util.*;
public class Notepad {
public Notepad()
{
Runtime rn = Runtime.getRuntime ();
try{
rn.exec("notepad");
}
catch (IOException e){
System.out.println ("Exception " +e);
}
}
}


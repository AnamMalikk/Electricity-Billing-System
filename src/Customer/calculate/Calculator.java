package Customer.calculate;
import java.io.*;
import java.util.*;
public class Calculator{
public Calculator()
{
Runtime rn = Runtime.getRuntime();
try{
rn.exec("calc");
}
catch (IOException e){
System.out.println ("Exception " +e);
}}}


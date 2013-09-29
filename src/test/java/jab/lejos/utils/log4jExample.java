package jab.lejos.utils;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class log4jExample{
  /* Get actual class name to be printed on */
  static Logger log = Logger.getLogger(
                      log4jExample.class.getName());

  public static void main(String[] args)
                throws IOException,SQLException{
   
	  System.out.println(System.getProperty("user.dir"));
	  Properties props = new Properties();
	  props.load(new FileInputStream("/home/root/lejos/examples/Brity/lib/log4j.properties"));
	  PropertyConfigurator.configure(props);
	  
     log.debug("Hello this is an debug message");
     log.info("Hello this is an info message");
     
     System.out.println("END");
  }
}

package test.com.zy.test; 

import com.zy.test.Employee;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.*;
import java.util.logging.Logger;

/** 
* Employee Tester. 
* 
* @author <Authors name> 
* @since <pre>12/02/2017</pre> 
* @version 1.0 
*/ 
public class EmployeeTest { 

@Before
public void before() throws Exception {
}

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getTaxpayerIdentificationNumber() 
* 
*/ 
@Test
public void testGetTaxpayerIdentificationNumber() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setTaxpayerIdentificationNumber(String taxpayerIdentificationNumber) 
* 
*/ 
@Test
public void testSetTaxpayerIdentificationNumber() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getEmployeeNumber() 
* 
*/ 
@Test
public void testGetEmployeeNumber() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setEmployeeNumber(String employeeNumber) 
* 
*/ 
@Test
public void testSetEmployeeNumber() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getSalary() 
* 
*/ 
@Test
public void testGetSalary() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setSalary(BigDecimal salary) 
* 
*/ 
@Test
public void testSetSalary() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: equals(Object o) 
* 
*/ 
@Test
public void testEquals() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: hashCode() 
* 
*/ 
@Test
public void testHashCode() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: toString() 
* 
*/ 
@Test
public void testToString() throws Exception { 
//TODO: Test goes here...
}

/** 
* 
* Method: printAudit(StringBuilder buffer) 
* 
*/ 
@Test
public void testPrintAudit() throws Exception { 
//TODO: Test goes here...
    Logger l = Logger.getLogger(Employee.class.getName());
    File file = new File("file.txt");
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
        String line = bufferedReader.readLine();
        while (line != null) {
            // Read the file
            l.info(line);
            line = bufferedReader.readLine();
        }
    } catch (Exception e) {
        l.severe(e.getMessage());
    }
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here...
    Logger l = Logger.getLogger(Employee.class.getName());
    File file = new File("file.txt");
    BufferedReader bufferedReader = null;
    try {
        bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        while (line != null) {
            // Read the file
            l.info(line);
            line = bufferedReader.readLine();
        }
    } catch (FileNotFoundException e) {
        l.severe(e.getMessage());
    } catch (IOException e) {
        l.severe(e.getMessage());
    } catch (Exception e) {
        l.severe(e.getMessage());
    } finally {
        // Close the reader
        bufferedReader.close();
    }
}


} 

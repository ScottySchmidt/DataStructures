/**
 * Hourly Employee
 * @author Scott Schmidt;  Illinois State University; Data Stuctures 
 */

package main;
import tests.EmployeeTester;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class HourlyEmployee {
    private String name;
    private String employeeID;
    private float hourlyWage;
    private float accruedLeaveHours;
    private float annualHoursWorked;
    private float annualEarnings;
    public int numEmployees=100;
    public static List<HourlyEmployee> empList= new ArrayList<>();

    //Default Constructor
    public HourlyEmployee() {
        System.out.println("Default Constructor.");
    }

    //Constructor
    public HourlyEmployee(String name, String employeeID, float hourlyWage, float accruedLeaveHours, float annualHoursWorked, float annualEarnings) {
        this.name = name;
        this.employeeID = employeeID;
        this.hourlyWage = hourlyWage;
        this.accruedLeaveHours = accruedLeaveHours;
        this.annualHoursWorked = annualHoursWorked;
        this.annualEarnings = annualEarnings;

        this.empList.add(new HourlyEmployee(name, employeeID, hourlyWage, accruedLeaveHours, annualHoursWorked, annualEarnings));
    }

    /*
    Constructor with only 3 parameters:
   */
    public HourlyEmployee(String name, String employeeID, float hourlyWage) {
        this.name = name;
        this.employeeID = employeeID;
        this.hourlyWage = hourlyWage;
    }
    /*
      read function
    */
    public static void read(Scanner file) {
        int count = 0;
        String name = "";
        while (file.hasNextLine()) {
            if (count % 2 == 0) {
                name = file.nextLine();
            } else {
                String[] data = file.nextLine().split(" ");
                String employeeID = data[0];
                float hourlyWage = Float.parseFloat(data[1]);
                float accruedLeaveHours = Float.parseFloat(data[2]);
                float annualHoursWorked = Float.parseFloat(data[3]);
                float annualEarnings = Float.parseFloat(data[4]);

                HourlyEmployee emp = new HourlyEmployee(name, employeeID, hourlyWage, accruedLeaveHours, annualHoursWorked, annualEarnings);
            }
            count = count + 1;
        }
        file.close();
    }

    /*
    return employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /*
   toString
   :returns the data with labels and formatting that matches the sample output.
   */
    @Override
    public String toString() {
        return "Displaying data for empID " + this.employeeID + "\n" +
                "Name: " + this.name + "\n" +
                "Pay Rate: " + this.hourlyWage + "\n" +
                "Accrued Leave: " + this.accruedLeaveHours + "\n" +
                "Annual Hours Worked: " + this.annualHoursWorked + "\n" +
                "Annual Earnings: " + this.annualEarnings;
    }

    public void handlePay(float weeklyHours, float accruedLeaveHours) {
        /*
        handlePay will compute pay; update leave accrued, annual hours worked, annual earnings.
       :param1: weeklyHours: the number of hours worked for the week
       :param2: accruedLeaveHours: the amount of leave used that week

       Output the following information:
       <name> earned <pay for the week> and has <accrued leave> hours of leave accrued.
         */
        if (accruedLeaveHours > this.accruedLeaveHours) {
            System.out.println(" WARNING:" + this.name + " cannot have less than 0 accruedLeaveHours.");
        } else if (accruedLeaveHours + weeklyHours > 40) {
            System.out.println(" WARNING:" + this.name + " accruedLeaveHours plus weeklyHours cannot exceed 40 hours");
        } else {
            weeklyHours = weeklyHours;
            accruedLeaveHours = accruedLeaveHours;
            this.annualHoursWorked += weeklyHours;
            this.accruedLeaveHours += (weeklyHours / 8);
        }
        float weeklyPay = 0;
        if (weeklyHours < 40) {
            weeklyPay = this.annualHoursWorked * this.hourlyWage;
        } else {
            float overtimeHours = weeklyHours - 20;
            float overtimePay = overtimeHours * this.hourlyWage;
            weeklyPay = (weeklyHours * this.hourlyWage) + overtimePay;

            this.annualEarnings += weeklyPay;
            this.accruedLeaveHours -= accruedLeaveHours;

            System.out.println(this.name + " earned " + weeklyPay + " and has " +
                    this.accruedLeaveHours + " hours of leave accrued.");
        }
    }

    public String getName() {
        return this.name;
    }

    public float getHourlyWage() {
        return hourlyWage;
    }

    public float getAccruedLeaveHours() {
        return accruedLeaveHours;
    }

    public float getAnnualHoursWorked() {
        return annualHoursWorked;
    }

    public float getAnnualEarnings() {
        return annualEarnings;
    }
}







package main;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * Payroll
 * @author Scott Schmidt; Illinois State University; Data Structures
 */
public class Payroll {
    //The Payroll class must have the following instance variables:
    private HourlyEmployee [] empsArr;//An array of HourlyEmployee objects that the Payroll object manages
    private int empCount=0; // The number of employees currently in the Payroll

    //Default Constructor:
    public Payroll(){
        System.out.println("Default Constructor");
    }

    public Payroll(HourlyEmployee[] emp) {
        this.empsArr = empsArr;
        this.empCount+=emp.length;
    }

    public void readFile(String file) {

    }

    public void writeFile(String s) {

    }

    public void addEmployee(HourlyEmployee emp1) {
    }

    public void displayEmployee(String employeeID) {
        /*
        displayEmployee displays the employee to the screen in the format of the HourlyEmployee toString.
       :param: String employee
        */
        int found = 0;
        for (HourlyEmployee e : HourlyEmployee.empList) {
            if (e.getEmployeeID().equals(employeeID)) {
                System.out.println( "Displaying data for empID " + employeeID + "\n" +
                        "Name: " + e.getName() + "\n" +
                        "Pay Rate: " + e.getHourlyWage() + "\n" +
                        "Accrued Leave: " + e.getAccruedLeaveHours() + "\n" +
                        "Annual Hours Worked: " + e.getAnnualHoursWorked() + "\n" +
                        "Annual Earnings: " + e.getAnnualEarnings());
            }
            if (found == 0) {
                System.out.print(employeeID + " not found");
            }
        }
    }
            public void displayAllEmployees() {
            /*
            displayEmployees A displayAllEmployees method that displays all of the employees in
            the array to the screen in the format of the HourlyEmployee toString.
            */
                for (HourlyEmployee e : HourlyEmployee.empList) {
                    System.out.println("Displaying data for empID " + e.getEmployeeID() + "\n" +
                            "Name: " + e.getName() + "\n" +
                            "Pay Rate: " + e.getHourlyWage() + "\n" +
                            "Accrued Leave: " + e.getAccruedLeaveHours() + "\n" +
                            "Annual Hours Worked: " + e.getAnnualHoursWorked() + "\n" +
                            "Annual Earnings: " + e.getAnnualEarnings() );
                }
        }

    public void runPayroll(String s) {
        /*
          runPayroll method handles weekly payroll based on the information in the file.
          :param: file as string

          Each line of the file will have an employee id followed by the number of hours worked
          and the number of hours of leave used that week.
          The method will handle the pay for each employee who worked that week
         */
    }
}

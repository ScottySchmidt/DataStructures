//Scott Schmidt; Data Structures; Illinois State University

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.sql.SQLOutput;
import java.util.List; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files


public class storage {
    public static ArrayList<Object> hourEmpArr = new ArrayList<Object>();
}

public class HourlyEmployee {
    private String name;
    private String employeeID;
    private float hourlyWage;
    private float accruedLeaveHours;
    private float annualHoursWorked;
    private float annualEarnings;


    //Default Constructor
    public HourlyEmployee() {
        System.out.println("Default Constructor.");
    }

    //HourlyEmployee Cnstructor with all 6 parameters:
    public HourlyEmployee(String name, String employeeID, float hourlyWage, float accruedLeaveHours, float annualHoursWorked, float annualEarnings) {
        this.name = name;
        this.employeeID = employeeID;
        this.hourlyWage = hourlyWage;
        this.accruedLeaveHours = accruedLeaveHours;
        this.annualHoursWorked = annualHoursWorked;
        this.annualEarnings = annualEarnings;

        List <Object> temp= Arrays.asList(name, employeeID, hourlyWage);
        storage.hourEmpArr.add(temp);

        displayStudents();
    }

    // HourlyEmployee Constructor with 3 parameters:
    public HourlyEmployee(String name, String employeeID, float hourlyWage) {
        this.name = name;
        this.employeeID = employeeID;
        this.hourlyWage = hourlyWage;

        List <Object> temp= Arrays.asList(name, employeeID, hourlyWage);
        storage.hourEmpArr.add(temp);

        displayStudents();
    }

    
    // read function
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


    //return employeeID
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

    public void displayStudents() {
        for (int i=0; i< storage.hourEmpArr.size(); i++)
        System.out.println(storage.hourEmpArr.get(i));
    }
}
    
public class Test {
     public static void main(String[ ] args) {
        HourlyEmployee e1 = new HourlyEmployee("Scott", "1223", 30);
        System.out.println(e1.toString());

        HourlyEmployee e2 = new HourlyEmployee("Bob", "1223", 30);
    }
}

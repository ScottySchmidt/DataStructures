//Illinois State Univeresity; DataStructures; Scott Schmidt
import java.util.List; 
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Person {

    public static ArrayList<Object> stuArr = new ArrayList<Object>();
    public static ArrayList<Object> empArr = new ArrayList<Object>();

    public String name;
    public int age;
    public String gender;
    
      /**
        Person Constructor:
        * @param name as String 
        * @param age as int 
        * @param major as String
        */
    public Person (String name, int age, String gender) {
        this.name=name;
        this.age=age;
        this.gender=gender;
    }

    //return name
    public String getName() {
        return name;
    }

    //return age
    public int getAge() {
        return age;
    }

    //return gender
    public String getGender() {
        return gender;
    }

    //Person Information:
    public String toString() {
        System.out.println(name+" "+age+" "+gender);  
        return name+" "+age+" "+gender;  
    }
}

public class Student extends Person {
        private String major;
        private double totalGrade;
        private int numOfCourses;

        public static int stuCount=0;

        /**
        Student Constructor:
        * @param name as String from Person class
        * @param age as int from Person class
        * @param major as String from Person class
        * @param totalGrade as double 
        * @param numOfCourses as int
        */
        public Student(String name, int age, String gender, String major,  double totalGrade, int numOfCourses) {
            super(name, age, gender);
            this.major=major;
            this.totalGrade=totalGrade;
            this.numOfCourses=numOfCourses;
      
            List<Object> temp = Arrays.asList(name, age, gender, major, totalGrade, numOfCourses);
            Person.stuArr.add(temp);
            stuCount++;

            displayStudents();
            }

            ///return grade to 2 decimal places
            public double getAverageGrade() {
                double grade=this.totalGrade/this.numOfCourses;
                grade = Math.round(grade * 100.0) / 100.0;
                System.out.println(grade);
                return grade;
            }

            //Prints student info:
            public String toString() {
                System.out.println(name+" "+age+" "+gender+ " "+ getAverageGrade());  
                return name+" "+age+" "+gender;
            }

            //Checks if two student objects are the same person:
            public boolean equals(Object obj) {
                if (name.equals(this.name) & gender.equals(this.gender) & age==this.age ) {
                    System.out.println("Same Person");
                    return true;
                } else {
                    System.out.println("Different Person");
                    return false;
             }     
            }
             //displays all active students:
            public void displayStudents() {
                for (int i = 0; i < Person.stuArr.size(); i++) 
                 System.out.println(Person.stuArr.get(i)); 
             }   
}


public class Employee extends Person {
        public double rate;
        public double hour;

        /**
        Employee Constructor:
        * @param name as String from Person class
        * @param age as int from Person class
        * @param major as String from Person class
        * @param hour as double 
        * @param rate as double
        */
        public Employee(String name, int age, String gender, double hour, double rate) {
            super(name, age, gender);
            this.hour=hour;
            this.rate=rate;

            List<Object> temp = Arrays.asList(name, age, gender, hour, rate);
            Person.empArr.add(temp);
            }

            //Employee Info:
            public String toString() {
                System.out.println(name+" "+age+" "+gender +" " +rate +" " +hour);  
                return name+" "+age+" "+gender;  
            }

            //return hour
            public double getHour(){
                return hour;
            }

            //return rate\
            public double getRate(){
                return rate;
            }

            //return money to 2 decimals:
            public double getPayment(){
                double money=this.rate*this.hour;
                money = Math.round(money * 100.0) / 100.0;
                System.out.println(money);
                return money;
            }

            //checks if two employees are same person:
            public boolean equals(Object obj) {
                if (name.equals(this.name) & gender.equals(this.gender) & rate==this.rate ) {
                    System.out.println("Same Person");
                    return true;
                } else {
                    System.out.println("Different Person");
                    return false;
             }     
            }
}

public class Test {
     public static void main(String[ ] args) {
        //STUDENT CLASS:
        Student s1=new Student("James Smith", 26, "Male", "Computer", 350, 4);
        s1.getAverageGrade(); //87.5

        Student s2=new Student("James Smith", 26, "Male", "Technology", 281, 3);
        s2.toString(); //[James Smith, 26, Male, Computer, 350.0, 4]

        Student s3=new Student("Scott Schmidt", 28, "Male", "Computer", 400, 4);
        s1.equals(s2); //Same Person

        //[James Smith, 26, Male, Computer, 350.0, 4]
        //[James Smith, 26, Male, Technology, 281.0, 3]
        //[Scott Schmidt, 28, Male, Computer, 400.0, 4]

        //EMPLOYEE CLASS:
        Employee e1=new Employee("Linda Ward", 26, "Female", 17.8, 22.7);

        Employee e2=new Employee("Linda Ward", 26, "Female", 19.3, 17.8);
        e2.toString(); //Linda Ward 26 Female 17.8 19.3
        e2.getPayment(); //343.54
        e1.equals(e2); //Same Person
    }
}

public abstract class Person {

    public static ArrayList<Object> stuArr = new ArrayList<Object>();
    public static ArrayList<Object> empArr = new ArrayList<Object>();
    public static Student stuObj[];

    public String name;
    public int age;
    public String gender;
    
    // Create a Person Constructor:
    public Person (String name, int age, String gender) {
        this.name=name;
        this.age=age;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

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

        //STUDENT CONSTRUCTOR:
        public Student(String name, int age, String gender, String major,  double totalGrade, int numOfCourses) {
            super(name, age, gender);
            this.major=major;
            this.totalGrade=totalGrade;
            this.numOfCourses=numOfCourses;
      
            List<Object> temp = Arrays.asList(name, age, gender, major, totalGrade, numOfCourses);
            Person.stuArr.add(temp);
            stuCount++;

            //System.out.println(storage.stuArr);
            equals();
            //displayStudents();
            }

            public double getAverageGrade() {
                double grade=this.totalGrade/this.numOfCourses;
                System.out.println(grade);
                return grade;
            }

            public String toString() {
                System.out.println(name+" "+age+" "+gender+ " "+ getAverageGrade());  
                return name+" "+age+" "+gender;
            }

            public void equals() {
                    for (int i = 0; i < Person.stuArr.size(); i++) 
                    System.out.println(Person.stuArr.get(i)); 
             }     
             
            public void displayStudents() {
                    for (int i = 0; i < Person.stuArr.size(); i++) 
                 System.out.print(Person.stuArr.get(i)); 
             }   
}


public class Employee extends Person {
        public double rate;
        public double hour;

        //EMPLOYEE CONSTRUCTOR:
        public Employee(String name, int age, String gender, double hour, double rate) {
            super(name, age, gender);
            this.hour=hour;
            this.rate=rate;

            List<Object> temp = Arrays.asList(name, age, gender, hour, rate);
            Person.empArr.add(temp);
            }

            public String toString() {
                System.out.println(name+" "+age+" "+gender +" " +rate +" " +hour);  
                return name+" "+age+" "+gender;  
            }

            public double getHour(){
                return hour;
            }

            public double getRate(){
                return rate;
            }

            public double getPayment(){
                double pay=this.rate*this.hour;
                return pay;
            }

            public boolean equals(){
                return true;
            }
}

public class test {
     public static void main(String[ ] args) {
        //STUDENT CLASS:
        Student s1=new Student("James Smith", 26, "Male", "Computer", 350, 4);
        s1.getAverageGrade();

        Student s2=new Student("James Smith", 26, "Male", "Technology", 281, 3);
        s2.toString();

        Student s3=new Student("Scott Schmidt", 28, "Male", "Computer", 400, 4);

        //EMPLOYEE CLASS:
        Employee[] empObj = new Employee[2] ;

        Employee e1=new Employee("Linda Ward", 26, "Female", 17.8, 22.7);

        Employee e2=new Employee("Linda Ward", 26, "Female", 19.3, 17.8);
        e2.toString();
        System.out.println(e2.getPayment());
    }
}

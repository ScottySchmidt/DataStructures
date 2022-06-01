public class Person {

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

    public static void main(String[ ] args) {
        Person p1=new Person("PersonTest", 50, "Female"); 
        p1.toString();
    }

}

public class Student extends Person {
        private String major;
        private double totalGrade;
        private int numOfCourses;
    
        public Student(String name, int age, String gender, String major,  double totalGrade, int numOfCourses) {
            super(name, age, gender);
            this.major=major;
            this.totalGrade=totalGrade;
            this.numOfCourses=numOfCourses;
            }

            public double getAverageGrade() {
                double grade=this.totalGrade/this.numOfCourses;
                System.out.println(grade);
                return grade;
            }

            public String toString() {
                System.out.println(name+" "+age+" "+gender);  
                return name+" "+age+" "+gender;  
            }
	  
     public static void main(String[ ] args) {
        Student s1=new Student("James Smith", 26, "Male", "Computer", 350, 4);
        s1.getAverageGrade();

        Student s2=new Student("James Smith", 26, "Male", "Technology", 281, 3);
        s2.toString();
    }
}


public class Employee extends Person {
        public double rate;
        public double hours;
    
        public Employee(String name, int age, String gender, double hours, double rate) {
            super(name, age, gender);
            this.hours=hours;
            this.rate=rate;
            }

            public String toString() {
                System.out.println(name+" "+age+" "+gender +" " +rate +" " +hours);  
                return name+" "+age+" "+gender;  
            }

            public boolean equals(){
                return true;
            }

     public static void main(String[ ] args) {
        Employee e1=new Employee("Linda Ward", 26, "Female", 17.8, 22.7);

        Employee e2=new Employee("Linda Ward", 26, "Female", 19.3, 17.8);
        e2.toString();
    }
}

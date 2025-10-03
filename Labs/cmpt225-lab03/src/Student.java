public class Student implements Comparable<Student>{
    String name;
    String id;
    public Student(String name, String id){
        this.name = name;
        this.id = id;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student){
            return this.id.equals(((Student)obj).id);
        }
        return false;
    }

    @Override
    public String toString(){
        return this.name+":"+this.id;
    }


    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    public static void main(String[] args){
        Student s1 = new Student("Jack","123");
        Student s2 = new Student("Jerry","123");
        System.out.println(s1.equals(s2)); // compares actual content
        System.out.println(s1.id == s2.id); // Same string object, will return true

        Student s3 = new Student("Jack",new String("123"));
        Student s4 = new Student("Jerry",new String("123"));
        System.out.println(s3.equals(s4)); // returns true
        System.out.println(s3.id == s4.id); // returns false, because s3, s4 point point to diff blocks of memory

    }


}

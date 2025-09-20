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
        return this.id.compareTo(o.id);
    }
}

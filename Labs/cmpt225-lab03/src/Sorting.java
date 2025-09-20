import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {
    /**
     * Bubble sort (Worst case O(n^2))
     * @param a
     */
    public static void sort(Comparable[] a){
        if(a == null || a.length == 0){
            return;
        }
        for(int i = 0; i < a.length -1 ;i++){
            for(int j = 0; j < a.length-i-1;j++){
                if(a[j].compareTo(a[j+1]) > 0){
                    Comparable temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    /**
     * Efficient Sort
     * @param a
     */
    public static void efficientSort(Comparable[] a) {
        //implement me
    }
    public static void main(String[] args){
        Student[] students = new Student[5];
        students[0] = new Student("Alice","501");
        students[1] = new Student("Bob","401");
        students[2] = new Student("Tom","301");
        students[3] = new Student("Jerry","201");
        students[4] = new Student("Mickey","101");
        System.out.println("Before Sorting, contents of students array = "+Arrays.toString(students));
        sort(students);
        System.out.println("After Sorting, contents of students array = "+Arrays.toString(students));

        //now we use the same sort() method to sort an array of Lakes
        Lake[] lakes = new Lake[5];
        lakes[0] = new Lake("Great Bear Lake", 31328);
        lakes[1] = new Lake("Lake Superior", 82100);
        lakes[2] = new Lake("Lake Erie", 25700);
        lakes[3] = new Lake("Great Slave Lake", 28568);
        lakes[4] = new Lake("Lake Huron", 59600);
        System.out.println("Before Sorting, contents of lakes array = "+Arrays.toString(lakes));
        sort(lakes);
        System.out.println("After Sorting, contents of lakes array = "+Arrays.toString(lakes));

    }
}

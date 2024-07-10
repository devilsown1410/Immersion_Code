package ClassCodes;

import java.util.*;
class Student implements Comparable<Student>{
String name;
int age;
public Student(String name,int age){
    this.name=name;
    this.age=age;
}
public String toString(){
    return "Student(name='" +name + "',age=" +age+ ")";
}
@Override
public int compareTo(Student o) {
    return this.age=o.age;
    //return this.name.comapreTo(Student o);
}
}
public class comparator{
    public static void main(String[] args) {
        ArrayList<Integer>ll=new ArrayList<>();
        Student p1=new Student("Alice",24);
        Student p2=new Student("Tom",25);
        Student p3=new Student("Bob",23);
        Student p4=new Student("john",21);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        Collections.sort(ll,(a,b)->{System.out.println(a+" "+b);
            return b-a;});
        System.out.println(ll);
    }
}
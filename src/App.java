
import ds.DynamicArray;
import java.util.Objects;

class Person 
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Name: " + this.name + " " + "Age: " + this.age;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        return this.name.equals(other.name) && this.age == other.age;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(this.name, this.age);
    }


}



public class App 
{
   
   
    public static void main(String[] args) throws Exception 
    {
       
        DynamicArray<Person> da = new DynamicArray<>();

        Person p = new Person("aki", 12);
        da.addElement(new Person("Ben", 12));
        da.addElement(new Person("Ben2", 32));
        da.addElement(new Person("Ben3", 2));
        da.addElement(new Person("Ben4", 42));
        da.addElement(p);
        da.addElement(new Person("Ben5", 15));

        System.out.println(da.contains(p));
        System.out.println(da.contains(new Person("Ben4", 42)));






    }
}

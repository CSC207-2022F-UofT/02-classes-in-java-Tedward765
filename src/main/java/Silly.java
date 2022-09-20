import java.util.Arrays;

/**
 * This file contains a few exercises to familiarize you with specific
 * class features in Java.
 *
 * You should read this file from top-to-bottom. Any tasks you are to complete
 * are labelled with TODO
 *
 * For your convenience, we have also included references to the
 * relevant readings for each task.
 */

public class Silly implements Comparable<Silly>{
    /**
     * 1. Java has variables known as "static" variables.
     * These are variables that exist in every instance of a class,
     * and which have the same value across all instances.
     *
     * Below we have created a static variable (signified by the keyword
     * static) named my_static. The countStatic() method makes use of this
     * static variable.
     *
     * (Relevant reading: 2.1. Static variables)
     */
    public static int my_static = 0;

    // For comparison, this is a non-static attribute.
    public String name;

    /**
     * Return the current value of my_static and increase my_static by 1.
     *
     * @return the current value of my_static
     */
    public int countStatic() {
        // This method uses the static variable and increases it.
        int to_return = my_static;
        my_static += 1;

        return to_return;
    }

    /**
     * 2. Java allows for us to overload methods: this means we can have
     *    multiple methods of the same name, but which take different
     *    parameters (both in terms of numbers and type).
     *
     *    Below we have created two different constructors and have left
     *    a third for you to write.
     *
     *    (Relevant reading: 2.2. Overloading)
     */

    /**
     * Creates a new Silly object.
     * This constructor takes in a single String as an argument.
     *
     * @param name the name of this Silly instance.
     */
    public Silly(String name) {
        this.name = name;
    }

    /**
     * Creates a new Silly object.
     * This constructor takes in a single int as an argument.
     *
     * @param number a number for this Silly instance's name.
     */
    public Silly(int number) {
        this.name = "Silly #" + number;
    }

    /**
     * Creates a new Silly object
     * This constructor takes in two strings as arguments.
     *
     * @param s1 the first name of this Silly instance
     * @param s2 the second name of this Silly instance
     */
    public Silly(String s1, String s2) { this.name = s1 + s2; }





    public static void main(String[] args) {
        /**
         * Task 1 (continued): The below demonstrates how each of the Silly
         *                     constructors are called.
         *
         * This is simply provided as an example for you to see whether your
         * code is working correctly, and to see how the different calls appear
         *
         * To run this, Task 3 is also required to be completed.
         */
        Silly first_version = new Silly("single str name");
        Silly second_version = new Silly(5);
        Silly third_version = new Silly("first", "second");

        System.out.println("Silly 1: " + first_version);
        System.out.println("Silly 2: " + second_version);
        System.out.println("Silly 3: " + third_version);


        Silly x = new Silly("something");
        Silly y = new Silly("something else");

        x.countStatic();
        y.countStatic();
        x.countStatic();
        x.countStatic();
        int[] expected_values = {0, 1, 2, 3};

        System.out.println("The countStatic calls will return " + Arrays.toString(expected_values));
    }

    /**
     * 3. Whenever we try to build a string with an Object, the toString()
     *    method is called. This is equivalent to the __str__ method in Python.
     *
     *    (Relevant reading: 2.3. toString)
     *
     * Return the String representation of this Silly object (i.e. its name).
     *
     * @return the name of this Silly.
     */
    @Override
    public String toString(){
        return this.name;
    }

    /**
     * 4. We can also override the equals() method, which is the equivalent of
     *    Python's __eq__; however, unlike Python, this is called when we use
     *    .equals() rather than == (which checks for ID equality in Java).
     *
     *    (Relevant reading: 2.4. Equality)
     *
     * @param o   the object to compare to
     * @return    whether o is a Silly object with the same name as this.
     */
    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Silly)) {
            return false;
        }

        Silly other = (Silly) o;
        return other.name.equals(this.name);
    }

    /**
     * 5. If we want to compare two objects, we have to do two things:
     *    i)  add 'implements Comparable<classname>' to our class header
     *        This has been done already for Silly! You can scroll up to
     *        see that we've added this in for you.
     *    ii) override the compareTo method. This takes another object
     *        (of the same type if we specify the classname when we write
     *        'implements Comparable'), and returns an integer.
     *
     *    (Relevant reading: 2.5. Comparing objects)
     *
     * Compares this object with other for order.
     *
     * Returns a negative integer, zero, or a positive integer as this
     * object is less than, equal to, or greater than the specified object.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this
     * object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Silly other) {
        if (this.name.length() > other.name.length()){
            return 1;
        } else if (this.name.length() == other.name.length()){
            return 0;
        } else{
            return -1;
        }
    }

    /*
     *
     *                You can click on the ongoing action to see more details.
     *                If the tests don't pass, look at the results and revise
     *                accordingly.
     */
}


package com.dkit.gd2.johnloane;

import com.dkit.gd2.johnloane.dao.IStudentDAOInterface;
import com.dkit.gd2.johnloane.dao.MysqlStudentDAO;
import com.dkit.gd2.johnloane.dto.Student;
import com.dkit.gd2.johnloane.exceptions.DAOException;

import java.awt.*;
import java.util.*;
import java.util.List;


/**
 * Collections
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "DB Connections" );
        IStudentDAOInterface studentDAO = new MysqlStudentDAO();
        //getAndPrintAllStudents(studentDAO);
        //registerNewStudent(studentDAO);
        //deleteStudent(studentDAO);
        updateStudent(studentDAO);


//        linkedListDemo();
//        linkedListQuestion1();
//        LinkedList<String> words = new LinkedList<>();
//        populateLinkedList(words);
//        linkedListQuestion2(words);
//        linkedListQuestion3(words);
//        setDemo();
//        Set<String> existingEmails = new HashSet<>();
//        populateExistingEmails(existingEmails);
//        setUniqueEmailDemo("albert@dkit.ie", existingEmails);
//        mapDemo();
//        stackDemo();
//        queueDemo();
        //priorityQueueDemo();
        //studentPriorityQueueDemo();
        //studentTreeSetDemo();
    }

    private static void updateStudent(IStudentDAOInterface studentDAO)
    {
        try
        {
            Student s = new Student("D00222223", "Albert", "Skalinski");
            boolean updated = studentDAO.updateStudentID(s, "D00222222");
            if(updated)
            {
                System.out.println("Student updated");
            }
            else
            {
                System.out.println("Student not updated");
            }
        }
        catch (DAOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteStudent(IStudentDAOInterface studentDAO)
    {
        try
        {
            boolean deleted = studentDAO.deleteStudent("D00251254");
            if(deleted)
            {
                System.out.println("Student deleted");
            }
            else
            {
                System.out.println("Student not deleted");
            }
        }
        catch (DAOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void registerNewStudent(IStudentDAOInterface studentDAO)
    {
        Student s = new Student("D00222222", "Albert", "Loane");
        try
        {
            boolean registered = studentDAO.registerStudent(s);
            if(registered)
            {
                System.out.println("Student registered");
            }
            else
            {
                System.out.println("Student not registered");
            }
        }
        catch (DAOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void getAndPrintAllStudents(IStudentDAOInterface studentDAO)
    {
        try
        {
            List<Student> students = studentDAO.findAllStudents();
            printAllStudent(students);
        }
        catch (DAOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void printAllStudent(List<Student> students)
    {
        if(students == null || students.isEmpty())
        {
            System.out.println("No students found");
        }
        else
        {
            for(Student s : students)
            {
                System.out.println(s);
            }
        }
    }

    private static void studentTreeSetDemo()
    {
        TreeSet<StudentOrdered> treeSet = new TreeSet<>();
        treeSet.add(new StudentOrdered("Albert", 50));
        treeSet.add(new StudentOrdered("Dylan", 60));
        treeSet.add(new StudentOrdered("Ross", 70));
        treeSet.add(new StudentOrdered("Craig", 80));
        treeSet.add(new StudentOrdered("Mohammed", 90));
        treeSet.add(new StudentOrdered("Dzeraldas", 100));
        treeSet.add(new StudentOrdered("Gracie", 100));
        treeSet.add(new StudentOrdered("Dominik", 40));
        treeSet.add(new StudentOrdered("Dillon", 30));
        treeSet.add(new StudentOrdered("Ethan", 20));
        treeSet.add(new StudentOrdered("Julius", 10));
        treeSet.add(new StudentOrdered("Tadhg", 10));
        System.out.println(treeSet);

    }

    private static void studentPriorityQueueDemo()
    {
        PriorityQueue<StudentOrdered> queue = new PriorityQueue<>();
        queue.add(new StudentOrdered("Albert", 50));
        queue.add(new StudentOrdered("Dylan", 60));
        queue.add(new StudentOrdered("Ross", 70));
        queue.add(new StudentOrdered("Craig", 80));
        queue.add(new StudentOrdered("Mohammed", 90));
        queue.add(new StudentOrdered("Dzeraldas", 100));
        queue.add(new StudentOrdered("Dominik", 40));
        queue.add(new StudentOrdered("Dillon", 30));
        queue.add(new StudentOrdered("Ethan", 20));
        queue.add(new StudentOrdered("Julius", 10));
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.size());
        int queueSize = queue.size();
        System.out.println(queue);
        for(int i = 0; i < queueSize; i++)
        {
            System.out.println(queue.poll());
        }
        //System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.contains("Ross"));
    }

    private static void priorityQueueDemo()
    {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Albert");
        queue.add("Dylan");
        queue.add("Ross");
        queue.add("Craig");
        queue.add("Mohammed");
        queue.add("Dzeraldas");
        queue.add("Dominik");
        queue.add("Dillon");
        queue.add("Ethan");
        queue.add("Julius");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.size());
        int queueSize = queue.size();
        System.out.println(queue);
        for(int i = 0; i < queueSize; i++)
        {
            System.out.println(queue.poll());
        }
        //System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.contains("Ross"));
    }

    private static void queueDemo()
    {
        Queue<String> queue = new LinkedList<>();
        queue.add("Albert");
        queue.add("Dylan");
        queue.add("Ross");
        queue.add("Craig");
        queue.add("Mohammed");
        queue.add("Dzeraldas");
        queue.add("Dominik");
        queue.add("Dillon");
        queue.add("Ethan");
        queue.add("Julius");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.contains("Ross"));
    }

    private static void stackDemo()
    {
        Stack<String> stack = new Stack<>();
        stack.push("Albert");
        stack.push("Dylan");
        stack.push("Ross");
        stack.push("Craig");
        stack.push("Mohammed");
        stack.push("Dzeraldas");
        stack.push("Dominik");
        stack.push("Dillon");
        stack.push("Ethan");
        stack.push("Julius");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.search("Ross"));

    }

    //This method will create a map that stores student's names and their favourite colours
    private static void mapDemo()
    {
        Map<String, Color> studentFavouriteColours = new HashMap<>();
        studentFavouriteColours.put("Albert", Color.BLUE);
        studentFavouriteColours.put("Dylan", Color.RED);
        studentFavouriteColours.put("Ross", Color.GREEN);
        studentFavouriteColours.put("Craig", Color.YELLOW);
        studentFavouriteColours.put("Mohammed", Color.ORANGE);
        studentFavouriteColours.put("Dzeraldas", Color.ORANGE);
        studentFavouriteColours.put("Dominik", Color.ORANGE);
        studentFavouriteColours.put("Dillon", Color.BLACK);
        studentFavouriteColours.put("Ethan", Color.WHITE);
        studentFavouriteColours.put("Julius", Color.PINK);
        System.out.println(studentFavouriteColours);
        //Print the favourite colour of Dylan
        System.out.println(studentFavouriteColours.get("Dylan"));
    }

    private static void populateExistingEmails(Set<String> existingEmails)
    {
        existingEmails.add("albert@dkit.ie");
        existingEmails.add("dylan@dkit.ie");
        existingEmails.add("ross@dkit.ie");
    }


    // Write a method that takes an argument of email and checks whether this email already exists in a set of emails
    private static void setUniqueEmailDemo(String email, Set<String> existingEmails)
    {
        if(existingEmails.contains(email))
        {
            System.out.println("Email already exists");
        }
        else
        {
            existingEmails.add(email);
            System.out.println("Email is unique");
        }
    }


    private static void setDemo()
    {
        Set<String> names = new TreeSet<>();
        //Set<String> names = new TreeSet<>();
        //Set<String> names = new LinkedHashSet<>();
        names.add("Albert");
        names.add("Dylan");
        names.add("Ross");
        names.add("Craig");
        names.add("Mohammed");
        names.add("Dzeraldas");
        names.add("Dominik");
        names.add("Dillon");
        names.add("Ethan");
        names.add("julius");
        System.out.println(names);
        String bestName = "Ross";
        //Print the int value associated with the first character of the best name
        System.out.println((int)bestName.toCharArray()[0]);
        //Raise 31 to the power of 3
        System.out.println(((int)bestName.toCharArray()[0]) * Math.pow(31, 3));





    }

    private static void populateLinkedList(LinkedList<String> words)
    {
        words.add("Hello");
        words.add("World");
        words.add("I");
        words.add("Am");
        words.add("John");
        words.add("Loane");
        words.add("I");
        words.add("Am");
        words.add("A");
        words.add("Student");
    }

    private static void linkedListQuestion3(LinkedList<String> words)
    {
        //Write a loop that prints every second element of a lined list of strings called words
        ListIterator<String> iter = words.listIterator();
        while(iter.hasNext())
        {
            System.out.println(iter.next());
            if(iter.hasNext())
            {
                iter.next();
            }
        }


    }

    private static void linkedListQuestion2(LinkedList<String> words)
    {
        // Write a loop that removes all strings with length less a parameter n from a linked list of strings called words


        int minWordLength = 4;
        removeWorldsLessThanFour(words, minWordLength);
    }

    private static void removeWorldsLessThanFour(LinkedList<String> words, int minWordLength)
    {
        ListIterator<String> iter = words.listIterator();
        while(iter.hasNext())
        {
            String word = iter.next();
            if(word.length() < minWordLength)
            {
                iter.remove();
            }
        }
        System.out.println(words);
    }

    private static void linkedListQuestion1()
    {
        /*Suppose the list lst contains elements "A", "B", "C", and "D". Draw the contents of the list and the iterator position for the following operations:
         */
        LinkedList<String> letters = new LinkedList<>();
        ListIterator<String> iter = letters.listIterator();
        iter.add("A");
        iter.add("B");
        iter.add("C");
        iter.add("D");    // A B C D|
        //Reset the iterator to the beginning of the list
        iter = letters.listIterator(); // |A B C D
        iter.next(); // A |B C D
        iter.next(); // A B |C D
        iter.remove(); // A B |D
        iter.next(); // A B D |
        iter.add("E"); // A B D E |
        System.out.println(iter.next()); // A B D E |
        //iter.next();
        iter.add("F"); // A B D E F |
    }

    private static void linkedListDemo()
    {
        LinkedList<String> oopClassNames = new LinkedList<>();
        oopClassNames.add("Daniel");
        oopClassNames.add("Dovydas");
        oopClassNames.add("Dzeraldas");
        oopClassNames.add("Marko");

        // | in the comments below indicates the current position of the iterator

        ListIterator<String> iterator = oopClassNames.listIterator(); // |Daniel Dovydas Dzeraldas Marko
        iterator.next(); // Daniel |Dovydas Dzeraldas Marko
        iterator.next(); // Daniel Dovydas |Dzeraldas Marko

        // Add more elements after the second element
        iterator.add("Dominik"); // Daniel Dovydas Dominik |Dzeraldas Marko
        iterator.add("Keven"); // Daniel Dovydas Dominik Kevin |Dzeraldas Marko

        iterator.next(); // Daniel Dovydas Dominik Kevin Dzeraldas |Marko

        // Remove the last traversed element
        iterator.remove(); // Daniel Dovydas Dominik Kevin |Marko

        //Print all elements
        System.out.println(oopClassNames);
        System.out.println("Expected: [Daniel, Dovydas, Dominik, Kevin, Marko]");

    }
}

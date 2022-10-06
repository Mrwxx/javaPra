package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {

        var staff = new Employee[3];
        staff[0] = new Employee("aa", 1);
        staff[1] = new Employee("bb", 2);
        staff[2] = new Employee("cc", 3);
        int[] ints = new int[3];
        int[] ans = new int[3];
        int[] ints1 = Arrays.copyOf(ans, ans.length);
        try(var out = new PrintWriter("a.txt", String.valueOf(StandardCharsets.UTF_8))){
            writeData(staff, out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(var in = new Scanner(new FileInputStream("a.txt"), "UTF-8")){
            Employee[] newStaff = readData(in);

            for(Employee e: newStaff){
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeData(Employee[] employees, PrintWriter out){
        out.println(employees.length);

        for(Employee e : employees){
            writeEmployee(out, e);
        }
    }

    private static Employee[] readData(Scanner in){
        int n = in.nextInt();
        in.nextLine();

        var employees = new Employee[n];
        for(int i = 0; i < n; ++i){
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    public static void writeEmployee(PrintWriter out, Employee e){
        out.println(e.getName() + "|" + e.getAge() + "|" );
    }

    public static Employee readEmployee(Scanner in){
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        return new Employee(name , age);
    }
}

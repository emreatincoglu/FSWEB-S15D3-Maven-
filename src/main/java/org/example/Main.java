package org.example;

import org.example.entity.Employee;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employeeList = new LinkedList<>();

        employeeList.add(new Employee(1, "Ahmet", "Yilmaz"));
        employeeList.add(new Employee(1, "Ahmet", "Yilmaz"));
        employeeList.add(new Employee(2, "Ayse", "Yilmaz"));
        employeeList.add(new Employee(2, "Ayse", "Yilmaz"));
        employeeList.add(new Employee(3, "Irfan", "Turketapan"));
        employeeList.add(new Employee(4, "Cevahir", "Hamilli"));

        System.out.println("Tekrar Edenler: " + findDuplicates(employeeList));
        System.out.println("Benzersiz Harita: " + findUniques(employeeList));
        System.out.println("Sadece Bir Kez Geçenler: " + removeDuplicates(employeeList));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        List<Employee> duplicates = new LinkedList<>();
        Map<Employee, Integer> countMap = new HashMap<>();

        for (Employee e : employees) {
            if (e == null) continue;
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        }

        for (Employee e : employees) {
            if (e == null) continue;
            if (countMap.get(e) > 1 && !duplicates.contains(e)) {
                duplicates.add(e);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniquesMap = new HashMap<>();
        for (Employee e : employees) {
            if (e != null) {
                uniquesMap.put(e.getId(), e);
            }
        }
        return uniquesMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> onlyOnce = new LinkedList<>();
        Map<Employee, Integer> countMap = new HashMap<>();

        for (Employee e : employees) {
            if (e == null) continue;
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        }

        for (Employee e : employees) {
            if (e == null) continue;
            if (countMap.get(e) == 1) {
                onlyOnce.add(e);
            }
        }
        return onlyOnce;
    }
}
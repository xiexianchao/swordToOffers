package com.xiechao.swordToOffers.leetcode;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工的重要性
 */
public class LeetCode690 {
    class Employee{
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    //25ms
    public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        if(employees == null || employees.size() <= 0)
                return 0;
        Employee one = getOne(employees,id);
            sum += one.importance;
        for (Integer ids:one.subordinates) {
             sum += getImportance(employees,ids);
        }
        return sum;

    }

    private Employee getOne(List<Employee> employees,int id){
        for (Employee employee: employees) {
            if(employee.id == id)
                return employee;
        }
       return null;
    }


    //7ms 借助map来实现0(1)查找

    public int getImportance2(List<Employee> employees,int id){
        if(employees == null || employees.size() <= 0)
            return 0;

        Map<Integer,Employee> map = new HashMap<>();
        Employee find = null;
        for (Employee current:employees) {
            map.put(current.id,current);
            if(current.id == id)
                find = current;
        }
        int sum = find.importance;
        sum += helper(map,find.subordinates);

        return sum;
    }
    int helper(Map<Integer, Employee> map, List<Integer> subordinates){
        if(subordinates == null || subordinates.size() <=0)
            return 0;
        int sum = 0;
        for (Integer id:subordinates) {
            Employee current = map.get(id);
            sum += current.importance;
            sum += helper(map,current.subordinates);
        }
        return sum;
    }


    @Test
    public void test(){
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        employee1.subordinates = new ArrayList<>();
        employee1.subordinates.add(2);
        employee1.subordinates.add(3);
        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;
        employee2.subordinates = new ArrayList<>();

        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance = 3;
        employee3.subordinates = new ArrayList<>();

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        System.out.println(getImportance(employees,1));


    }


}

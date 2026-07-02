package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.stream.*;
import java.util.Comparator;

public class NewEmployee{
	String name; 
	int age; 
	int salary;
	public  NewEmployee(String name, int age,int salary ){
		this.name= name; 
		this.age= age;
		this.salary= salary;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setSalary(int salary){
		this.salary = salary;
	}
	
	public String getName(){
		return this.name;
	}
	public int getAge(){
		 return this.age;
	}
	public int getSalary(){
		return this.salary ;
	}
	public static void main(String[] args){
		List<NewEmployee> employees = List.of(new NewEmployee("bala",20,1000),new NewEmployee("sai",25,2000));
		List<Integer> salaries = employees.stream().map(NewEmployee::getSalary).collect(Collectors.toList());
		
		List<NewEmployee> sortedEmp = employees.stream().sorted(Comparator.comparingInt(NewEmployee::getSalary)).collect(Collectors.toList());
		System.out.println(sortedEmp.toString());
		
	}
	
	@Override
    public String toString() {
    return "Employee{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", salary=" + salary +
            '}';
}
	
}

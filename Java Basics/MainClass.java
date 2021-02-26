package com.company;

import java.util.Scanner;

abstract class Employee{

    public abstract void netpay();
}
class Intern extends Employee{
    @Override
    public void netpay() {
        System.out.println("netpay of Intern");
    }

}
class Confirm extends Employee{
    @Override
    public void netpay() {
        System.out.println("netpay of confirmed emp");
    }

}
class Contract extends Employee{
    @Override
    public void netpay() {
        System.out.println("netpay of Contract employee");
    }
}
class HR{
    public Employee recruit(String emp) {
        Employee e;
        if (emp.equalsIgnoreCase("Intern")) {
             e = new Intern();
        }
        else if(emp.equalsIgnoreCase("Confirm")){
             e = new Confirm();
        }
        else{
            e = new Contract();
        }
      return e;
    }
}
class Finance{
    public void processSalary(Employee e){
        e.netpay();
    }

}
public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String empType = sc.next();
        HR h = new HR();
       Employee obj = h.recruit(empType);
        Finance f = new Finance();
        f.processSalary(obj);
    }
}

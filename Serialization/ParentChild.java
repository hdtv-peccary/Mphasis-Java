package com.mph;

import java.io.Serializable;

class Base implements Serializable{

    int parent = 1;
    public Base() {
        System.out.println("Base Constructor...");
        parent = 3;
    }
    {
        parent = 2;
        System.out.println("Instance Block....");
    }

}

class Derived extends Base{
        int child = 4;
public Derived() {
        System.out.println("Derived Constructor...");
        child = 5;
        }
        {
        child=6;
        }
        }

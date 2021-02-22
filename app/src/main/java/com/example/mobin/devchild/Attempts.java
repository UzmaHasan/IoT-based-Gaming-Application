package com.example.mobin.devchild;

import java.util.ArrayList;

public class Attempts {
    public String at1,at2,at3;
    public ArrayList<String> attempts;

    public Attempts(){
        attempts = new ArrayList<>();
    }

    public Attempts(String at1, String at2, String at3){
        this.at1=at1;
        this.at2=at2;
        this.at3=at3;
    }
    public Attempts(ArrayList<String> arr)
    {
        attempts = new ArrayList<>();
        for(int i=0;i<arr.size();i++)
        {
            attempts.add(arr.get(i));
        }
    }

    //public ArrayList<String> getAllAttempts()
    //{
    //    return attempts;

    //}
    public String getAt1() {
        return at1;
    }

    public void setAt1(String at1) {
        this.at1 =at1;
    }

    public String getAt2() {
        return at2;
    }

    public void setAt2(String at2) {
        this.at2 =at2;
    }

    public String getAt3() {
        return at3;
    }

    public void setAt3(String at3) {
        this.at3 =at3;
    }

}

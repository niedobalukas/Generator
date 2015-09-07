/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

/**
 * 
 * @author Lukas N.
 */


public class Person {
    private static int glb_id = 0;
    private int id;
    private Age age;
    private Sex sex;
    //City city; //Unused
    private MartialStatus martial_status;
    private Title title;
    
    
    private int age_from = 15, age_to = 80;
    
    public Person()
    {
        id = glb_id++;
        age = new Age((int)(Math.random()*(age_to-age_from-1)+age_from));
        sex = Sex.getRandom();
        martial_status = MartialStatus.getRandom(age.getVal());
        title = Title.getRandom(age.getVal());   
    }
    
    static void resetGenerator(){
        glb_id = 0;
    }
    
    void set_age_interval(int from,int to)
    {
        if(from<to)
        { 
        age_from = from;
        age_to = to;
        }
    }

    public int getId() {
        return id;
    }
    
    public int DB_getId() {
        return id;
    }

    public int DB_getAge() {
        return age.getVal();
    }
    
    public Age getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    

    public MartialStatus getMartial_status() {
        return martial_status;
    }
    
    public int getDBMartial_status() {
        return martial_status.ordinal();
    }

    public Title getTitle() {
        return title;
    }
    
    public int getDBTitle() {
        return title.ordinal();
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", age=" + age.toString() + ", sex=" + sex + ", martial_status=" + martial_status + ", title=" + title + '}';
    }
    
    
    
    
    
}

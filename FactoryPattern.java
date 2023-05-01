package Creational;
// A company develops a game wherein different types of characters as warriors, mages, and archers are involved.
// Each character has unique abilities and characteristics that define its behaviour in game.
// Company makes a system that allows them to easily create new types of characters in the futeure without modifying the existing code.
// The req class can have create_character method taking a character and returning an instance of the character such as warriors, mages and archers.
// Each character can be implemented as a subclass with its own unique ability and character.
// The game code can then use the required class to create new character objects as needed, without having to know how each character type is implemented


abstract class Charcater{
    String Name;
    int healthPoints;
    int attackPoints;
    int defendPoints;

    public abstract void attack();
    public abstract void defend();
}

class Archer extends Charcater{
 
    public Archer(String Name){
        this.Name= Name; 
        this.attackPoints = 5;
        this.defendPoints = 4;
        this.healthPoints = 100;
    }

    public void attack(){
        System.out.println("Archer's attack");
    }

    public void defend(){
        System.out.println("Archer's defend");
    }
}

class Warrior extends Charcater{
    public Warrior(String Name){
        this.Name= Name; 
        this.attackPoints = 6;
        this.defendPoints = 5;
        this.healthPoints = 90;
    }

    public void attack(){
        System.out.println("Warriors attack");
    }

    public void defend(){
        System.out.println("Warrior's defend");
    }
}

class Wizard extends Charcater{
    public Wizard(String Name){
        this.Name= Name; 
        this.attackPoints = 10;
        this.defendPoints = 0;
        this.healthPoints = 120;
    }

    public void attack(){
        System.out.println("Wizard's attack");
    }

    public void defend(){
        System.out.println("wizard's can't defend");
    }

    public void castSpell(){
        System.out.println("Casting Spell Doubling The Attack.");
    }
}

class CharacterFactory{
    public Charcater createCharcater(String ch, String name){
        if (ch.equalsIgnoreCase("warrior")) {
            return new Warrior(name);
        }
        else if(ch.equalsIgnoreCase("Archer")){
            return new Archer(name);
        }
        else if(ch.equalsIgnoreCase("Wizard")){
            return new Wizard(name);
        }
        else{
            return null;
        }
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        CharacterFactory c1 = new CharacterFactory();
        Charcater c2 = c1.createCharcater("Archer", "M_Archer");
        c2.attack();
        c2.defend();
    }
    
}
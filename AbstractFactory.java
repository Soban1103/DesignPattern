package Creational;


interface Toy{
    public void Description();
    public void Company();
    public void Price();
}

interface Remote{
    public void On();
    public void Off();
}

interface AbsFactory{
    Toy toy();
    Remote remote();
}

class EducationalToy implements Toy{
    public void Description(){
        System.out.println("Education Toy");
    }
    public void Company(){
        System.out.println("ABC Company");
    }
    public void Price(){
        System.out.println("It cost 150");
    }
}

class SoftToy implements Toy{
    public void Description(){
        System.out.println("Soft Toy Company");
    }
    public void Company(){
        System.out.println("XYZ Company");
    }
    public void Price(){
        System.out.println("200 Rs only");
    }
}

class EducationalRemote implements Remote{
    public void On(){
        System.out.println("On Toy");
    }
    public void Off(){
        System.out.println("Off Toy");
    }
}

class SoftRemote implements Remote{
    public void On(){
        System.out.println("On Soft Toy");
    }
    public void Off(){
        System.out.println("Off soft toy");
    }
}

class EducationalFactory implements AbsFactory{
    @Override
    public EducationalToy toy(){
        return new EducationalToy();
    }

    @Override
    public EducationalRemote remote(){
        return new EducationalRemote();
    }
}

class SoftFactory implements AbsFactory{
    @Override
    public SoftToy toy(){
        return new SoftToy();
    }

    @Override
    public SoftRemote remote(){
        return new SoftRemote();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        SoftFactory sf = new SoftFactory();
        sf.toy();
        sf.remote();
        sf.toy().Description();
        sf.toy().Price();
    }
}

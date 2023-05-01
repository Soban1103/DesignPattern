interface State{
    public void stateHandle();
}

class State1 implements State{
   
    public void stateHandle() {
        System.out.println("Welcome State");
        System.out.println("Intial state1 - can move to state2");
    }
}

class State2 implements State{
   
    public void stateHandle() {
        System.out.println("state2 - can move to state3");
    }
}
class State3 implements State{
   
    public void stateHandle() {
        System.out.println("state3 - Last State of context - can move to initial state1");
    }
}

class Context{
    State s;

    public Context(State s){
        this.s=s;
    }
    public void setState(State s){
        this.s=s;
    }
    public State getState(){
        return s;
    }

    public void performAction(){
        s.stateHandle();
    }

}


public class StateDemo {
    public static void main(String[] args) {
        State s1 = new State1();
        State s2 = new State2();
        State s3 = new State3();
        
        Context c = new Context(s1);
        c.performAction();

        c.setState(s2);
        c.performAction();
        
    }
}

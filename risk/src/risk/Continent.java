package risk;

public class Continent {

    private String name;
    private int stateNo;
    private State[] state;

    public Continent(String name, int stateNo) {
        this.name = name;
        this.stateNo = stateNo;
    }

    public String getName() {
        return name;
    }

    public int getStateNo() {
        return stateNo;
    }

    public State[] getState() {
        return state;
    }

    public void setState(State[] state) {
        this.state = state;
    }

}

package motek;

public class MotekRequest {

    private String number;

    private String userInput;

    public MotekRequest(String number, String event) {
        this.number = number;
        this.userInput = event;
    }

    public String getNumber() {
        return number;
    }

    public String getUserInput() {
        return userInput;
    }
}

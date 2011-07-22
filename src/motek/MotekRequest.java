package motek;


public class MotekRequest {

    private String number;

    private String userInput;

    public MotekRequest(String number, String dtmf) {
        this.number = number;
        this.userInput = dtmf;
    }

    public String getNumber() {
        return number;
    }

    public String getUserInput() {
        return userInput;
    }
}

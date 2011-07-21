package example;


public class IVRRequest {

    private String number;

    private String userInput;

    public IVRRequest(String number, String dtmf) {
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

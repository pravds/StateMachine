package motek;

public class MotekContext {

    private MotekRequest request;

    private MotekResponse response;

    public MotekRequest getRequest() {
        return request;
    }

    public void setRequest(MotekRequest request) {
        this.request = request;
    }

    public MotekResponse getResponse() {
        return response;
    }

    public void setResponse(MotekResponse response) {
        this.response = response;
    }
}

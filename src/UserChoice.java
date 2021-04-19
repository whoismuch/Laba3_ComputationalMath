public class UserChoice {

    private int number;
    private Double accuracy;
    private Double integrationLeftLimit;
    private Double integrationRightLimit;

    public UserChoice (int number, Double accuracy, Double integrationLeftLimit, Double integrationRightLimit) {
        this.number = number;
        this.accuracy = accuracy;
        this.integrationLeftLimit = integrationLeftLimit;
        this.integrationRightLimit = integrationRightLimit;
    }

    public int getNumber ( ) {
        return number;
    }

    public Double getAccuracy ( ) {
        return accuracy;
    }

    public Double getIntegrationLeftLimit ( ) {
        return integrationLeftLimit;
    }

    public Double getIntegrationRightLimit ( ) {
        return integrationRightLimit;
    }
}

public class CommunicationSatellite extends Satellite {
    private double bandwidth;

    public CommunicationSatellite(String name, double batteryLevel, double bandwidth) {
        super(name, batteryLevel);
        this.bandwidth = bandwidth;
    }

    public double getBandwidth() {
        return bandwidth;
    }

    @Override
    public void performMission() {
        if (!isActive) {
            System.out.println(name + ": Не может передать данные - не активен");
            return;
        }
        
        System.out.println(name + ": Передача данных со скоростью " + bandwidth + " Мбит/с");
        sendData(bandwidth);
        consumeBattery(0.05);
    }

    public void sendData(double dataSize) {
        if (isActive) {
            System.out.println(name + ": Отправил " + dataSize + " Мбит данных!");
        }
    }

    @Override
    public String toString() {
        return "CommunicationSatellite{" +
                "bandwidth=" + bandwidth +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}
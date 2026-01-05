public abstract class Satellite {
    protected String name;
    protected boolean isActive;
    protected double batteryLevel;

    public Satellite(String name, double batteryLevel) {
        this.name = name;
        this.batteryLevel = batteryLevel;
        this.isActive = false;
    }

    public boolean activate() {
        if (batteryLevel > 0.2) {
            isActive = true;
            return true;
        }
        return false;
    }

    public void deactivate() {
        isActive = false;
    }

    public void consumeBattery(double amount) {
        if (isActive) {
            batteryLevel -= amount;
            if (batteryLevel <= 0) {
                batteryLevel = 0;
                isActive = false;
                System.out.println("Внимание: " + name + " полностью разряжен и отключен.");
            }
        }
    }

    public abstract void performMission();
    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }
}
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("ЗАПУСК СИСТЕМЫ УПРАВЛЕНИЯ СПУТНИКОВОЙ ГРУППИРОВКОЙ");
        System.out.println("============================================================");

        System.out.println("\nСОЗДАНИЕ СПЕЦИАЛИЗИРОВАННЫХ СПУТНИКОВ:");
        System.out.println("---------------------------------------------");

        CommunicationSatellite com1 = new CommunicationSatellite("Связь-1", 0.85, 500.0);
        System.out.println("Создан спутник: " + com1.name + " (заряд: " + (int)(com1.batteryLevel * 100) + "%)");

        CommunicationSatellite com2 = new CommunicationSatellite("Связь-2", 0.75, 1000.0);
        System.out.println("Создан спутник: " + com2.name + " (заряд: " + (int)(com2.batteryLevel * 100) + "%)");

        ImagingSatellite img1 = new ImagingSatellite("ДЗЗ-1", 0.92, 2.5);
        System.out.println("Создан спутник: " + img1.name + " (заряд: " + (int)(img1.batteryLevel * 100) + "%)");

        ImagingSatellite img2 = new ImagingSatellite("ДЗЗ-2", 0.45, 1.0);
        System.out.println("Создан спутник: " + img2.name + " (заряд: " + (int)(img2.batteryLevel * 100) + "%)");

        ImagingSatellite img3 = new ImagingSatellite("ДЗЗ-3", 0.15, 0.5);
        System.out.println("Создан спутник: " + img3.name + " (заряд: " + (int)(img3.batteryLevel * 100) + "%)");

        System.out.println("---------------------------------------------");

        SatelliteConstellation constellation = new SatelliteConstellation("RU Basic");
        System.out.println("Создана спутниковая группировка: RU Basic");
        System.out.println("---------------------------------------------");

        System.out.println("ФОРМИРОВАНИЕ ГРУППИРОВКИ:");
        System.out.println("-----------------------------------");
        constellation.addSatellite(com1);
        constellation.addSatellite(com2);
        constellation.addSatellite(img1);
        constellation.addSatellite(img2);
        constellation.addSatellite(img3);
        System.out.println("-----------------------------------");

        // Вывод списка
        System.out.println(constellation.getSatellites());
        System.out.println("-----------------------------------");

        System.out.println("\nАКТИВАЦИЯ СПУТНИКОВ:");
        System.out.println("-------------------------");
        
        List<Satellite> allSats = constellation.getSatellites();
        for (Satellite s : allSats) {
            boolean result = s.activate();
            if (result) {
                System.out.println(s.getName() + ": Активация успешна");
            } else {
                System.out.println(s.getName() + ": Ошибка активации (заряд: " + (int)(s.getBatteryLevel() * 100) + "%)");
            }
        }

        System.out.println("\nВЫПОЛНЕНИЕ МИССИЙ ГРУППИРОВКИ RU BASIC");
        System.out.println("==================================================");
        constellation.executeAllMissions();
        System.out.println(constellation.getSatellites());
    }
}
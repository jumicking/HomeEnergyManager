/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homeenergymanager;
 import javax.swing.JOptionPane;
/**
 *
 * @author Abram
 */
class ElectricityMonitor {
    private Appliance[] appliances;
    private int maxAppliances;
    private int currentCount;
    private double electricityCostPerKWh = 11.7882;

    public ElectricityMonitor(int maxAppliances) {
        this.maxAppliances = maxAppliances;
        this.appliances = new Appliance[maxAppliances];
        this.currentCount = 0;
    }

    public boolean addAppliance(String name, double powerInWatts, double dailyHours) {
        if (currentCount < maxAppliances) {
            appliances[currentCount++] = new Appliance(name, powerInWatts, dailyHours);
            return true;
        }
        return false;
    }

    public boolean removeAppliance(String name) {
        for (int i = 0; i < currentCount; i++) {
            if (appliances[i].getName().equalsIgnoreCase(name)) {
                appliances[i] = appliances[--currentCount];
                appliances[currentCount] = null;
                return true;
            }
        }
        return false;
    }

    public boolean updateAppliance(String name, double newHours) {
        for (int i = 0; i < currentCount; i++) {
            if (appliances[i].getName().equalsIgnoreCase(name)) {
                appliances[i].setDailyHours(newHours);
                return true;
            }
        }
        return false;
    }

    public String displayAppliances() {
        if (currentCount == 0) return "No appliances added yet.";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < currentCount; i++) {
            Appliance appliance = appliances[i];
            sb.append(String.format("%d. %s - %.2f watts, %.2f hours/day\n", i + 1, appliance.getName(),
                    appliance.getPowerInWatts(), appliance.getDailyHours()));
        }
        return sb.toString();
    }

    public double calculateTotalDailyUsage() {
        double total = 0;
        for (int i = 0; i < currentCount; i++) {
            total += appliances[i].getDailyUsage();
        }
        return total;
    }

    public double calculateDailyBill() {
        return calculateTotalDailyUsage() * electricityCostPerKWh;
    }

    public String calculateMonthlyBill() {
        if (currentCount == 0) return "No appliances added yet.";
        StringBuilder sb = new StringBuilder();
        double totalMonthlyUsage = 0;
        for (int i = 0; i < currentCount; i++) {
            Appliance appliance = appliances[i];
            double monthlyUsage = appliance.getDailyUsage() * 30; // Approximate 30 days
            totalMonthlyUsage += monthlyUsage;
            sb.append(String.format("%s: %.2f kWh - ₱%.2f\n", appliance.getName(), monthlyUsage,
                    monthlyUsage * electricityCostPerKWh));
        }
        sb.append(String.format("Total Monthly Usage: %.2f kWh\n", totalMonthlyUsage));
        sb.append(String.format("Total Monthly Bill: ₱%.2f\n", totalMonthlyUsage * electricityCostPerKWh));
        return sb.toString();
    }
}



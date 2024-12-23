/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homeenergymanager;

/**
 *
 * @author Abram
 */
class Appliance {
    private String name;
    private double powerInWatts;
    private double dailyHours;

    public Appliance(String name, double powerInWatts, double dailyHours) {
        this.name = name;
        this.powerInWatts = powerInWatts;
        this.dailyHours = dailyHours;
    }

    public String getName() {
        return name;
    }

    public double getPowerInWatts() {
        return powerInWatts;
    }

    public void setPowerInWatts(double powerInWatts) {
        this.powerInWatts = powerInWatts;
    }

    public double getDailyHours() {
        return dailyHours;
    }

    public void setDailyHours(double dailyHours) {
        this.dailyHours = dailyHours;
    }

    public double getDailyUsage() {
        return (powerInWatts / 1000) * dailyHours;
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package homeenergymanager;
import javax.swing.JOptionPane;
/**
 *
 * @author jumayca malilong
 */
public class HomeEnergyManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String maxAppliancesInput = JOptionPane.showInputDialog("Enter the maximum number of appliances:");
        int maxAppliances = Integer.parseInt(maxAppliancesInput);

        ElectricityMonitor monitor = new ElectricityMonitor(maxAppliances);

        while (true) {
            String[] options = {"Daily Usage", "Monthly Usage", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Home Energy Manager",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 2 || choice == -1) break; // Exit

            if (choice == 0) { // Daily Usage
                while (true) {
                    String[] dailyOptions = {"Add Appliance", "Update Appliance", "Remove Appliance", "Display Appliances",
                            "Calculate Daily Bill", "Back"};
                    int dailyChoice = JOptionPane.showOptionDialog(null, "Manage daily usage:", "Daily Electricity Monitor",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, dailyOptions, dailyOptions[0]);

                    if (dailyChoice == 5 || dailyChoice == -1) break; // Back

                    switch (dailyChoice) {
                        case 0: // Add Appliance
                            String name = JOptionPane.showInputDialog("Enter the appliance name:");
                            double power = Double.parseDouble(JOptionPane.showInputDialog("Enter power consumption in watts:"));
                            double hours = Double.parseDouble(JOptionPane.showInputDialog("Enter daily usage in hours:"));
                            if (monitor.addAppliance(name, power, hours)) {
                                JOptionPane.showMessageDialog(null, "Appliance added successfully.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Maximum appliances reached.");
                            }
                            break;
                        case 1: // Update Appliance
                            String updateName = JOptionPane.showInputDialog("Enter the appliance name to update:");
                            double newHours = Double.parseDouble(JOptionPane.showInputDialog("Enter new daily usage in hours:"));
                            if (monitor.updateAppliance(updateName, newHours)) {
                                JOptionPane.showMessageDialog(null, "Appliance updated successfully.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Appliance not found.");
                            }
                            break;
                        case 2: // Remove Appliance
                            String removeName = JOptionPane.showInputDialog("Enter the appliance name to remove:");
                            if (monitor.removeAppliance(removeName)) {
                                JOptionPane.showMessageDialog(null, "Appliance removed successfully.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Appliance not found.");
                            }
                            break;
                        case 3: // Display Appliances
                            JOptionPane.showMessageDialog(null, monitor.displayAppliances(), "Appliances",
                                    JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 4: // Calculate Daily Bill
                            double dailyUsage = monitor.calculateTotalDailyUsage();
                            double dailyBill = monitor.calculateDailyBill();
                            JOptionPane.showMessageDialog(null, String.format("Total Daily Usage: %.2f kWh\nDaily Bill: ₱%.2f",
                                    dailyUsage, dailyBill), "Daily Bill", JOptionPane.INFORMATION_MESSAGE);
                            break;
                    }
                }
            } else if (choice == 1) { // Monthly Usage
                JOptionPane.showMessageDialog(null, monitor.calculateMonthlyBill(), "Monthly Bill",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}

  

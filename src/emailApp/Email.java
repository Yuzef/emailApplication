package emailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Constructor to receive firstName and lastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("\nDepartment: " + this.department);

        // Call a method that returns a random password
        this.password = generateRandomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is: " + email);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("New worker: " + firstName + ".\nDepartment codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter your department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        String choice;

        switch (depChoice) {
            case 1:
                choice = "Sales";
                break;
            case 2:
                choice = "Dev";
                break;
            case 3:
                choice = "Accounting";
                break;
            default:
                choice = "";
                break;
        }
        return choice;
    }

    // Generate a random password
    private String generateRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%^&";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mail box capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }
}


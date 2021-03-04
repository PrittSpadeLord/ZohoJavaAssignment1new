import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BankingApplication {
    public static void main(String[] args) throws ParseException {

        /*
        Declare all variables.
        */

        //Customer
        Customer pritt = new Customer();
        pritt.name = "Pritt";
        pritt.phoneNumber = 987654321L;

        pritt.dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse("12/12/1999");
        pritt.email = "prittsfakegmail@gmail.com";
        pritt.address = new Address("123", "Fake Address", "Fake City", 12354);

        Account prittCurrent = new Account();
        prittCurrent.accountNumber = 322059659;
        prittCurrent.type = "current";
        prittCurrent.balance = 1000;
        prittCurrent.accountCreationDate = new Date();

        Account prittSavings = new Account();
        prittSavings.accountNumber = 302040506;
        prittSavings.type = "savings";
        prittSavings.balance = 1000;
        prittSavings.accountCreationDate = new Date();

        Account[] a = {prittCurrent, prittSavings};
        pritt.accounts = a;

        //HosurBranch

        Employee manager = new Employee("Hosur Branch Manager", "manager@icici.com", "branch_manager", 1000000L);

        Employee emp1 = new Employee("Employee 1", "emp1@icici.com", "employee", 100000L);
        Employee emp2 = new Employee("Employee 2", "emp2@icici.com", "employee", 100000L);

        BankBranch hosurBranch = new BankBranch();
        hosurBranch.manager = manager;

        Employee[] e = {emp1, emp2};
        hosurBranch.employees = e;

        hosurBranch.address = new Address("Unknown location", "Unknown Street", "Hosur", (short)635110);

        //Bank
        Employee ceo = new Employee("The CEO of ICICI", "ceo@icici.com", "ceo", 100000000L);

        Bank icici = new Bank();

        icici.name = "ICICI";
        icici.netWorth = 1000000000000000000L;
        icici.ceo = ceo;

        BankBranch[] b = {hosurBranch};
        icici.branches = b;

        Customer[] c = {pritt};
        icici.customers = c;

        /*
        Creating console application
        */

        Scanner scan = new Scanner(System.in);
        boolean stop = false;
        boolean sup = false;

        System.out.println(" __        __   _                          ");
        System.out.println(" \\ \\      / /__| | ___ ___  _ __ ___   ___ ");
        System.out.println("  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\");
        System.out.println("   \\ V  V /  __/ | (_| (_) | | | | | |  __/");
        System.out.println("   \\ V  V /  __/ | (_| (_) | | | | | |  __/");
        System.out.println("    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|");

        System.out.println("\nWelcome to Console banking application");
        System.out.println("++++++++++++++++++++++++++++++++++++++\n");

        while(!stop) {
            System.out.print("> ");
            String command = scan.nextLine();
            System.out.print("\n");

            //Command handling goes here...
            
            if(command.equals("end")) {
                stop = true;

                System.out.println("  _____ _                 _                            ");
                System.out.println(" |_   _| |__   __ _ _ __ | | __      _   _  ___  _   _ ");
                System.out.println("   | | | '_ \\ / _` | '_ \\| |/ /     | | | |/ _ \\| | | |");
                System.out.println("   | | | | | | (_| | | | |   <      | |_| | (_) | |_| |");
                System.out.println("   |_| |_| |_|\\__,_|_| |_|_|\\_\\      \\__, |\\___/ \\__,_|");
                System.out.println("                                     |___/             ");

                System.out.println("\nThank you for using Console Banking Application.");
                scan.close();
            }
            //fill stuff here...
            else if(command.startsWith("super")) {
                String pass = command.split(" ")[1].trim();

                if(pass.equals("qWeRtY")) {
                    sup = true;
                    System.out.println("Admin permissions granted.\nYou are now free to access all the data of the bank.");
                }
                else {
                    System.out.println("Admin permissions denied!");
                }
            }
            else if(command.startsWith("customerdetails")) {

                if(sup == true) {
                    String cname = command.split("customerdetails ")[1].trim();

                    boolean found = false;

                    for(int i=0; i<icici.customers.length; i++) {
                        if(icici.customers[i].name.equals(cname)) {
                            found = true;

                            System.out.println("Customer details:");
                            System.out.println("-----------------\n");

                            System.out.println("Name         : " + icici.customers[i].name);
                            System.out.println("Phone number : " + icici.customers[i].phoneNumber);
                            System.out.println("Email        : " + icici.customers[i].email);

                            System.out.println("\nAddress:\n" + icici.customers[i].address.display()+ "\n");

                            System.out.println("Type \"customerbankaccounts [Customer's name]\" to see their bank account details and transaction history.");
                        }
                    }

                    if(!found) {
                        System.out.println("A customer with that name was not found! Please retype the name correctly.");
                    }
                }
                else {
                    System.out.println("You are not authorized to perform this action. Do \"super [password]\" to gain access.");
                }
            }
            else if(command.startsWith("customerdetails ")) {
                //do it
            }

            else if(command.equals("help")) {
                System.out.println("Help section of the Console Banking Application:\n");
                System.out.println("------------------------------------------------\n");

                //List of commands
                System.out.println("help                            - Shows this message.");
                System.out.println("super [password]                - Gives you admin powers if the password is correct");
                System.out.println("customerdetails [customer_name] - Shows details about the customer. Can only be done with admin powers.");
                System.out.println("end                             - Terminates the console application.");
            }
            else {
                System.out.println("Unknown command! Type \"help\" to learn more.");
            }

            System.out.print("\n");
        }
    }
}

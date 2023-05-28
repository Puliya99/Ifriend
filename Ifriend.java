import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;
public class Ifriend {
    public static Scanner input = new Scanner(System.in);
    public static String[] idArray = new String[0];
    public static String[] nameArray = new String[0];
    public static String[] phoneNumberArray = new String[0];
    public static String[] companyNameArray = new String[0];
    public static double[] salaryArray = new double[0];
    public static String[] bdayArray = new String[0];

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public final static void homePage() {
        System.out.println("\t\t\t			/$$ /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$  /$$$$$$$  				");
        System.out.println("\t\t\t			|__/| $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$|  $$__  $$				");
        System.out.println("\t\t\t			 /$$| $$      | $$  \\ $$  | $$  | $$      | $$$$| $$|  $$  \\ $$				");
        System.out.println("\t\t\t			| $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$|  $$  | $$				");
        System.out.println("\t\t\t			| $$| $$__/     $$__  $$  | $$  | $$__/   | $$  $$$$|  $$  | $$				");
        System.out.println("\t\t\t			| $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$|  $$  | $$				");
        System.out.println("\t\t\t			| $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$|  $$$$$$$/				");
        System.out.println("\t\t\t			|__/|__/      |__/  |__/|______/|________/|__/  \\__/|________/ 				");
        System.out.println();
        System.out.println("\t\t\t\t    _____              _             _          ____                        _     					");
        System.out.println("\t\t\t\t   / ____|            | |           | |        / __ \\                      (_)             			");
        System.out.println("\t\t\t\t  | |       ___  _ __ | |_ __ _  ___| |_ ___  | |  | |_ __ __ _ __  _ _ __  _ _______ _ __         	");
        System.out.println("\t\t\t\t  | |      / _ \\| '_ \\| __/ _` |/ __| __/ __| | |  | | '__/ _` |  _` | '_ \\| |_  / _ \\ '__|			");
        System.out.println("\t\t\t\t  | |____ | (_) | | | | || |_| | |__| |_\\__ \\ | |__| | | | |_| | |_| | | | | |/ /  __/ |         	");
        System.out.println("\t\t\t\t   \\_____| \\___/|_| |_|\\__\\__, |\\___|\\__|___/  \\____/|_|  \\__,_|___,_|_| |_|_/___\\___|_|           	");
        System.out.println("\t\t\t\t                                                           __/ |                                    ");
        System.out.println("\t\t\t\t                                                          |___/                                     ");
        System.out.println();
        System.out.println();
        System.out.println("===============================================================================================================================================================       ");
        System.out.println();
        System.out.println();
        System.out.print("[01] ADD Contact\n");
        System.out.print("[02] Update Contacts\n");
        System.out.print("[03] DELETE Contacts\n");
        System.out.print("[04] SEARCH Contacts\n");
        System.out.print("[05] List Contacts\n");
        System.out.print("[06] Exit\n");
        System.out.println();
        System.out.println();
        System.out.print("Enter an option to continue > ");
    }

    public static String generateContactId() {
        if (idArray.length== 0) {
            return "C0001";
        } else {
            return "C"+String.format("%04d",idArray.length+1);
        }
    }

    public static void addContact() {
        l1: do{
            clearConsole();
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                       ADD Contact to the list                                                                      |");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println();
            System.out.println();
            String id = generateContactId();
            System.out.print("\n " + id + "\n=======\n\n");
            System.out.print("Name               : ");
            String newName = input.next();
            String phoneNumber = "";
            boolean isInvalied = true;
            do{
                System.out.print("Phone Number       : ");
                phoneNumber = input.next();
                isInvalied = getValidPhoneNumber(phoneNumber);
                if (isInvalied){
                    System.out.print("\n\t\tInvalid Phone Number...\n");
                    System.out.print("\nDo You Want To Add Phone Number Again (y/n) : ");
                    String text = input.next();
                    if(text.equalsIgnoreCase("y")){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                    }else if (text.equalsIgnoreCase("N")) {
                        isInvalied = false;
                        clearConsole();
                        homePage();
                        break l1;
                    } else {
                        System.out.println("\nInvalid input. Please enter 'Y' or 'N'.\n");
                    }
                }
            } while(isInvalied);
            System.out.print("Company Name       : ");
            String companyName = input.next();
            double salary = 0.0;
            boolean isInvalidSalary = true;
            do{
                System.out.print("Salary             : ");
                salary = input.nextDouble();
                isInvalidSalary = salary < 0.0 ? true : false;
                if (isInvalidSalary){
                    System.out.print("\n\t\tInvalid Salary...\n");
                    System.out.print("\nDo You Want To Add Salary Again (y/n) : ");
                    String text = input.next();
                    if(text.equalsIgnoreCase("y")){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                    }else if (text.equalsIgnoreCase("N")) {
                        isInvalidSalary = false;
                        clearConsole();
                        homePage();
                        break l1;
                    } else {
                        System.out.println("\nInvalid input. Please enter 'Y' or 'N'.\n");
                    }
                }
            } while (isInvalidSalary);
            String bDay = "";
            boolean isInvaliedDob = true;
            do{
                System.out.print("B'Day(YYYY-MM-DD)  : ");
                bDay = input.next();
                isInvaliedDob = checkDob(bDay);
                if (isInvaliedDob){
                    System.out.print("\n\t\tInvalid Birth Day...\n");
                    System.out.print("\nDo You Want To Add B'Day Again (y/n) : ");
                    String text = input.next();
                    if(text.equalsIgnoreCase("y")){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                    }else if (text.equalsIgnoreCase("N")) {
                        isInvalied = false;
                        clearConsole();
                        homePage();
                        break l1;
                    } else {
                        System.out.println("\nInvalid input. Please enter 'Y' or 'N'.\n");
                    }
                }
            } while (isInvaliedDob);
            AddDataOnArrays(id, newName, phoneNumber, companyName, salary, bDay);
            System.out.println();
            System.out.println("Contact has been added successfully..");
            System.out.println();
            System.out.println();
            System.out.print("Do you want to add another Contact (Y/N): ");
            String addMore = input.next();
            if (addMore.equalsIgnoreCase("N")) {
                clearConsole();
                homePage();
                break;
            }else if (addMore.equalsIgnoreCase("Y")){
                clearConsole();
            }else {
                System.out.println("\nInvalid input. Please enter 'Y' or 'N'.\n");
            }
        } while (true);
    }

    public static Boolean getValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10) {
            if (phoneNumber.startsWith("0")) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDob(String dob) {
        Date date = null;
        String dateNow = "" + LocalDate.now();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(dob);
            if (dob.equals(sdf.format(date))) {
                if (sdf.parse(dob).before(sdf.parse(dateNow))){
                    return false;
                }
            }
        } catch (ParseException ex) {
        }
        return true;
    }

    public static void AddDataOnArrays(String id, String newName, String phoneNumber, String companyName, double salary, String bday){
        String[] tempidArray = new String[idArray.length+1];
        String[] tempnameArray = new String[nameArray.length+1];
        String[] temptelNoArray = new String[phoneNumberArray.length+1];
        String[] tempcompanyArray = new String[companyNameArray.length+1];
        double[] tempsalaryArray = new double[salaryArray.length+1];
        String[] tempdobArray = new String[bdayArray.length+1];
        for (int i = 0; i < idArray.length; i++){
            tempidArray[i] = idArray[i];
            tempnameArray[i] = nameArray[i];
            temptelNoArray[i] = phoneNumberArray[i];
            tempcompanyArray[i] = companyNameArray[i];
            tempsalaryArray[i] = salaryArray[i];
            tempdobArray[i] = bdayArray[i];
        }
        tempidArray[tempidArray.length-1] = id;
        tempnameArray[tempidArray.length-1] = newName;
        temptelNoArray[tempidArray.length-1] = phoneNumber;
        tempcompanyArray[tempidArray.length-1] = companyName;
        tempsalaryArray[tempidArray.length-1] = salary;
        tempdobArray[tempidArray.length-1] = bday;
        idArray = tempidArray;
        nameArray = tempnameArray;
        phoneNumberArray = temptelNoArray;
        companyNameArray = tempcompanyArray;
        salaryArray = tempsalaryArray;
        bdayArray = tempdobArray;
    }

    public static int searchPhoneNo(String num) {
        for (int i = 0; i < phoneNumberArray.length; i++){
            if (phoneNumberArray[i].equals(num)){
                return i;
            }
        }
        return -1;
    }

    public static int SearchName(String name){
        for (int i = 0; i < nameArray.length; i++){
            if (nameArray[i].equals(name)){
                return i;
            }
        }
        return -1;
    }

    public static void updateContacts() {
        l1:do {
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                       Update Contact                                                                               |");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println();
            System.out.println();
            System.out.print("Search Contact by Name or Phone Number: ");
            String search = input.next();
            int index = searchPhoneNo(search);
            if (index != -1) {
                SearchUpdate(index);
            } else {
                index = SearchName(search);
                if (index != -1) {
                    SearchUpdate(index);
                }else {
                    System.out.println("Contact not found.");
                }
            }
            System.out.println();
            System.out.println();
            System.out.print("Do you want to update another contact (Y/N): ");
            String continueUpdating = input.next();
            if (continueUpdating.equalsIgnoreCase("N")) {
                clearConsole();
                homePage();
                break l1;
            } else if (continueUpdating.equalsIgnoreCase("Y")) {
                clearConsole();
            }else {
                System.out.println("\nInvalid input. Please enter 'Y' or 'N'.\n");
            }
        } while (true);
    }

    public static void SearchUpdate(int index){
        System.out.println();
        System.out.println("Contact ID        : " + idArray[index]);
        System.out.println("Name              : " + nameArray[index]);
        System.out.println("Phone Number      : " + phoneNumberArray[index]);
        System.out.println("Company Name      : " + companyNameArray[index]);
        System.out.println("Salary            : " + salaryArray[index]);
        System.out.println("B'Day(YYYY-MM-DD) : " + bdayArray[index]);
        System.out.println();
        System.out.println();
        System.out.println("What do you want to update...");
        System.out.println();
        System.out.println("[1] Name");
        System.out.println("[2] Phone Number");
        System.out.println("[3] Company Name");
        System.out.println("[4] Salary");
        System.out.println();
        System.out.println();
        System.out.print("Enter an option to continue ->");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.print("\033[9A");
                System.out.print("\033[0J");
                System.out.print(" Update Name\n===========\n");
                System.out.print("Input new Name - ");
                String newName = input.next();
                nameArray[index] = newName;
                System.out.println("\nContact has been updated successfully..");
                break;
            case 2:
                System.out.print("\033[9A");
                System.out.print("\033[0J");
                System.out.print(" Update Phone Number\n===========\n");
                String newPhoneNumber = "";
                boolean isInvalied = true;
                do {
                    System.out.print("Input new phone number - ");
                    newPhoneNumber = input.next();
                    isInvalied = getValidPhoneNumber(newPhoneNumber);
                    if (isInvalied) {
                        System.out.print("\n\t\tInvalid Phone Number...\n");
                        System.out.print("\nDo You Want To Add Phone Number Again (y/n) : ");
                        String text = input.next();
                        if (text.equalsIgnoreCase("y")) {
                            System.out.print("\033[5A");
                            System.out.print("\033[0J");
                        } else if (text.equalsIgnoreCase("N")) {
                            isInvalied = false;
                            clearConsole();
                            updateContacts();
                            break;
                        } else {
                            System.out.println("\nInvalid input. Please enter 'Y' or 'N'.\n");
                        }
                    }
                } while (isInvalied);
                phoneNumberArray[index] = newPhoneNumber;
                System.out.println("\nContact has been updated successfully..");
                break;
            case 3:
                System.out.print("\033[9A");
                System.out.print("\033[0J");
                System.out.print(" Update Company Name\n===========\n");
                System.out.print("Input new company name - ");
                String newCompanyName = input.next();
                companyNameArray[index] = newCompanyName;
                System.out.println("\nContact has been updated successfully..");
                break;
            case 4:
                System.out.print("\033[9A");
                System.out.print("\033[0J");
                System.out.print(" Update Salary\n===========\n");
                double newSalary = 0.0;
                boolean isInvalidSalary = true;
                do{
                    System.out.print("Input new salary - ");
                    newSalary = input.nextDouble();
                    isInvalidSalary = newSalary < 0.0 ? true : false;

                    if (isInvalidSalary){
                        System.out.print("\n\t\tInvalid Salary...\n");
                        System.out.print("\nDo You Want To Add Salary Again (y/n) : ");
                        String text = input.next();
                        if(text.equalsIgnoreCase("y")){
                            System.out.print("\033[5A");
                            System.out.print("\033[0J");
                        }else if (text.equalsIgnoreCase("N")) {
                            isInvalidSalary = false;
                            clearConsole();
                            updateContacts();
                            break;
                        } else {
                            System.out.println("\nInvalid input. Please enter 'Y' or 'N'.\n");
                        }
                    }
                } while (isInvalidSalary);
                salaryArray[index] = newSalary;
                System.out.println("\nContact has been updated successfully..");
                break;
            default:
                System.out.println("Invalid choice. Update canceled.");
                break;
        }
    }

    public static void deleteContact(){
        L1: do{
            clearConsole();
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                       DELETE Contact                                                                               |");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println();
            System.out.println();
            System.out.print("Search Contact by Name or Phone Number: ");
            String search = input.next();
            int index = searchPhoneNo(search);
            if (index != -1) {
                search(index);
            } else {
                index = SearchName(search);
                if (index != -1) {
                    search(index);
                }else {
                    continue L1;
                }
            }
            System.out.print("\nDo you want to delete this contact (Y/N): ");
            String option = input.next();
            if (option.equalsIgnoreCase("N")) {
                clearConsole();
                homePage();
                break L1;
            } else if (option.equalsIgnoreCase("Y")) {
                deleteIndex(index);
                System.out.print("\n\tCustomer has been deleted successfully..\n");
            }else {
                System.out.println("\nInvalid input. Please enter 'Y' or 'N'.\n");
            }
            System.out.print("\n\nDo you want to delete another Contact (y/n): ");
            String option2 = input.next();
            if (option2.equalsIgnoreCase("y")) {
                continue L1;
            } else if (option2.equalsIgnoreCase("N")) {
                clearConsole();
                homePage();
                break;
            } else {
                System.out.println("\nInvalid input. Please enter 'Y' or 'N'.\n");
            }
        } while (true);
    }

    private static void search(int index) {
        System.out.print("\n\n\tContact ID		: " + idArray[index]);
        System.out.print("\n\tName			: " + nameArray[index]);
        System.out.print("\n\tPhone Number		: " + phoneNumberArray[index]);
        System.out.print("\n\tCompany Name		: " + companyNameArray[index]);
        System.out.print("\n\tSalary			: " + salaryArray[index]);
        System.out.print("\n\tB'Day(YYYY-MM-DD)	: " + bdayArray[index]);
        System.out.println();
    }

    private static void deleteIndex(int index) {
        String[] tempidArray = new String[idArray.length-1];
        String[] tempnameArray = new String[nameArray.length-1];
        String[] temptelNoArray = new String[phoneNumberArray.length-1];
        String[] tempcompanyArray = new String[companyNameArray.length-1];
        double[] tempsalaryArray = new double[salaryArray.length-1];
        String[] tempdobArray = new String[bdayArray.length-1];
        for (int i = 0, j = 0; i < idArray.length; i++){
            if (i != index){
                tempidArray[j] = idArray[i];
                tempnameArray[j] = nameArray[i];
                temptelNoArray[j] = phoneNumberArray[i];
                tempcompanyArray[j] = companyNameArray[i];
                tempsalaryArray[j] = salaryArray[i];
                tempdobArray[j] = bdayArray[i];
                j++;
            }
        }
        idArray = tempidArray;
        nameArray = tempnameArray;
        phoneNumberArray = temptelNoArray;
        companyNameArray = tempcompanyArray;
        salaryArray = tempsalaryArray;
        bdayArray = tempdobArray;
    }

    public static void searchContact() {
        L1: do {
            clearConsole();
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                       SEARCH Contacts                                                                              |");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println();
            System.out.print("\nSearch Contact by Name or Phone Number : ");
            String search = input.next();
            int index = searchPhoneNo(search);
            if (index != -1) {
                search(index);
            } else {
                index = SearchName(search);
                if (index != -1) {
                    search(index);
                } else {
                    continue L1;
                }
            }
            System.out.println();
            System.out.print("Do you want to search another Contact (Y/N): ");
            String option = input.next();
            if (option.equalsIgnoreCase("N")) {
                clearConsole();
                homePage();
                break L1;
            } else if (option.equalsIgnoreCase("Y")) {
                continue L1;
            }else {
                System.out.println("\nInvalid input. Please enter 'Y' or 'N'.\n");
            }
        }while (true);
    }

    public static void listContact(){
        L1: do{
            clearConsole();
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                       SORT Contacts                                                                                |");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.print("\n\t[1] Sorting by Name \n\t[2] Sorting by Salary\n\t[3] Sorting by Birthday\n\n");
            System.out.print("Enter an option to continue -> ");
            int option = input.nextInt();
            switch(option){
                case 1:
                    clearConsole();
                    sortByName();
                    printTable();
                    break;
                case 2:
                    clearConsole();
                    sortBySalary();
                    printTable();
                    break;
                case 3:
                    clearConsole();
                    sortByBirthday();
                    printTable();
                    break;
                default:
                    break;
            }
            System.out.print("\n\nDo You Want To Go To Home Page (y/n) : ");
            String text = input.next();
            if(text.equalsIgnoreCase("y")){
                clearConsole();
                homePage();
                break;
            } else if (text.equalsIgnoreCase("N")) {
                continue L1;
            }else {
                System.out.println("\nInvalid input. Please enter 'Y' or 'N'.\n");
            }
        } while (true);
    }

    public static void sortByName(){
        System.out.println("\t\t\t+-----------------------------------------------------------------------------------------------------------------------+");
        System.out.println("\t\t\t|                                                   LIST Contact by Name                                                |");
        System.out.println("\t\t\t+-----------------------------------------------------------------------------------------------------------------------+");
        System.out.println();
        System.out.println();
        for (int i = 0; i < idArray.length-1; i++){
            for (int j = i+1; j < idArray.length; j++){
                if (nameArray[i].compareTo(nameArray[j]) > 0){
                    sort(i,j);
                }
            }
        }
    }

    public static void sort(int i, int j){
        String idTemp = idArray[i];
        idArray[i] = idArray[j];
        idArray[j] = idTemp;

        String nameTemp = nameArray[i];
        nameArray[i] = nameArray[j];
        nameArray[j] = nameTemp;

        String telTemp = phoneNumberArray[i];
        phoneNumberArray[i] = phoneNumberArray[j];
        phoneNumberArray[j] = telTemp;

        String companyTemp = companyNameArray[i];
        companyNameArray[i] = companyNameArray[j];
        companyNameArray[j] = companyTemp;

        double salaryTemp = salaryArray[i];
        salaryArray[i] = salaryArray[j];
        salaryArray[j] = salaryTemp;

        String dobTemp = bdayArray[i];
        bdayArray[i] = bdayArray[j];
        bdayArray[j] = dobTemp;
    }

    public static void printTable(){
        System.out.println("+--------------------------+--------------------------+--------------------------+--------------------------+--------------------------+-----------------------------+");
        System.out.println("|        Contact ID        |           Name           |        Phone Number      |          Company         |          Salary          |           Birthday          |");
        System.out.println("+--------------------------+--------------------------+--------------------------+--------------------------+--------------------------+-----------------------------+");
        for(int i = 0 ; i < idArray.length ; i++){
            System.out.printf("|%-26s|%-26s|%26s|%26s|%26.2f|%29s|\n",idArray[i],nameArray[i],phoneNumberArray[i],companyNameArray[i],salaryArray[i],bdayArray[i]);
        }
        System.out.println("+--------------------------+--------------------------+--------------------------+--------------------------+--------------------------+-----------------------------+");
    }

    public static void sortBySalary(){
        System.out.println("\t\t\t+-----------------------------------------------------------------------------------------------------------------------+");
        System.out.println("\t\t\t|                                                   LIST Contact by Salary                                              |");
        System.out.println("\t\t\t+-----------------------------------------------------------------------------------------------------------------------+");
        System.out.println();
        System.out.println();
        System.out.println("\b "+"\b\b "+"\b\b \n\n");
        for (int i = 0; i < idArray.length-1; i++){
            for (int j = i+1; j < idArray.length; j++){
                if (salaryArray[i] > salaryArray[j]){
                    sort(i,j);
                }
            }
        }
    }

    public static void sortByBirthday(){
        System.out.println("\t\t\t+-----------------------------------------------------------------------------------------------------------------------+");
        System.out.println("\t\t\t|                                                   LIST Contact by Birthday                                            |");
        System.out.println("\t\t\t+-----------------------------------------------------------------------------------------------------------------------+");
        System.out.println();
        System.out.println();
        for (int i = 0; i < idArray.length-1; i++){
            for (int j = i+1; j < idArray.length; j++){
                if (bdayArray[i].compareTo(bdayArray[j]) > 0){
                    sort(i,j);
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        homePage();
        do {
            int option = input.nextInt();
            switch (option) {
                case 1:
                    clearConsole();
                    addContact();
                    break;
                case 2:
                    clearConsole();
                    updateContacts();
                    break;
                case 3:
                    clearConsole();
                    deleteContact();
                    break;
                case 4:
                    clearConsole();
                    searchContact();
                    break;
                case 5:
                    clearConsole();
                    listContact();
                    break;
                case 6:
                    clearConsole();
                    System.out.println("|----------------------------------------------------------------------THANK YOU-------------------------------------------------------------------------------------|");
                    System.exit(6);
                    break;
                default:
                    clearConsole();
                    homePage();
            }
        } while (true);
    }
    
}

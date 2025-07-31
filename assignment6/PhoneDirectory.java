import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneDirectory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Shyam","5698521");
        phoneBook.put("Balaram","9856321");
        phoneBook.put("Sai","8976431");
        phoneBook.put("Santosh","6578521");
        phoneBook.put("manoj","5698521");
        phoneBook.containsKey("Shyam");
        phoneBook.remove("Santosh");
        System.out.println("Remaining contacts are : "+phoneBook);
        // while (true) {
        //     System.out.println("1. Add Contact");
        //     System.out.println("2. Search Contact");
        //     System.out.println("3. Remove Contact");
        //     System.out.println("4. Display All Contacts");
        //     System.out.println("5. Exit");
        //     System.out.print("Choose an option: ");
        //     int choice = scanner.nextInt();
        //     scanner.nextLine();
        //     switch (choice) {
        //         case 1:
        //             System.out.print("Enter name: ");
        //             String nameToAdd = scanner.nextLine();
        //             System.out.print("Enter phone number: ");
        //             String phoneToAdd = scanner.nextLine();
        //             phoneBook.put(nameToAdd, phoneToAdd);
        //             System.out.println("Contact added.");
        //             break;

        //         case 2:
        //             System.out.print("Enter name to search: ");
        //             String nameToSearch = scanner.nextLine();
        //             if (phoneBook.containsKey(nameToSearch)) {
        //                 System.out.println("Phone Number: " + phoneBook.get(nameToSearch));
        //             } else {
        //                 System.out.println("Contact not found.");
        //             }
        //             break;

        //         case 3:
        //             System.out.print("Enter name to remove: ");
        //             String nameToRemove = scanner.nextLine();
        //             if (phoneBook.remove(nameToRemove) != null) {
        //                 System.out.println("Contact removed.");
        //             } else {
        //                 System.out.println("Contact not found.");
        //             }
        //             break;

        //         case 4:
        //             System.out.println("All Contacts:");
        //             for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
        //                 System.out.println(entry.getKey() + ": " + entry.getValue());
        //             }
        //             break;

        //         case 5:
        //             System.out.println("Exiting...");
        //             scanner.close();
        //             return;

        //         default:
        //             System.out.println("Invalid option. Try again.");
        //     }
        // }
    }
}
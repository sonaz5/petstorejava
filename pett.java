package nazansonal_211805027;
import java.util.Scanner;

class petrecord {
    int petId;
    String petName;
    String petType;
    int birthYear;
    double weight;
    petrecord next;

    public petrecord(int petId, String petName, String petType, int birthYear, double weight) {
        this.petId = petId;
        this.petName = petName;
        this.petType = petType;
        this.birthYear = birthYear;
        this.weight = weight;
        this.next = null;
    }
}

class VetRecord {
    private petrecord head;

    public VetRecord () {
        head = null;
    } 
    public void addPetRec(int petId, String petName, String petType, int birthYear, double weight) {
        petrecord newRecord = new petrecord(petId, petName, petType, birthYear, weight);

        if (head == null || petId < head.petId) {
            newRecord.next = head;
            head = newRecord;
  }
        else {
            petrecord current = head;
            while (current.next != null && current.next.petId <= petId) {
                current = current.next;
            }
            newRecord.next = current.next;
            current.next = newRecord;
        }
    }  
    public void removePetRecord(int petId) {
        if (head == null) {
            System.out.println("No pet records to remove.");
            return;
        }

        if (head.petId == petId) {
        	System.out.println("Pet record succesfully removed.");
            head = head.next;
            return;
 }
        petrecord current = head;
        while (current.next != null && current.next.petId != petId) {
            current = current.next;
      }
if (current.next != null) {
            current.next = current.next.next;
        } 
else { System.out.println("Pet with petId " + petId + " is not found.");
        }
    }
    public void printPetRecords() {
        if (head == null) {
            System.out.println("No pet records to display.");
        } else {
            petrecord current = head;
            while (current != null) {
                System.out.println("PetId: " + current.petId);
                System.out.println("PetName: " + current.petName);
                System.out.println("PetType: " + current.petType);
                System.out.println("BirthYear: " + current.birthYear);
                System.out.println("Weight: " + current.weight);
                System.out.println();
                current = current.next;
            }
        }
            }
    }
 public class pett {

    public static void main(String[] args) {
        VetRecord vetRecords = new VetRecord();
       
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Main Menu:");
                System.out.println("1. Add a new pet record");
                System.out.println("2. Remove a pet");
                System.out.println("3. Print all pet records");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter pet ID: ");
                        int petId = scanner.nextInt();
                        System.out.print("Enter pet name: ");
                        String petName = scanner.next();
                        System.out.print("Enter pet type: ");
                        String petType = scanner.next();
                        System.out.print("Enter birth year: ");
                        int birthYear = scanner.nextInt();
                        System.out.print("Enter weight: ");
                        double weight = scanner.nextDouble();

                        vetRecords.addPetRec(petId, petName, petType, birthYear, weight);
                        break;
                    case 2:
                        System.out.print("Enter pet ID to remove: ");
                        int idRemove = scanner.nextInt();
                        vetRecords.removePetRecord(idRemove);
                        break;
                    case 3:
                       vetRecords.printPetRecords();
                        break;
                    case 4:
                        System.out.println("Exiting the program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            }
}

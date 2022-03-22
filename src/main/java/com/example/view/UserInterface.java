package com.example.view;
import com.example.controller.Mediator;

public class UserInterface extends ControlledUI{

    public UserInterface(Mediator mediator) {
        super(mediator);
    }

    public void start() {
        System.out.println("  --- Welcome ---");
        System.out.println("Please choose an option.\n");
        mainMenu();
    }

    public void mainMenu(){
        while (true) {
            System.out.println("1- Add new product");
            System.out.println("2- Show all products");
            System.out.println("3- Select product");
            System.out.println("4- Generate report");
            System.out.println("5- E-Mail report");
            System.out.println("0- Exit");
            int option = CheckValid.validInt();
            if(option >= 0 && option <= 5) {
                mediator.notify("showMenu", String.valueOf(option));
                break;
            }
            System.out.println("Please choose a valid option");
        }
    }

    public void selectProduct() {
        while (true) {
            System.out.println("1- Change product stock");
            System.out.println("2- Update product data");
            System.out.println("3- Remove product from inventory");
            System.out.println("0- return to main menu");
            int option = CheckValid.validInt();
            if(option >= 0 && option <= 3) {
                mediator.notify("selectProduct", String.valueOf(option));
                break;
            }
            System.out.println("Please choose a valid option");
        }
    }

    public String generateReport() {
        System.out.println("Write file name: ");
        return CheckValid.validString() + ".pdf";
    }

    public String generateEmail() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Username: ");
        stringBuilder.append(CheckValid.validString());
        System.out.println("Password: ");
        stringBuilder.append(CheckValid.validString());
        stringBuilder.append(" ");
        return stringBuilder.toString();
    }

    public boolean confirm() {
        System.out.println("Are you sure? y/n");
        return CheckValid.validBoolean();
    }

    public int enterQuantity() {
        System.out.println("Enter quantity: ");
        return CheckValid.validInt();
    }

    public int validateIdUI() {
        System.out.println("Enter product id \n0 to cancel");
        int productID = CheckValid.validInt();
        return productID;
    }

    public void validateIdUINeg(int id) {
        System.out.println(id + " is not a valid id");
    }

    public void successful() {
        System.out.println("Operation successful");
    }
}

import java.util.Scanner;

class Account {
    private double bal;
    Account(double bal){
        this.bal=bal;
    }
    
    public void withdraw(double m){
        if (bal>=m){
            this.bal=bal-m;
        System.out.println(m + "Amount debited Succesfully");
        System.out.println(bal + "Is your total balance");
        }
        else{
            System.out.println("No reuired amount in account");
        }
        
    }


    public void deposit(double m){
        this.bal=bal+m;
        System.out.println(m + "Amount credited Succesfully");
        System.out.println(bal + "Is your total balance");
    }

}
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Account acc=new Account(0);
        int choice;
        while (true){
            System.out.println("Enter 1 to deposit");
            System.out.println("Enter 2 to withdraw");
            System.out.println("Enter 3 to exit");
            choice=sc.nextInt();
            if (choice >=1 && choice<=3){
                switch (choice) {
                    case 1:
                        System.out.println("Enter amount to credit");
                        double m=sc.nextDouble();
                        acc.deposit(m);
                        
                        
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw");
                        double x=sc.nextDouble();
                        acc.withdraw(x);
                        
                        
                        break;
                    case 3:
                        System.out.println("Exiting");
                        return ;
                        
                
                    default:
                    System.out.println("choose your operation");
                        
                }
            }
            else{
                System.out.println("Enter correct number for transaction");
            }
            
        }

    }
    
}

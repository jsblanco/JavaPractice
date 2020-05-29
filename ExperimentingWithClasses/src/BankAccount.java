
public class BankAccount {
    private double funds =0;
    private long accountNumber;
    private String customerName;
    private String customerEmail;
    private int customerPhoneNum;

    public void setFunds(double funds){
        this.funds +=funds;
    }
    public void setData(String name, String email, int phoneNumber){
        this.accountNumber= (long)(Math.random()*1000000000000l);
        this.customerName = name;
        this.customerEmail= email;
        this.customerPhoneNum = phoneNumber;
    }

    public void getData(){
        System.out.println("Account #"+this.accountNumber+":");
        System.out.println("##############################################");
        System.out.println("Account funds: "+this.funds);
        System.out.println("Account owner: "+this.customerName);
        System.out.println("Account eMail: "+this.customerEmail);
        System.out.println("Account phone number: "+this.customerPhoneNum);
    }

    public double modifyFunds(double funds){
        if ((this.funds+funds)<0) {
            System.out.println("Insuficient funds to proceed with operation. Current balance: "+this.funds);
            return this.funds;
        };
        this.funds +=funds;
        System.out.println("Current balance: "+this.funds);
        return this.funds;
    }
}


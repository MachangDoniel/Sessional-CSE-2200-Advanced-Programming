package sample;

public class Janata extends Bank {

    Janata(){
        interest=2.0;
    }
    @Override
    double setnewBalance(String typeofAcc, double balance) {
        if(typeofAcc.equals("Savings")){
            balance=balance+(1*balance)/100;
        }
        else{
            balance+=(interest*balance*1.0)/100;
        }
        return balance;
    }
}

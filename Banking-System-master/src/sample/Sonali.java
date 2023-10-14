package sample;

public class Sonali extends Bank {
    Sonali(){
        interest=2.5;
    }
    @Override
    double setnewBalance(String typeofAcc,double balance) {
        if(typeofAcc.equals("Savings")){
            balance=balance+(1*balance)/100;
        }
        else{
            balance+=(interest*balance*1.0)/100;
        }
        return balance;
    }
}

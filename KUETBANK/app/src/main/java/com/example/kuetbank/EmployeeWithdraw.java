package com.example.kuetbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EmployeeWithdraw extends AppCompatActivity {

    DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Customer"),central=FirebaseDatabase.getInstance().getReference("Manager");
    EditText amount;
    Button withdraw;
    String ACC;
    Double Amount;
    long max=2147483647;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_withdraw);

        ACC=getIntent().getStringExtra("accountno");
        amount=findViewById(R.id.amount);
        withdraw=findViewById(R.id.withdraw);
        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String AM=amount.getText().toString().trim();
                if(AM.isEmpty()){
                    amount.setError("Enter Amount");
                    amount.requestFocus();
                    return;
                }
                Amount=Double.valueOf(amount.getText().toString().trim());
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(ACC)) {
                            Double balance = Double.valueOf(snapshot.child(ACC).child("balance").getValue().toString());
                            if(balance<Amount){
                                amount.setError("Balance Shortage");
                                amount.requestFocus();
                                return;
                            }
                            else{
                                balance -= Amount;
                                ref.child(ACC).child("balance").setValue(String.valueOf(balance));
                                central.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        Double balance = Double.valueOf(snapshot.child("YqzFWzyBiQRlRIC6AM3REGZh9Rh2").child("balance").getValue().toString());
                                        balance += Amount;
                                        central.child("YqzFWzyBiQRlRIC6AM3REGZh9Rh2").child("balance").setValue(String.valueOf(balance));
                                        enterhistory(String.valueOf(Amount));
                                        Toast.makeText(EmployeeWithdraw.this, "Money Withdrawed Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(EmployeeWithdraw.this,EmployeeOptionForCustomer.class);
                                        intent.putExtra("accountno",ACC);
                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                        }
                        else{
                            Toast.makeText(EmployeeWithdraw.this, "Error", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
    private void enterhistory(String amount) {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Transaction");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long maxid=snapshot.child(ACC).getChildrenCount();
                reference.child(ACC).child(String.valueOf(max-maxid)).setValue("Withdrawed "+amount+"৳ by agent");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void onBackPressed(){
        Intent intent=new Intent(EmployeeWithdraw.this,EmployeeOptionForCustomer.class);
        intent.putExtra("accountno",ACC);
        startActivity(intent);
    }
}
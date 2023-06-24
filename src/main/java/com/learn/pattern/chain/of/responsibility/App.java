package com.learn.pattern.chain.of.responsibility;

import com.learn.pattern.chain.of.responsibility.intf.PurchasePower;
import com.learn.pattern.chain.of.responsibility.model.CEOPurchasePower;
import com.learn.pattern.chain.of.responsibility.model.DirectorPurchasePower;
import com.learn.pattern.chain.of.responsibility.model.ManagerPurchasePower;
import com.learn.pattern.chain.of.responsibility.model.PurchaseRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {
        PurchasePower ceo = new CEOPurchasePower(null);
        PurchasePower director = new DirectorPurchasePower(ceo);
        PurchasePower manager = new ManagerPurchasePower(director);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Enter the purpose of purchase");
                System.out.print(">>");
                String purpose = br.readLine();
                System.out.println("Enter the amount of purchase");
                String amount = br.readLine();

                PurchaseRequest request = new PurchaseRequest(Double.parseDouble(amount), purpose);

                manager.purchase(request);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

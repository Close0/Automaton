package com.gamevox;

import com.gamevox.Account.AccountManager;

public class Main {
    public static void Main(String[] args) {
        //Generate the accounts to be used by the bot
        AccountManager.generateAccounts();

        try {
            //Testing ... Claim myself an account and list it out
            System.out.println(AccountManager.getRandomAccount().toString());
        }catch (Exception e) {
            System.out.println("Caught an Exception in Main: "+e.getMessage());
        }
    }
}

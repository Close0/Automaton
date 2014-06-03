package com.gamevox;

import com.gamevox.Account.AccountManager;

public class Main {
    public static void main(String[] args) {
        try {
            //Testing ... Claim myself an account and list it out
            //Generate the accounts to be used by the bot
            AccountManager.generateAccounts();
            System.out.println(AccountManager.getRandomAccount().toString());
        }catch (Exception e) {
            System.out.println("Caught an Exception in Main: "+e.getMessage());
        }
    }
}

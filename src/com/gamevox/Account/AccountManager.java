package com.gamevox.Account;

import com.gamevox.Exceptions.AccountException;
import java.util.ArrayList;
import java.util.Random;

public class AccountManager {
    private static ArrayList<Account> accountPool = new ArrayList<Account>(); //Pool of our available accounts
    private static ArrayList<Account> accountsUsed = new ArrayList<Account>(); //The currently being used Account objects

    private static Random randomGenerator = new Random();

    /**
     * Add an account to the account pool so the bot can use the account.
     * @param account The account object to be added.
     * @throws AccountException
     */
    public static void addAccount(Account account) throws AccountException {
        if(accountPool.contains(account)) {
            throw new AccountException("We tried to add an account Object that already existed.");
        }
        accountPool.add(account);
    }

    /**
     * Generate the accounts to be used by the bot.
     * @throws AccountException
     */
    public static void generateAccounts() throws AccountException {
        for(int i = 1; i <= 200; i++)
            AccountManager.addAccount(new Account("Username" + i, "cats", "0.11.1337"));
    }
    /**
     * Generate the accounts to be used by the bot -- by a specific number.
     * @param numberOfAccounts The number of accounts to be created
     * @throws AccountException
     */
    public static void generateAccounts(Integer numberOfAccounts) throws AccountException {
        for(int i = 1; numberOfAccounts <= 200; i++)
            AccountManager.addAccount(new Account("Username" + i, "cats", "0.11.1337"));
    }

    /**
     * You will receive a random Account object from the available account pool
     * @return  Account
     * @throws AccountException
     */
    public static Account getRandomAccount() throws AccountException {
        if(accountPool.size() > 0) {
            int randomInt = randomGenerator.nextInt(accountPool.size());
            //Stick it in the Array of used accounts
            accountsUsed.add(accountPool.get(randomInt));
            //Return the Account to be used
            return accountPool.remove(randomInt);
        } else {
            throw new AccountException("We have no more accounts available CAP-I-TAN!");
        }
    }

    /**
     * Takes in an Account object and it removes it form the used Account array
     * for the ability for the account to be used again.
     * @param account The account to be freed for reuse
     * @throws AccountException
     */
    public static void releaseAccount(Account account) throws AccountException {
        if(!accountsUsed.contains(account)) {
            throw new AccountException("The account we were attempting to remove is not available for removal.");
        } else if(accountPool.contains(account)) {
            throw new AccountException("The account we were attempting to add back into the pool already exists.");
        }
        accountsUsed.remove(account);
        accountPool.add(account);
    }
}

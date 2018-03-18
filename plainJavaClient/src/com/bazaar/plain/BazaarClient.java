package com.bazaar.plain;

import com.bazaar.accounts.AccountManagerRemote;
import com.bazaar.domain.User;

import javax.naming.*;
import java.util.Collection;

public class BazaarClient {
    public static void main(String[] args) throws NamingException {
        System.out.println("Hello from plain java");

        AccountManagerRemote accountManagerRemote;

        /*
        InitialContext ctx2 = new InitialContext();
        NamingEnumeration<NameClassPair> list = ctx2.list("");
        while (list.hasMore()) {
            System.out.println(list.next().getName());
        }
        */


        try{
            Context ctx = new InitialContext();
            accountManagerRemote = (AccountManagerRemote)
                    ctx.lookup("java:global/examPrep_ear/EJB/AccountManagerEJB");
        } catch (NamingException e) {
            System.out.println("Naming Exception");
            return;
        }


        User user = new User("Dennis", "Bergkamp2", "dbkamp", "xyz");
        ///accountManagerRemote.createUser(user);
        Long id = accountManagerRemote.createUser(user);
        System.out.println("New User id = " + id + "; Name: " + user.getFirstName() + " " + user.getLastName());

        user = accountManagerRemote.findUser(1);
        System.out.println("User name: " + user.getFirstName() + " "
                + user.getLastName() + " username: " + user.getUsername());

        Collection<User> allusers = accountManagerRemote.getUsers();
        System.out.printf("Collection size: " + allusers.size());

        //allusers.forEach();



    }
}

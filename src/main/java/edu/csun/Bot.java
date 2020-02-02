package edu.csun;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.*;
public class Bot {
    // Main function, program entry point.
    public static void main(String[] args) {
        // Checks if there were any parameters passed in.
        if(args.length == 0) {
            // We need at least one -- our token!
            System.out.println("Please provide a token!");
            return;
        }
        String token = args[0]; // 0 based indexing.
        try {
            JDA jda = new JDABuilder(AccountType.BOT) // New bot builder.
                    .setToken(token).build();// Set the token.
                    jda.addEventListener(new Handler()); // Registers the event listener.
                   //.buildBlocking(); // Block the current thread until JDA is 100% ready.
            // Not required, but useful to demonstrate that everything worked.
            System.out.println("Logged in as " + jda.getSelfUser().getName() + "#" + jda.getSelfUser().getDiscriminator() + "!");
        } catch(LoginException  exception) {
            // Print the error.
            exception.printStackTrace();
        }
    }
}

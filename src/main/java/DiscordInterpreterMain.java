//Jda utilities packages used for creating and handling bot commands from user input.

import net.dv8tion.jda.api.*;
        import net.dv8tion.jda.api.events.ReadyEvent;
        import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import static constants.Constants.TOKEN;

public class DiscordInterpreterMain extends ListenerAdapter {

    public static JDA api;
    public static String prefix = "!!";

    @Override
    public void onReady(ReadyEvent event)
    {
        System.out.println("I am ready to go!");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        System.out.printf("[%s]: %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay());
    }


    public static void main(String[] arguments) throws Exception
    {
        //Builds the client to handle commands passed in by the user.
        //CommandClientBuilder commandClientBuilder = new CommandClientBuilder();

        //Sets what our special key prefix is that tells the bot to pay attention to users text.
        //The key is !!
        //commandClientBuilder.setPrefix("!!");

        //Type !!help to get the default help prompt from the bot.
        //commandClientBuilder.useDefaultGame();

        //This adds a command the user can type in for the bot.
        //Instantiates a new object
        //commandClientBuilder.addCommand(new WakeUp());

        //api = new JDABuilder(TOKEN).build();
        //api.addEventListener(new Greeting());

        api = new JDABuilder(AccountType.BOT).setToken(TOKEN).build();

        api.addEventListener(new Listen());

    }


}

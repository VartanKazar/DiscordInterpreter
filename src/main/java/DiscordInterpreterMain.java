
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static constants.Constants.TOKEN;

public class DiscordInterpreterMain extends ListenerAdapter {
    public static void main(String[] arguments) throws Exception
    {
        JDA api = new JDABuilder(TOKEN).build();
        api.addEventListener(new Greeting());


    }

}

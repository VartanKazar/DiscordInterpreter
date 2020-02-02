
import messages.Greeting;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.Utils;


public class DiscordInterpreterMain extends ListenerAdapter {
    public static void main(String[] arguments) throws Exception
    {
        JDA api = new JDABuilder(AccountType.BOT).setToken(Utils.getToken()).build();
        api.addEventListener(new Greeting());
    }

}

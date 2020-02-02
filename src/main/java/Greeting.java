import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Greeting extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();

        if(messageSent.equalsIgnoreCase("hello")) {
            event.getChannel().sendMessage("Hi welcome!").queue();

        }
    }
}

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;

import java.util.List;

public class DiscordInterpreterMain {
    public static void main(String[] arguments) throws Exception
    {
        /*
        Setting up the JDA builder to accept a discord bot token.


         */
        JDA api = new JDABuilder("NjczMzMxNTYzMjE5NTE3NDQw.XjYfAg.sYo2Cwho85ie1VBbxGJGksc_x3M").build();

        List<VoiceChannel> channels = api.getVoiceChannels();


        VoiceChannel voiceChannel = channels.get(0);

        System.out.print(voiceChannel.getName());




        //System.out.print(channels);
    }

}

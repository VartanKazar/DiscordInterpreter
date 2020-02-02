import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.entities.User;

import static constants.Constants.TOKEN;

public class DiscordInterpreterMain extends ListenerAdapter {
    public static void main(String[] arguments) throws Exception
    {
        JDA api = new JDABuilder(TOKEN).build();
        api.addEventListener(new Greeting());

    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        summon(event, event.getGuild().getVoiceChannelsByName("General", true).get(0));
    }

    private void summon(GuildMessageReceivedEvent event, VoiceChannel channel) {
        // Reference the audio manager
//        AudioManager manager = channel.


        AudioManager manager = channel.getGuild().getAudioManager();

        // This is required
        manager.setSendingHandler(new SilenceAudioSendHandler());

        // Setup the SpeechReceiver, you can initialize a wakeup phrase here, and the speech callback
        SpeechReceiver speechReceiver = new SpeechReceiver("okay bought", new SpeechCallback() {
            // This method is called when a voice command is processed, here it just sends the text back to the text channel
            @Override
            public void commandReceived(String command) {
                if(!command.equals("")) event.getChannel().sendMessage("You said: "+command+". Is that right?").queue();
            }

            /*
             * This is an important method, when a wakeup phrase is detected, this method will be called. The bot will only
             * start listening for a voice command if this returns true. This method returns a user variable parameter, which will contain a minimum of 0
             * to an x amount of users involved in the voice command. Here you can define certain roles or restrictions to who can
             * activate the bot.
             */
            @Override
            public boolean botAwakeRequest(User... user) {
                // If the bot is successfully activated, you might want to play a sound using JDA, send a message, or use TTS to
                // let the user know that the bot was successfully activated
                System.out.println("Bot awakened!");
                return true;
            }
        });

        // This must be true for now, it will be fixed when Discord fixes an audio issue
        speechReceiver.setCombinedAudio(true);
        // Set the speech handler
        manager.setReceivingHandler(SpeechReceiver);

        // Open the connection to the VoiceChannel
        manager.openAudioConnection(channel);
    }
}

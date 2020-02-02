package messages;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class Greeting extends ListenerAdapter {

    //Makes the bot move in to the voice chat that the user is currently in.
    //This is a helper function to help prepare the bot to listen in on the conversation and covert it.
    //Next step is to create a text channel to store all the dialogue data.
    private void joinVCChannel(GuildMessageReceivedEvent event){

        String message = event.getMessage().getContentRaw();
        VoiceChannel connectedChannel = event.getMember().getVoiceState().getChannel();
        TextChannel channel = event.getChannel();

        //Checks if user is currently connected to a voice channel, if not print error message.
        if(connectedChannel == null) {
            channel.sendMessage("You are not connected to a voice channel!").queue();
            return;
        }

        // Gets the audio manager, used for switching to voice channels.
        AudioManager audioManager = event.getGuild().getAudioManager();

        if(message.equals("!join")) {
            // Checks if the bot has permissions.
            if(!event.getGuild().getSelfMember().hasPermission(channel, Permission.VOICE_CONNECT)) {
                // The bot does not have permission to join any voice channel. Don't forget the .queue()!
                channel.sendMessage("I do not have permissions to join a voice channel!").queue();

                return;
            }

            // When somebody really needs to chill.
            if(audioManager.isAttemptingToConnect()) {
                channel.sendMessage("The bot is already trying to connect! Enter the chill zone!").queue();

                System.out.print("6.");
                return;
            }

            // Connects to the channel.
            audioManager.openAudioConnection(connectedChannel);
            // Obviously people do not notice someone/something connecting.
            channel.sendMessage("Connected to the voice channel!").queue();

            //createTextChannel(event);

        } else if(message.equals("!leave")) { // Checks if the command is !leave.

            // Disconnect from the channel.
            event.getGuild().getAudioManager().closeAudioConnection();
            // Notify the user.
            channel.sendMessage("Disconnected from the voice channel!").queue();
        }
    }



    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String message = event.getMessage().getContentRaw();
        TextChannel channel = event.getChannel();

        // typed text is = "!Listen" then respond back with confirmation message.
        if (message.equalsIgnoreCase("!join")) {
            channel.sendMessage("Ok, I'm listening!").queue();

            joinVCChannel(event);
//            createTextChannel(event);
        }
    }

    //Placeholder helper function to create a text channel and prepare it to store the dialgue text data translated from the voice chat.
    private void createTextChannel(GuildMessageReceivedEvent event){

        //event.getGuild().createTextChannel()
        Guild guild = event.getGuild();

        //Get name of the voice channel the user is currently in.
        //Create new temporary logging text channel with vc name + "-interp"
        VoiceChannel connectedChannel = event.getMember().getVoiceState().getChannel();
        String channelName = connectedChannel.getName();

        guild.createTextChannel(channelName + "-interp");


    }
}

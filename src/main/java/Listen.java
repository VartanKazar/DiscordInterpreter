//This class is in charge of the Listen command.
//Tells the bot to start converting any voice chat coming in and log it.

//ADD IN VTT LIB INTO CORRECT CONDITIONAL TO LINK VOICE TRANSLATION FEATURES.

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Invite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;
import org.jetbrains.annotations.NotNull;

public class Listen extends ListenerAdapter {

    //Makes the bot move in to the voice chat that the user is currently in.
    //This is a helper function to help prepare the bot to listen in on the conversation and covert it.
    //Next step is to create a text channel to store all the dialogue data.
    private void joinVCChannel(GuildMessageReceivedEvent event){
        VoiceChannel connectedChannel = event.getMember().getVoiceState().getChannel();
        TextChannel channel = event.getChannel();

        //Checks if user is currently connected to a voice channel, if not print error message.
        if(connectedChannel == null) {
            channel.sendMessage("You are not connected to a voice channel!").queue();
            return;
        }

        //Make sure the bot has permission to join the voice channel, some might be private and locked.
        if(!event.getGuild().getSelfMember().hasPermission(channel, Permission.VOICE_CONNECT)) {
            channel.sendMessage("I do not have permissions to join a voice channel!").queue();
            return;
        }

        // Gets the audio manager, used for switching to voice channels.
        AudioManager audioManager = event.getGuild().getAudioManager();

        // Makes sure two bots aren't attempting to connect at the same time.
        if(audioManager.isAttemptingToConnect()) {
            channel.sendMessage("The bot is already trying to connect to the channel!").queue();
            return;
        }

        // Connects to the channel.
        audioManager.openAudioConnection(connectedChannel);

        // Text notification to confirm the bot joined the channel.
        channel.sendMessage("Connected to the voice channel!").queue();

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

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("//s");

        //First element keeps the !! command type (ex.  !!Listen), additional arguments might specify who to listen to at a later date.
        if (args.length > 0) {

            //If typed text is = "!!Listen" then respond back with confirmation message.
            if (args[0].equalsIgnoreCase(DiscordInterpreterMain.prefix + "Listen")) {
                event.getChannel().sendMessage("Ok, I'm listening!").queue();

                joinVCChannel(event);
                createTextChannel(event);

                return;
            }

            else event.getChannel().sendMessage("I don't understand what you just asked.").queue();
        }

        //User typed in the prefix !! but no following command directly after.
        else event.getChannel().sendMessage("You didn't tell me to do anything!").queue();
    }
}

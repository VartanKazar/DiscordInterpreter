package messages;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

import java.util.Random;

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
            return;
        }

        // Gets the audio manager, used for switching to voice channels.
        AudioManager audioManager = event.getGuild().getAudioManager();

        if(message.equalsIgnoreCase("!join")) {
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
            channel.sendMessage("Ok, I'm listening!").queue();
            channel.sendMessage("Connected to the voice channel!").queue();

        } else if(message.equalsIgnoreCase("!leave")) { // Checks if the command is !leave.

            // Disconnect from the channel.
            event.getGuild().getAudioManager().closeAudioConnection();
            // Notify the user.
            channel.sendMessage("Disconnected from the voice channel!").queue();
        } else if(message.equalsIgnoreCase("!help")){
            //direct to github page
            channel.sendMessage("Type '!join'  to join the channel").queue();
            channel.sendMessage("Type '!leave!' to leave the channel").queue();
            channel.sendMessage("Type '!resources!' to get useful resources for deaf and hard of hearing").queue();
            channel.sendMessage("For more information go to https://github.com/DV8FromTheWorld/JDA#creating-the-jda-object%22").queue();


        } else if(message.equalsIgnoreCase("!resources")){
            Random random=new Random();
            int upper=5;
            int randomValue = random.nextInt(upper);
            if(randomValue==0)
                channel.sendMessage("To get wide range of information about Deaf & Hard of Hearing go to https://www.nad.org/resources/%22").queue();
            if(randomValue==1)
                channel.sendMessage("Lear about an app that provides transcription with Live Transcribe https://www.nad.org/resources/%22").queue();
            if(randomValue==2)
                channel.sendMessage("Find subtitled/captioned movies in your local cinema https://www.yourlocalcinema.com/%22").queue();
            if(randomValue==3)
                channel.sendMessage("Convert voice massages int text http://voxsci.com/%22").queue();
            if(randomValue==4)
                channel.sendMessage("Check out TopSos: Nonverbal methods of communication in case of emergency https://www.tech4goodawards.com/finalist/tapsos/%22").queue();
            if(randomValue==5)
                channel.sendMessage("Get alerts when recorded sound is recognized http://www.braci.co/#soultions%22").queue();

        }

    }


    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String message = event.getMessage().getContentRaw();
        TextChannel channel = event.getChannel();

        // typed text is = "!Listen" then respond back with confirmation message.
        joinVCChannel(event);
        createTextChannel(event);
        summon(event, event.getGuild().getVoiceChannelsByName("General", true).get(0));
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
    private void summon(GuildMessageReceivedEvent event, VoiceChannel channel) {
        // Reference the audio manager
//        AudioManager manager = channel.


        AudioManager manager = channel.getGuild().getAudioManager();

        // This is required
        manager.setSendingHandler(new SilenceAudioSendHandler());

        // Setup the messages.SpeechReceiver, you can initialize a wakeup phrase here, and the speech callback
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
        manager.setReceivingHandler(speechReceiver);

        // Open the connection to the VoiceChannel
        manager.openAudioConnection(channel);
    }
}

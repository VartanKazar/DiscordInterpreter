import net.dv8tion.jda.api.*;

public class DiscordInterpreterMain {
    public static void main(String[] arguments) throws Exception
    {
        JDA api = new JDABuilder("NjczMDc5NTQ1MjYzNTU0NTkx.XjYCCg.x30oKvLi2llPUhJSXbRrSXlJeDg").build();

        api.addEventListener(new Greeting());


    }

}

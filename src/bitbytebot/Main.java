package bitbytebot;

import listeners.BotListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
    public static void main(String[] args) throws Exception {
        JDABuilder.createDefault("YOUR_TOKEN")		//discord developers bot token
        		  .enableIntents(   GatewayIntent.GUILD_MEMBERS,
        				    		GatewayIntent.GUILD_PRESENCES,
        				    		GatewayIntent.GUILD_MESSAGES,
        				    		GatewayIntent.MESSAGE_CONTENT)
                  .addEventListeners(new BotListener())
                  .build();
    }
}


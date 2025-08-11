package bitbytebot;

import listeners.BotListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
    public static void main(String[] args) throws Exception {
        JDA jda = JDABuilder.createDefault("YOUR_TOKEN")		//discord developers bot token
        		  .enableIntents(   GatewayIntent.GUILD_MEMBERS,
        				    		GatewayIntent.GUILD_PRESENCES,
        				    		GatewayIntent.GUILD_MESSAGES,
        				    		GatewayIntent.MESSAGE_CONTENT)
                  .addEventListeners(new BotListener())
                  .build()
        		  .awaitReady();
        
        //testing
        
        String guildid = "1057987584938233866";		//enable developer mode on discord -> right click on your discord server -> "copy ID"
        Guild testGuild = jda.getGuildById(guildid);
        
        if (testGuild != null) {
            testGuild.updateCommands().addCommands(
            	    Commands.slash("help", "Replies with a list of commands"),
            	    Commands.slash("ping", "Replies with pong!"),
            	    Commands.slash("userinfo", "Displays information about you or a specified user")
            	        .addOption(OptionType.USER, "user", "The user to get information about", false),
            	    Commands.slash("clear", "Deletes a specified number of messages (admin only)")
            	        .addOption(OptionType.INTEGER, "amount", "Number of messages to delete", true),
            	    Commands.slash("avatar", "Shows your avatar or a specified user's avatar in high resolution")
            	        .addOption(OptionType.USER, "user", "The user to get the avatar of", false),
            	    Commands.slash("servericon", "Shows the server icon in high resolution (1024px)"),
            	    Commands.slash("remind", "Schedules a reminder and pings you when it’s due")
            	        .addOption(OptionType.INTEGER, "minutes", "How many seconds to wait before the reminder", true)
            	        .addOption(OptionType.STRING, "message", "The reminder message", true)
            ).queue();
            System.out.println("Commands saved");
        } else {
            System.out.println("Guild not found. Check your guildid");
        }
    }
}


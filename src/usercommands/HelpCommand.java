package usercommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import utils.Command;

public class HelpCommand implements Command {
	@Override
    public void handle(MessageReceivedEvent event) {
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("Command List");
		embed.addField("!Bhelp", "Displays a list of all available commands\n", false);
		embed.addField("!Bping", "Responds with 'pong'\n", false);
		embed.addField("!Buserinfo", "Shows information about the user\n", false);
		embed.addField("!Bclear <number_of_messages>", "Deletes a specified number of messages in a channel\n", false);
		embed.addField("!Bavatar <mention>", "Shows the avatar of yourself or a mentioned user in high resolution\n", false);
		
		event.getChannel().sendMessageEmbeds(embed.build()).queue();
}
}

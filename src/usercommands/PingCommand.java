package usercommands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import utils.Command;

public class PingCommand implements Command {
	
	@Override
	public void handle(SlashCommandInteractionEvent event) {
		event.reply("Pong!").queue();
	}
}

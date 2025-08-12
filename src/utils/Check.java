package utils;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Check {
	public static boolean GuildCheck(SlashCommandInteractionEvent event) {
		if(event.getGuild() == null) {
			event.reply("This command che be used ONLY in a server").setEphemeral(true).queue();
			return false;
		}
		return true;
	}
}

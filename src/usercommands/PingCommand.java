package usercommands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import utils.Command;

public class PingCommand implements Command {
	
	@Override
	public void handle(SlashCommandInteractionEvent event) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setDescription("🏓 **Pong!**");
		embed.setAuthor(event.getUser().getEffectiveName() + " want to play!", null, event.getUser().getEffectiveAvatarUrl());
		embed.setColor(new java.awt.Color(0x5865F2));
		embed.setTimestamp(java.time.Instant.now());
		event.replyEmbeds(embed.build()).queue();
	}
}

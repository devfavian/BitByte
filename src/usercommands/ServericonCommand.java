package usercommands;
import utils.Check;
import utils.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class ServericonCommand implements Command {
	@Override
	public void handle(SlashCommandInteractionEvent event) {
		
		if(!Check.GuildCheck(event)) return;
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("🖼️ Server Icon");
		embed.setColor(new java.awt.Color(0x5865F2));
		embed.setTimestamp(java.time.Instant.now());
		String servericon = event.getGuild().getIconUrl();
		
		
		if(servericon == null) {
			embed.setDescription("This server has no icon set.");
			event.replyEmbeds(embed.build()).setEphemeral(true).queue();
			return;
		}
		
		String iconQ = servericon + "?size=1024";
		
		embed.setImage(iconQ);
		embed.setFooter("ByteBot • Servericon");
		event.replyEmbeds(embed.build()).queue();
	}
}

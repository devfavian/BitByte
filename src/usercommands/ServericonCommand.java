package usercommands;
import utils.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class ServericonCommand implements Command {
	@Override
	public void handle(SlashCommandInteractionEvent event) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("Server Icon");
		String servericon = event.getGuild().getIconUrl();
		
		
		if(servericon == null) {
			embed.setDescription("This server has no icon set.");
			event.replyEmbeds(embed.build()).setEphemeral(true).queue();
			return;
		}
		
		String iconQ = servericon + "?size=1024";
		
		embed.setImage(iconQ);
		event.replyEmbeds(embed.build()).queue();
	}
}

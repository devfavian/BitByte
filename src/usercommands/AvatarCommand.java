package usercommands;
import utils.Command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class AvatarCommand implements Command {
	@Override
	public void handle(SlashCommandInteractionEvent event) {
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("User avatar");
		
		User target = event.getOption("user") != null
				? event.getOption("user").getAsUser()
				: event.getUser();
		
		
		String avatar = target.getEffectiveAvatarUrl() + "?size=1024";
		embed.setImage(avatar);
		event.replyEmbeds(embed.build()).queue();
		}
	}


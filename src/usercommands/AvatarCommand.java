package usercommands;
import utils.Command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class AvatarCommand implements Command {
	@Override
	public void handle(SlashCommandInteractionEvent event) {
		
		User target = event.getOption("user") != null
				? event.getOption("user").getAsUser()
				: event.getUser();
		
		Member membro = event.getOption("user") != null
				? event.getOption("user").getAsMember()
				: event.getMember();
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setColor(new java.awt.Color(0x5865F2));
		embed.setTimestamp(java.time.Instant.now());
		embed.setDescription("📷 " + membro.getAsMention());
		String avatar = target.getEffectiveAvatarUrl() + "?size=1024";
		embed.setImage(avatar);
		embed.setFooter("ByteBot • Avatar");
		event.replyEmbeds(embed.build()).queue();
		
		}
	}


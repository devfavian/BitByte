package usercommands;

import utils.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.time.OffsetDateTime;

public class UserinfoCommand implements Command {
	@Override
	public void handle(SlashCommandInteractionEvent event) {
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("User info");
		
		User target = event.getOption("user") != null
				? event.getOption("user").getAsUser()
				: event.getUser();
		
		Member member = event.getOption("user") != null
				? event.getOption("user").getAsMember()
				: event.getMember();
		
		String avatar = target.getEffectiveAvatarUrl();
		String name = target.getName();
		String nick = member.getNickname();
		OnlineStatus status = member.getOnlineStatus();
		OffsetDateTime TimeC = target.getTimeCreated();
		OffsetDateTime TimeJ = member.getTimeJoined();
		String ID = target.getId();
		
		embed.setThumbnail(avatar);
		embed.addField("Username", name + " (" + ID + ")", false);
		
		if (nick == null || nick.isEmpty()) {
			embed.addField("Nickname", "None", false);
		} else {
			embed.addField("Nickname", nick, false);
		}
	
		embed.addField("Status", status.toString(), false);
		embed.addField("When Created", TimeC.getDayOfMonth() + "-" + TimeC.getMonthValue() + "-" + TimeC.getYear(), false);
		embed.addField("When Joined", TimeJ.getDayOfMonth() + "-" + TimeJ.getMonthValue() + "-" + TimeJ.getYear(), false);
	
		event.replyEmbeds(embed.build()).queue();
	}
}

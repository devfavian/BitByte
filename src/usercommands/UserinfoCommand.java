package usercommands;

import utils.Check;
import utils.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UserinfoCommand implements Command {
	@Override
	public void handle(SlashCommandInteractionEvent event) {
		
		if(!Check.GuildCheck(event)) return;
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setColor(new java.awt.Color(0x5865F2));
		
		User target = event.getOption("user") != null
				? event.getOption("user").getAsUser()
				: event.getUser();
		
		Member member = event.getOption("user") != null
				? event.getOption("user").getAsMember()
				: event.getMember();
		
		embed.setAuthor("👤 " + member.getEffectiveName() + " info :");
		
		String avatar = target.getEffectiveAvatarUrl();
		String name = target.getName();
		String nick = member.getNickname();
		//OnlineStatus status = member.getOnlineStatus();  //I'm having issues
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ITALIAN);
		
		OffsetDateTime TimeC = target.getTimeCreated();
		OffsetDateTime TimeJ = member.getTimeJoined();
		
		long durationC = (((java.time.Instant.now().getEpochSecond() - TimeC.toEpochSecond())/60)/60)/24;
		long durationJ = (((java.time.Instant.now().getEpochSecond() - TimeJ.toEpochSecond())/60)/60)/24;
		
		String ID = target.getId();
		
		embed.setThumbnail(avatar);
		embed.addField("🪪 Username", name + " (" + ID + ")", false);
		
		if (nick == null || nick.isEmpty()) {
			embed.addField("🎨 Nickname", "None", false);
		} else {
			embed.addField("🎨 Nickname", nick, false);
		}
	
		//embed.addField("Status", status.toString(), false);
		embed.addField("📅 Created ", TimeC.format(formatter) + " (" + durationC + " giorni fa)", false);
		embed.addField("🏠 Joined", TimeJ.format(formatter) + " (" + durationJ + " giorni fa)", false);
		
		embed.setFooter("ByteBot • Userinfo");
		embed.setTimestamp(java.time.Instant.now());
		event.replyEmbeds(embed.build()).queue();
	}
}

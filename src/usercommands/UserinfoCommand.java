package usercommands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import utils.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import java.time.OffsetDateTime;

public class UserinfoCommand implements Command {
	@Override
	public void handle(MessageReceivedEvent event) {
		
    	String avatar = event.getMember().getEffectiveAvatarUrl();
    	String name = event.getAuthor().getName();
    	String nick = event.getMember().getNickname();
    	OnlineStatus status = event.getMember().getOnlineStatus();
    	OffsetDateTime TimeC = event.getMember().getTimeCreated();
    	OffsetDateTime TimeJ = event.getMember().getTimeJoined();
    	String ID = event.getAuthor().getId();
		
		//this is my first time using "EmbedBuilder"
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("User info");
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
		
		event.getChannel().sendMessageEmbeds(embed.build()).queue();
	}
}

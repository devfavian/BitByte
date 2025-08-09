package usercommands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import utils.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Member;

import java.time.OffsetDateTime;

public class UserinfoCommand implements Command {
	@Override
	public void handle(MessageReceivedEvent event) {
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("User info");
		
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		if(args.length == 1) {
			String avatar = event.getMember().getEffectiveAvatarUrl();
			String name = event.getMember().getUser().getName();
			String nick = event.getMember().getNickname();
			OnlineStatus status = event.getMember().getOnlineStatus();
			OffsetDateTime TimeC = event.getMember().getTimeCreated();
			OffsetDateTime TimeJ = event.getMember().getTimeJoined();
			String ID = event.getMember().getId();
		
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
			return;
		}
		
		if(args.length > 2) {
			embed.setDescription("The command syntax must be -> '!Buserinfo' or '!Buserinfo <mention>'");
			event.getChannel().sendMessageEmbeds(embed.build()).queue();
			return;
		}
		
		if(event.getMessage().getMentions().getMembers().isEmpty()) {
            embed.setDescription("Please mention a valid user.");
            event.getChannel().sendMessageEmbeds(embed.build()).queue();
            return;
		}
		
		Member membro = event.getMessage().getMentions().getMembers().get(0);
		
		String avatar = membro.getEffectiveAvatarUrl();
		String name = membro.getUser().getName();
		String nick = membro.getNickname();
		OnlineStatus status = membro.getOnlineStatus();
		OffsetDateTime TimeC = membro.getTimeCreated();
		OffsetDateTime TimeJ = membro.getTimeJoined();
		String ID = membro.getId();
		
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

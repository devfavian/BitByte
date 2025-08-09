package usercommands;
import utils.Command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class AvatarCommand implements Command {
	@Override
	public void handle(MessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split(" ");
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("User avatar");
		
		if(args.length == 1) {
			String avatar = event.getMember().getEffectiveAvatarUrl() + "?size=1024";
			embed.setImage(avatar);
			event.getChannel().sendMessageEmbeds(embed.build()).queue();
			return;
		}
		
		if(args.length > 2) {
			embed.setDescription("The command syntax must be -> '!Bavatar' or '!Bavatar <mention>'");
			event.getChannel().sendMessageEmbeds(embed.build()).queue();
			return;
		}
		
		if(event.getMessage().getMentions().getMembers().isEmpty()) {
            embed.setDescription("Please mention a valid user.");
            event.getChannel().sendMessageEmbeds(embed.build()).queue();
            return;
		}

		Member membro = event.getMessage().getMentions().getMembers().get(0);
		String avatar = membro.getEffectiveAvatarUrl() + "?size=1024";
		embed.setImage(avatar);
		event.getChannel().sendMessageEmbeds(embed.build()).queue();
		}
	}


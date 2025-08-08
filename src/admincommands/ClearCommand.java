package admincommands;
import utils.Command;

import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ClearCommand implements Command{
	@Override
	public void handle(MessageReceivedEvent event) {
		
		if(!event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("Error!");
			embed.setDescription("You don't have necessary permission!");
			event.getChannel().sendMessageEmbeds(embed.build()).queue();
			return;
		}
		else {
			String[] args = event.getMessage().getContentRaw().split(" ");
			
			if(args.length < 2 || args.length > 2) {
				EmbedBuilder embed = new EmbedBuilder();
				embed.setTitle("Error!");
				embed.setDescription("The command syntax must be -> '!Bclear <number_of_messages>'");
				event.getChannel().sendMessageEmbeds(embed.build()).queue();
				return;
			}
			
			int numMessages;
			
			try {
				numMessages = Integer.parseInt(args[1]);
			}catch (NumberFormatException e) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle("Error!");
                embed.setDescription("Value should be a number!");
                event.getChannel().sendMessageEmbeds(embed.build()).queue();
                return;
			}

			
			if(numMessages <= 0 || numMessages>100) {
				EmbedBuilder embed = new EmbedBuilder();
				embed.setTitle("Error!");
				embed.setDescription("This command can delete a number of messages between 1 and 100");
				event.getChannel().sendMessageEmbeds(embed.build()).queue();
				return;
			}
			
			TextChannel textChannel = (TextChannel) event.getChannel();
			EmbedBuilder embed = new EmbedBuilder();
	        
	        textChannel.getHistoryBefore(event.getMessageId(), numMessages).queue(messageHistory -> {
	            List<Message> messages = messageHistory.getRetrievedHistory();
	            textChannel.deleteMessages(messages).queue(
	                success -> {
	        			embed.setTitle("Deleting messages");
	        			embed.setDescription(numMessages + " messages deleted");
	                	event.getChannel().sendMessageEmbeds(embed.build()).queue();
	                },
	                failure ->{
	        			embed.setTitle("Error");
	        			embed.setDescription("0 messages " + "deleted");
	                	event.getChannel().sendMessageEmbeds(embed.build()).queue();
	                }
	            );
	        });

		}
    }
}

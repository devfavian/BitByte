package admincommands;
import utils.Command;

import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class ClearCommand implements Command{
	@Override
	public void handle(SlashCommandInteractionEvent event) {
		
		if(!event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("Error!");
			embed.setDescription("You don't have necessary permission!");
			event.replyEmbeds(embed.build()).setEphemeral(true).queue();
			return;
		}
		else {
			
			int numMessages = event.getOption("amount").getAsInt();
			
			if(numMessages <= 0 || numMessages>100) {
				EmbedBuilder embed = new EmbedBuilder();
				embed.setTitle("Error!");
				embed.setDescription("This command can delete a number of messages between **1** and **100**");
				event.replyEmbeds(embed.build()).setEphemeral(true).queue();
				return;
			}
			
		    event.deferReply(true).queue(); // acknowledge + ephemeral

		    event.getChannel().getHistory().retrievePast(numMessages)
		        .queue(messages -> {
		            ((TextChannel) event.getChannel()).deleteMessages(messages).queue(
		                success -> event.getHook().editOriginalEmbeds(new EmbedBuilder()
		                        .setTitle("✅ Messages Deleted")
		                        .setDescription(numMessages + " messages deleted successfully.")
		                        .setColor(java.awt.Color.GREEN)
		                        .build()).queue(),
		                failure -> event.getHook().editOriginalEmbeds(new EmbedBuilder()
		                        .setTitle("❌ Error")
		                        .setDescription("Failed to delete messages.")
		                        .setColor(java.awt.Color.RED)
		                        .build()).queue()
		            );
		        });
		}
    }
}

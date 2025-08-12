package usercommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import utils.Check;
import utils.Command;

public class HelpCommand implements Command {
	@Override
	public void handle(SlashCommandInteractionEvent event) {
		
		if(!Check.GuildCheck(event)) return;
		
		final String invite = "https://discord.com/oauth2/authorize?client_id=1403010360847630336&permissions=8&integration_type=0&scope=applications.commands+bot";
		final String github = "https://github.com/devfavian";
		final String discord = "https://discord.gg/QtUzEyZERv";
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setAuthor("ByteBot • Help", null, null);
		embed.setTitle("📖 Command List");
		embed.setDescription("Use `/command` with suggested options. Start typing to see autocomplete.");
		embed.setColor(new java.awt.Color(0x5865F2));
		embed.setTimestamp(java.time.Instant.now());
		embed.setFooter("ByteBot • Help");

		
		
		embed.addBlankField(false);
		
		//Utilities
		embed.addField("🧰 **Utilities**", "\u200B" , false);
		embed.addField("**/help**", "Displays a list of all available commands\n", true);
		embed.addField("**/ping**", "Responds with 'pong'\n", true);
		embed.addField("**/userinfo**", "Shows information about yourself or a mentioned user\n", true);
		embed.addField("**/avatar <mention>**", "Shows the avatar of yourself or a mentioned user in high resolution\n", true);
		embed.addField("**/servericon**", "Show the server icon", true);
		embed.addField("**/remind <seconds> <message>**", "Schedules a reminder and pings you when it’s due\n", true);
		embed.addBlankField(false);
		
		
		embed.addField("🛡️ **Moderation**", "\u200B", false);
		embed.addField("**/clear <number_of_messages>**", "Deletes a specified number of messages in a channel\n", true);
		embed.addBlankField(false);
		
		
		embed.addField("👋 **Welcome**", "\u200B", false);
		embed.addField("**welcome message**", "Sends a welcome message to new members\n", true);
		embed.addField("**auto-role**", "Automatically assigns one or multiple roles to new members\n", true);
		embed.addBlankField(false);
		
		event.replyEmbeds(embed.build()).addActionRow(
					Button.link(invite, "➕ Invite ByteBot"),
					Button.link(github, "📦 GitHub"),
					Button.link(discord, "🕹️ My discord")
				).queue();
		
		
	}
}

package usercommands;
import utils.Check;
import utils.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class RemindCommand implements Command {
	@Override
	public void handle(SlashCommandInteractionEvent event) {
		
		if(!Check.GuildCheck(event)) return;
		
		String mention = event.getMember().getAsMention();
		String display = event.getMember().getEffectiveName();
		String avatar  = event.getMember().getEffectiveAvatarUrl();
		
		int time = event.getOption("minutes").getAsInt();
		long whenEpoch = java.time.Instant.now().plusSeconds(time).getEpochSecond();
		
		String text = event.getOption("message").getAsString();

		// 1) confirm
		EmbedBuilder confirm = new EmbedBuilder()
		        .setColor(new java.awt.Color(0x57F287)) // green "ok"
		        .setAuthor("Reminder set by " + display, null, avatar)
		        .setTitle("⏰ Reminder created")
		        .setDescription(mention + "\n> **" + text + "**")
		        .addField("Deliver", "<t:" + whenEpoch + ":R> • <t:" + whenEpoch + ":f>", false)
		        .setTimestamp(java.time.Instant.now()); // orario in basso

		event.replyEmbeds(confirm.build()).queue();

		// 2) delivery
		EmbedBuilder deliver = new EmbedBuilder()
		        .setColor(new java.awt.Color(0x5865F2)) // Discord violet
		        .setAuthor(display, null, avatar)
		        .setTitle("🔔 Reminder")
		        .setDescription(mention + "\n> **" + text + "**")
		        .setTimestamp(java.time.Instant.now().plusSeconds(time));

		event.getChannel()
		     .sendMessageEmbeds(deliver.build())
		     .queueAfter(time, java.util.concurrent.TimeUnit.MINUTES);
	}
}

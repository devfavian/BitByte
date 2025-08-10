package usercommands;
import utils.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class RemindCommand implements Command {
	@Override
	public void handle(MessageReceivedEvent event) {
		String raw = event.getMessage().getContentRaw().trim();
		String[] args = raw.split("\\s+", 3);
		
		EmbedBuilder embed = new EmbedBuilder();
		String mention = event.getMember().getAsMention();
		String display = event.getMember().getEffectiveName();
		String avatar  = event.getMember().getEffectiveAvatarUrl();
		
		if(args.length < 3) {
			embed
			.setColor(new java.awt.Color(0xED4245))
			.setAuthor("Reminder error — " + display, null, avatar)
			.setTitle("⏰ Invalid syntax")
			.addField("Usage", "`!Bremind <seconds> <message>`", false)
			.addField("Example", "`!Bremind 60 Drink water`", false)
			.setTimestamp(java.time.Instant.now());
			event.getChannel().sendMessageEmbeds(embed.build()).queue();
			return;
		}
		
		
		int time;
		
		try {
			time = Integer.parseInt(args[1]);
		}catch (NumberFormatException e) {     
            embed
            .setColor(new java.awt.Color(0xED4245)) // red "fail"
            .setAuthor("Reminder error — " + display, null, avatar)
            .setTitle("⏰ Invalid time")
            .setDescription("Time value should be a number.\n> **" + args[1] + "** is not valid.")
            .addField("Usage", "`!Bremind <seconds> <message>`", false)
            .addField("Example", "`!Bremind 60 Drink water`", false)
            .setTimestamp(java.time.Instant.now());
            event.getChannel().sendMessageEmbeds(embed.build()).queue();
            return;
		}
		
		
		//correct way
		
		String text = args[2];
		long whenEpoch = java.time.Instant.now().plusSeconds(time).getEpochSecond();

		// 1) confirm
		EmbedBuilder confirm = new EmbedBuilder()
		        .setColor(new java.awt.Color(0x57F287)) // green "ok"
		        .setAuthor("Reminder set by " + display, null, avatar)
		        .setTitle("⏰ Reminder created")
		        .setDescription(mention + "\n> **" + text + "**")
		        .addField("Deliver", "<t:" + whenEpoch + ":R> • <t:" + whenEpoch + ":f>", false)
		        .setTimestamp(java.time.Instant.now()); // orario in basso

		event.getChannel().sendMessageEmbeds(confirm.build()).queue();

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

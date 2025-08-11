package listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent; // slash
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import usercommands.*;
import admincommands.*;
import utils.SetRole;
import utils.WelcomeUtils;

public class BotListener extends ListenerAdapter{
	
	private final PingCommand pingCommand = new PingCommand();
	private final HelpCommand helpCommand = new HelpCommand();
	private final UserinfoCommand userinfoCommand = new UserinfoCommand();
	private final ClearCommand clearCommand = new ClearCommand();
	private final AvatarCommand avatarCommand = new AvatarCommand();
	private final ServericonCommand servericonCommand = new ServericonCommand();
	private final RemindCommand remindCommand = new RemindCommand();
	
	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		Member membro = event.getMember();
		MessageEmbed embed = WelcomeUtils.formatWelcomeMessage(membro);
		
		TextChannel canale = event.getGuild().getSystemChannel();
		if(canale != null) canale.sendMessageEmbeds(embed).queue();
		SetRole.roleOnJoin(membro);
	}
	
//    @Override
//    public void onMessageReceived(MessageReceivedEvent event) {
//    }
    
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    	switch (event.getName()) {
    		
    	case "ping" -> pingCommand.handle(event);
    	case "help" -> helpCommand.handle(event);
    	case "userinfo" -> userinfoCommand.handle(event);
    	case "clear" -> clearCommand.handle(event);
    	case "avatar" -> avatarCommand.handle(event);
    	case "servericon" -> servericonCommand.handle(event);
    	case "remind" -> remindCommand.handle(event);
    	
    	}
    }
}

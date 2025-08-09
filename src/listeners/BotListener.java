package listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import usercommands.HelpCommand;
import usercommands.PingCommand;
import usercommands.UserinfoCommand;
import usercommands.AvatarCommand;
import admincommands.ClearCommand;
import utils.SetRole;
import utils.WelcomeUtils;

public class BotListener extends ListenerAdapter{
	
	private final PingCommand pingCommand = new PingCommand();
	private final HelpCommand helpCommand = new HelpCommand();
	private final UserinfoCommand userinfoCommand = new UserinfoCommand();
	private final ClearCommand clearCommand = new ClearCommand();
	private final AvatarCommand avatarCommand = new AvatarCommand();
	
	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		Member membro = event.getMember();
		MessageEmbed embed = WelcomeUtils.formatWelcomeMessage(membro);
		
		TextChannel canale = event.getGuild().getSystemChannel();
		if(canale != null) canale.sendMessageEmbeds(embed).queue();
		SetRole.roleOnJoin(membro);
	}
	
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw();
        
        //DEBUG
        System.out.println("DEBUG event.getMessage(): " + event.getMessage());	
        System.out.println("DEBUG getContentDisplay(): [" + event.getMessage().getContentDisplay() + "]");
        System.out.println("DEBUG getContentRaw(): [" + event.getMessage().getContentRaw() + "]");
        System.out.println("DEBUG getType(): " + event.getMessage().getType());
        System.out.println("DEBUG isFromGuild(): " + event.isFromGuild());
        System.out.println("DEBUG rawContent: [" + event.getMessage().getContentRaw() + "]");
        System.out.println("DEBUG isSuppressed: " + event.getMessage().isSuppressedEmbeds());
        System.out.println("DEBUG raw JSON: " + event.getMessage().getContentStripped());

        if (message.equalsIgnoreCase("!Bhelp")) {
        	helpCommand.handle(event);
        }

        if (message.equalsIgnoreCase("!Bping")) {
            pingCommand.handle(event);
        }
        
        if (message.equalsIgnoreCase("!Buserinfo")) {
        	userinfoCommand.handle(event);
        }
        
        if (message.startsWith("!Bclear") || message.startsWith("!bclear")) {
        	clearCommand.handle(event);
        }
        
        if (message.startsWith("!Bavatar") || message.startsWith("!bavatar")) {
        	avatarCommand.handle(event);
        }
        
    }
}

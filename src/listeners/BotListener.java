package listeners;

import commands.PingCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter{
	
	private final PingCommand pingCommand = new PingCommand();
	
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw();
        
        //DEBUG
//        System.out.println("DEBUG event.getMessage(): " + event.getMessage());	
//        System.out.println("DEBUG getContentDisplay(): [" + event.getMessage().getContentDisplay() + "]");
//        System.out.println("DEBUG getContentRaw(): [" + event.getMessage().getContentRaw() + "]");
//        System.out.println("DEBUG getType(): " + event.getMessage().getType());
//        System.out.println("DEBUG isFromGuild(): " + event.isFromGuild());
//        System.out.println("DEBUG rawContent: [" + event.getMessage().getContentRaw() + "]");
//        System.out.println("DEBUG isSuppressed: " + event.getMessage().isSuppressedEmbeds());
//        System.out.println("DEBUG raw JSON: " + event.getMessage().getContentStripped());


        if (message.equalsIgnoreCase("!ping")) {
        	//DEBUG
        	//        	System.out.println("Comando ping riconosciuto!");
            pingCommand.handle(event);
        }
    }
}

package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class HelpCommand implements Command {
	@Override
    public void handle(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Commands:\n"
        		+ "\n"
        		+ "!Bhelp\n"
        		+ "!Bping").queue();
    }
}

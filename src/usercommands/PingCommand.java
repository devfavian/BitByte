package usercommands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import utils.Command;

public class PingCommand implements Command {
	@Override
    public void handle(MessageReceivedEvent event) {
        event.getChannel().sendMessage("pong!").queue();
    }
}

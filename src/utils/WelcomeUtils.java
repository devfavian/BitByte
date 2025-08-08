package utils;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;

public class WelcomeUtils {
    public static MessageEmbed formatWelcomeMessage(Member member) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Color.BLUE);					// <- put your favourite color
        embed.setTitle("Benvenuto");
        embed.setDescription("Ciao " + member.getAsMention() + ", benvenuto/a nel server!");
        embed.setThumbnail(member.getUser().getEffectiveAvatarUrl());
        return embed.build();
    }
}

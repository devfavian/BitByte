package utils;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public class SetRole {
	public static void roleOnJoin(Member member) {
		Role role1 = member.getGuild().getRoleById("1061035396433191092");		//	<- put your "ROLE_ID", you can find it in discord role section on your server
		
		if(role1 != null) {
	        member.getGuild().addRoleToMember(member, role1).queue();
		}  
		
		
		
		//multiple roles
		
		Role role2 = member.getGuild().getRoleById("1137340263891746876");
		
		if(role2 != null) {
	        member.getGuild().addRoleToMember(member, role2).queue();
		}  
	}
}

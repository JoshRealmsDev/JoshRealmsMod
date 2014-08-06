package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Shows you how to become a admin.", usage = "/<command> [announce]", aliases = "ai")
public class Command_ai extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if(args.length == 0)
        {
            
            playerMsg(ChatColor.AQUA + "The following is accurate as of 09/06/2014");
            playerMsg(ChatColor.AQUA + "To apply for admin you need to go to the forums at " + ChatColor.GOLD + TFM_ConfigEntry.SERVER_BAN_URL.getString());
            playerMsg(ChatColor.AQUA + "Then read the requirements.");
            playerMsg(ChatColor.AQUA + "Then if you feel you are ready, make a new thread in the appropriate board.");
            playerMsg(ChatColor.AQUA + "And fill out the template in the new thread.");
            playerMsg(ChatColor.RED + "We suggest you not to ask existing admins for recommendations, this will get your application denied.");
            playerMsg(ChatColor.AQUA + "Good Luck!");
            return true;
        }

        else if (args[0].equalsIgnoreCase("announce"))
        {
            if (!TFM_AdminList.isSuperAdmin(sender))
            {
                playerMsg(TotalFreedomMod.MSG_NO_PERMS);
                return true;
            }
            else
            {
                TFM_Util.bcastMsg(ChatColor.AQUA + "The following is accurate as of 09/06/2014");
                TFM_Util.bcastMsg(ChatColor.AQUA + "To apply for admin you need to go to the forums at " + ChatColor.GOLD + TFM_ConfigEntry.SERVER_BAN_URL.getString());
                TFM_Util.bcastMsg(ChatColor.AQUA + "Then read the requirements.");
                TFM_Util.bcastMsg(ChatColor.AQUA + "Then if you feel you are ready, make a new thread in the appropriate board.");
                TFM_Util.bcastMsg(ChatColor.AQUA + "And fill out the template in the new thread.");
                TFM_Util.bcastMsg(ChatColor.RED + "We suggest you not to ask existing admins for recommendations, this will get your application denied.");
                TFM_Util.bcastMsg(ChatColor.AQUA + "Good Luck!");
                return true;
            }
        }

        else
        {
            return false;
        }
    }
}
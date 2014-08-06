package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Runs the cleanup system.", usage = "/<command>")
public class Command_cleanup extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.bcastMsg(ChatColor.RED + "Starting Midnightly Clean Up - Expect Lag");

        if (senderIsConsole)
        {
            server.dispatchCommand(sender, "opall");
            server.dispatchCommand(sender, "clearall");
            server.dispatchCommand(sender, "backup");
            server.dispatchCommand(sender, "tfipbanlist purge");
            server.dispatchCommand(sender, "tfbanlist purge");
            server.dispatchCommand(sender, "wipeuserdata");
        TFM_Util.bcastMsg(ChatColor.GREEN + "Midnightly Clean Up Completed. Reloading Server");
            server.dispatchCommand(sender, "reload");
        }

        else
        {
            playerMsg(TotalFreedomMod.MSG_NO_PERMS);
            return true;
        }

        return true;
    }
}
package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Poop at someone? You gotta be kidding me...", usage = "/<command> [playername]")
public class Command_poop extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            TFM_Util.bcastMsg(sender.getName() + " is pooping all over the floor!!!", ChatColor.YELLOW);
        }
        else if (args.length == 1)
        {
            Player player = getPlayer(args[0]);

            if (player == null)
            {
                playerMsg(TotalFreedomMod.PLAYER_NOT_FOUND, ChatColor.RED);
                return true;
            }

            if (args[0].equalsIgnoreCase("kwteh") || args[0].equalsIgnoreCase("TheFlameGun"))
            {
                playerMsg("Don't try to poop at me...", ChatColor.RED);
            }
            else

            TFM_Util.bcastMsg(sender.getName() + " is pooping at " + player.getName() + ", AHH!!!", ChatColor.YELLOW);
            
        }
        return true;
    }
}

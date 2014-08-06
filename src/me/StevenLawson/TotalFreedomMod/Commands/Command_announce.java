package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import me.confuser.barapi.BarAPI;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Announce something", usage = "/<command> <message...>")
public class Command_announce extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!TFM_Util.SYSTEM.contains(sender.getName()))
        {
            playerMsg(TotalFreedomMod.MSG_NO_PERMS);
            return true;
        }
        if (args.length > 0)
        {
            TFM_Util.bcastMsg(String.format("§b[§eANNOUNCE§1|§e%s§b] §c%s", sender.getName(), StringUtils.join(args, " ")));
            for (final Player player : server.getOnlinePlayers())
            {
                if (BarAPI.hasBar(player))
                {
                    BarAPI.removeBar(player);
                    new BukkitRunnable()
                    {
                        @Override
                        public void run()
                        {
                            BarAPI.setMessage(player, ChatColor.DARK_RED + "WARNING: " + sender.getName() + " is making a announcement", 10);
                        }
                    }.runTaskLater(plugin, 2L * 20L);
                }
                else
                {
                    BarAPI.setMessage(player, ChatColor.DARK_RED + "WARNING: " + sender.getName() + " is making a announcement", 10);
                }
            }
        }
        return true;
    }
}
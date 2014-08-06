package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_ServerInterface;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "For the very bad players", usage = "/<command> <username>")
public class Command_oblivion extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!sender.getName().equals("kwteh"))
        {
            playerMsg(TotalFreedomMod.MSG_NO_PERMS);
        }
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }
        
        TFM_Util.adminAction(sender.getName(), "Casting a dark shadow of oblivion over " + player.getName(), true);
        TFM_Util.bcastMsg(player.getName() + " will be completely obliviated!", ChatColor.RED);
        final String IP = player.getAddress().getAddress().getHostAddress().trim();

        player.setWhitelisted(false);
        player.setOp(false);
        player.setGameMode(GameMode.SURVIVAL);
        player.closeInventory();
        player.getInventory().clear();
        player.setFireTicks(10000);
        player.getWorld().createExplosion(player.getLocation(), 4.0F);
        player.chat("AHHH!!!");

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                player.getWorld().strikeLightning(player.getLocation());
                if (TFM_AdminList.isSuperAdmin(player))
                {
                    TFM_Util.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list.", true);
                    TFM_AdminList.removeSuperadmin(player);
                }
            }
        }.runTaskLater(this.plugin, 40L);

        player.getWorld().createExplosion(player.getLocation(), 4.0F);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                player.getWorld().strikeLightning(player.getLocation());
                player.chat("NOOOOOOOO");
            }
        }.runTaskLater(this.plugin, 40L);

        TFM_Util.adminAction(player.getName(), "Has been Obliviated, may the hell continue ", true);
        player.setFireTicks(10000);
        for (String playerIp : TFM_PlayerList.getInstance().getEntry(player).getIps())
        {
            TFM_BanManager.getInstance().addIpBan(new TFM_Ban(playerIp, player.getName()));
        }
        TFM_BanManager.getInstance().addUuidBan(new TFM_Ban(player.getUniqueId(), player.getName()));
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                TFM_Util.adminAction(sender.getName(), "Has Obliviated: " + player.getName() + ", IP: " + IP, true);
                player.getWorld().createExplosion(player.getLocation(), 4.0F);
                player.kickPlayer(ChatColor.RED + "FUCKOFF, and get your shit together!");
            }
        }.runTaskLater(this.plugin, 80L);
        return true;
    }
}

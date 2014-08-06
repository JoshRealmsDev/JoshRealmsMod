package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Allows you to slam a bitch into the ground faster then you can type /doom", usage = "/<command> <partialname>")
public class Command_slam extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
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
        if (sender_p != null)
        {
            player.teleport(sender_p);
        }

        if (sender_p != null)
        {
            TotalFreedomMod.server.broadcastMessage(ChatColor.RED + sender_p.getName() + " slammed " + player.getName() + " into the ground using all there might!");
        }
        else
        {
            TotalFreedomMod.server.broadcastMessage(ChatColor.RED + sender.getName() + " slammed " + player.getName() + " into the ground using all there might!");
        }

        player.setOp(false);
        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().clear();
        Location playerLocation = player.getLocation();
        playerLocation.setY(150.0D);
        player.teleport(playerLocation);
        playerLocation.setY(player.getLocation().getY() - 1.0D);
        player.setHealth(0.0);
        player.setVelocity(new Vector(0, -10, 0));

        return true;
    }   

}